package com.api.crud.repositories;

import com.api.crud.models.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpresaRepository extends JpaRepository<EmpresaModel, Long> {
    Long id(Long id);
}

