package com.clayder.championship.api.service;

import com.clayder.championship.api.entity.TransferEntity;
import com.clayder.championship.core.service.IServiceCore;

public interface ITransferService extends IServiceCore<TransferEntity, Long> {
    TransferEntity transfer(Long idPlayer, Long idTeam, TransferEntity data);
}
