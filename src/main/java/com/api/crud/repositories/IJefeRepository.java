package com.api.crud.repositories;

import com.api.crud.models.EmpresaModel;
import com.api.crud.models.JefepracModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJefeRepository extends JpaRepository<JefepracModel, Long> {
    Long id(Long id);
}
