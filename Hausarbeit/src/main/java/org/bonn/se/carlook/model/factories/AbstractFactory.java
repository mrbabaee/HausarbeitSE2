package org.bonn.se.carlook.model.factories;

import org.bonn.se.carlook.model.objects.dto.BaseDTO;
import org.bonn.se.carlook.model.objects.entities.BaseEntity;

public interface AbstractFactory<E extends BaseEntity, D extends BaseDTO> {

    public E createEntity();

    public D createDTO();

    public E createEntityFromDTO(D dto);

    public D createDTOFromEntity(E entity);
}
