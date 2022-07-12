package com.clayder.championship.core.controller;

import com.clayder.championship.core.dto.AbstractDtoCore;
import com.clayder.championship.core.entity.AbstractCoreEntity;
import com.clayder.championship.core.exceptions.type.ObjectNotFoundException;
import com.clayder.championship.core.service.IServiceCore;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public abstract class AbstractControllerCore<T extends AbstractCoreEntity, DTO extends AbstractDtoCore, ID extends Serializable> extends BaseAbstractControllerCore<T, DTO, ID> {

    public AbstractControllerCore(ModelMapper modelMapper, IServiceCore service) {
        super(modelMapper, service);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DTO create(@RequestBody @Valid DTO dto) {
        T entity = this.getModelMapper().map(dto, this.getEntityClass());
        entity = service.save(entity);
        return this.getModelMapper().map(entity, this.getDtoClass());
    }

    @PutMapping("{id}")
    public DTO update(@PathVariable Long id, @Valid @RequestBody DTO dto) {
        T entity = this.service.update(this.getModelMapper().map(dto, this.getEntityClass()), (ID) id);
        if (entity == null) {
            throw new ObjectNotFoundException("Nao encontrado");
        }
       return this.getModelMapper().map(entity, this.getDtoClass());
    }

    @GetMapping()
    public Page<DTO> getAll(DTO dto, Pageable pageRequest) {
        T filter = this.modelMapper.map(dto, this.getEntityClass());
        Page<T> result = this.service.findAll(filter, pageRequest);
        List<DTO> list = result.getContent()
                .stream()
                .map(entity -> this.modelMapper.map(entity, this.getDtoClass()))
                .collect(Collectors.toList());

        return new PageImpl<DTO>(list, pageRequest, result.getTotalElements());
    }
}
