package com.api.crud.services;

import com.api.crud.models.DetpracModel;
import com.api.crud.repositories.IPracRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PracticeService {

    @Autowired
    IPracRepository practiceRepository;

    public ArrayList<DetpracModel> getPractices(){
        return (ArrayList<DetpracModel>) practiceRepository.findAll();
    }
    public DetpracModel savePractice(DetpracModel practice){
        return practiceRepository.save(practice);
    }
    public Optional<DetpracModel> getPracticeById(Long id){
        return practiceRepository.findById(id);
    }
    public DetpracModel updatePracticeById(DetpracModel request,Long id){
        DetpracModel practica = practiceRepository.findById(id).get();

        practica.setFecha_inicio(request.getFecha_inicio());
        practica.setFecha_termino(request.getFecha_termino());
        practica.setDescripcion_practica(request.getDescripcion_practica());
        practica.setUserId(request.getUserId());
        practica.setTelefono(request.getTelefono());
        return practica;
    }

    public Boolean deletePractice(Long id) {
        try{
            practiceRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
