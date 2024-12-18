package com.api.crud.services;

import com.api.crud.models.EmpresaModel;
import com.api.crud.models.JefepracModel;
import com.api.crud.repositories.IJefeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JefeService {
    @Autowired
    IJefeRepository jefeRepository;

    public ArrayList<JefepracModel> getJefes() {
        return (ArrayList<JefepracModel>)jefeRepository.findAll();
    }
    public JefepracModel saveJefe(JefepracModel user) {
        return jefeRepository.save(user);
    }
    public Optional<JefepracModel> getJefeById(Long id) {
        return jefeRepository.findById(id);
    }
    public JefepracModel updateJefeById(JefepracModel request,Long id){
        JefepracModel user = jefeRepository.findById(id).get();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setTelefono(request.getTelefono());
        return user;
    }
    public Boolean deleteJefeById(Long id) {
        try{
            jefeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
