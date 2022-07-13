package com.clayder.championship.api.controller;

import com.clayder.championship.api.dto.transfer.TransferDtoRequest;
import com.clayder.championship.api.dto.transfer.TransferDtoResponse;
import com.clayder.championship.api.entity.TransferEntity;
import com.clayder.championship.api.service.ITransferService;
import com.clayder.championship.core.controller.BaseAbstractControllerCore;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1/transfer")
public class TransferController extends BaseAbstractControllerCore<TransferEntity, TransferDtoResponse, Long> {

    ITransferService service;

    public TransferController(ModelMapper modelMapper, ITransferService service) {
        super(modelMapper, service);
        this.service = service;
    }

    @Override
    protected Class<TransferDtoResponse> getDtoClass() {
        return TransferDtoResponse.class;
    }

    @Override
    protected Class<TransferEntity> getEntityClass() {
        return TransferEntity.class;
    }

    @PostMapping("/players/{idPlayer}/destination_team/{idTeam}")
    public ResponseEntity<TransferDtoResponse> create(
            @Valid @RequestBody TransferDtoRequest dto,
            @PathVariable Long idPlayer,
            @PathVariable Long idTeam
    ) {
        TransferEntity map = modelMapper.map(dto, TransferEntity.class);
        TransferEntity transfer = service.transfer(
                idPlayer,
                idTeam,
                map
        );
        TransferDtoResponse map1 = modelMapper.map(transfer, TransferDtoResponse.class);
        return ResponseEntity.ok(map1);
    }
}
