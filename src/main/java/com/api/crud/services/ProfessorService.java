package com.api.crud.services;

import com.api.crud.models.ProfeModel;
import com.api.crud.models.UserModel;
import com.api.crud.repositories.IProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    IProfessorRepository professorRepository;

    public ArrayList<ProfeModel>getProfessors(){
        return (ArrayList<ProfeModel>) professorRepository.findAll();
    }
    public ProfeModel saveProfessor(ProfeModel user){
        return professorRepository.save(user);
}
    public Optional<ProfeModel> getProffesorById(Long id){
        return professorRepository.findById(id);
}
    public ProfeModel updateProffesorById(ProfeModel request,Long id){
        ProfeModel user = professorRepository.findById(id).get();

        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        return user;
    }
    public Boolean DeleteUser(Long id) {
        try{
            professorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
