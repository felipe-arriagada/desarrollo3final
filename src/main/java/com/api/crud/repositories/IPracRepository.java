package com.api.crud.repositories;

import com.api.crud.models.DetpracModel;
import com.api.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPracRepository extends JpaRepository<DetpracModel, Long> {
    Long id(Long id);
}