package com.clayder.championship.api.repository;

import com.clayder.championship.api.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransferRepository extends JpaRepository<TransferEntity, Long> {
}
