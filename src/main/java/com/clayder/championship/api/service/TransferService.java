package com.clayder.championship.api.service;

import com.clayder.championship.api.entity.TransferEntity;
import com.clayder.championship.api.repository.ITransferRepository;
import com.clayder.championship.core.exceptions.type.BusinessException;
import com.clayder.championship.core.service.AbstractServiceCore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class TransferService extends AbstractServiceCore<TransferEntity, Long> implements ITransferService {

    IPlayerService playerService;
    ITeamService teamService;
    ITransferRepository repository;

    public TransferService(
            ITransferRepository repository,
            ITeamService teamService,
            IPlayerService playerService
    ) {
        super(repository);
        this.playerService = playerService;
        this.teamService = teamService;
        this.repository = repository;
    }

    @Override
    public TransferEntity transfer(Long idPlayer, Long idTeam, TransferEntity data) {
        var destinationTeam = teamService.getById(idTeam);
        var player = playerService.getById(idPlayer);

        if(Objects.equals(destinationTeam.getId(), player.getTeam().getId())) {
            throw new BusinessException("Player is already on this team");
        }

        data.setOriginTeam(player.getTeam());
        data.setDestinationTeam(destinationTeam);
        TransferEntity transfer = repository.save(data);

        player.setTeam(destinationTeam);
        playerService.update(player);
        return transfer;
    }
}
