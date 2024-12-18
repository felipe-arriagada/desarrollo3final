package com.api.crud.repositories;

import com.api.crud.models.ProfeModel;
import com.api.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfessorRepository extends JpaRepository<ProfeModel, Long> {
    Long id(Long id);

}
