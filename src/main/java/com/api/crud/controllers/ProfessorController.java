package com.api.crud.controllers;

import com.api.crud.models.ProfeModel;
import com.api.crud.models.UserModel;
import com.api.crud.services.ProfessorService;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/proffesors")

public class ProfessorController {
    @Autowired
    private ProfessorService professorservice;

    @GetMapping()
    public ArrayList<ProfeModel> getProfessors() {
        return professorservice.getProfessors();
    }
    @PostMapping
    public ProfeModel saveProfessor(@RequestBody ProfeModel user) {
        return professorservice.saveProfessor(user);

    }
    @GetMapping(path = "/{id}")
    public Optional<ProfeModel> getProffesorById(@PathVariable ("id")Long id) {
        return professorservice.getProffesorById(id);
    }

    @PutMapping(path = "/{id}")
    public ProfeModel updateProffesorById(@RequestBody ProfeModel request,@PathVariable Long id) {
        return professorservice.updateProffesorById(request,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.professorservice.DeleteUser(id);

        if (ok) {
            return "proffesor with id" + id + "Deleted";
        }else {
            return "proffesor with id" + id + "Not found";
        }
    }
}
