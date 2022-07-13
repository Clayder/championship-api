package com.clayder.championship.core.controller;

import com.clayder.championship.core.dto.AbstractDtoCore;
import com.clayder.championship.core.entity.AbstractCoreEntity;
import com.clayder.championship.core.exceptions.type.ObjectNotFoundException;
import com.clayder.championship.core.service.IServiceCore;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;

@RestController
public abstract class AbstractControllerCore<T extends AbstractCoreEntity, DTO extends AbstractDtoCore, ID extends Serializable> extends BaseAbstractControllerCore<T, DTO, ID> {

    public AbstractControllerCore(ModelMapper modelMapper, IServiceCore service) {
        super(modelMapper, service);
    }

    @PutMapping("{id}")
    public DTO update(@PathVariable Long id, @Valid @RequestBody DTO dto) {
        T entity = this.service.update(this.getModelMapper().map(dto, this.getEntityClass()), (ID) id);
        if (entity == null) {
            throw new ObjectNotFoundException("Nao encontrado");
        }
       return this.getModelMapper().map(entity, this.getDtoClass());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws Throwable {
        T entity = this.service
                .findById((ID) id)
                .orElseThrow(() -> new ObjectNotFoundException("Nao encontrado"));
        this.service.delete(entity);
    }
}
