package com.clayder.championship.core.repository;

import com.clayder.championship.core.entity.AbstractCoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface IRepositoryCore <T extends AbstractCoreEntity, ID extends Serializable> extends JpaRepository<T, ID> {

}
