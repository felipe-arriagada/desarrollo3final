package com.api.crud.services;

import com.api.crud.models.EmpresaModel;
import com.api.crud.repositories.IEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    IEmpresaRepository empresaRepository;

    public ArrayList<EmpresaModel> getEmpresas() {
        return (ArrayList<EmpresaModel>) empresaRepository.findAll();
    }

    public EmpresaModel saveEmpresa(EmpresaModel user) {
        return empresaRepository.save(user);
    }

    public Optional<EmpresaModel> getEmpresaById(Long id) {
        return empresaRepository.findById(id);
    }
    public EmpresaModel updateEmpresaById(EmpresaModel request,Long id){
        EmpresaModel user = empresaRepository.findById(id).get();

        user.setDireccion(request.getDireccion());
        user.setName(request.getName());
        user.setTelefono(request.getTelefono());
        return user;
    }
    public Boolean deleteEmpresaById(Long id) {
        try{
            empresaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}