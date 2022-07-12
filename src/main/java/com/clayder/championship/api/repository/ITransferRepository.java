package com.clayder.championship.api.repository;

import com.clayder.championship.api.entity.TransferEntity;
import com.clayder.championship.core.repository.IRepositoryCore;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransferRepository extends IRepositoryCore<TransferEntity, Long> {
}
