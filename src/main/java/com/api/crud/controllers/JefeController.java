package com.api.crud.controllers;


import com.api.crud.models.DetpracModel;
import com.api.crud.models.JefepracModel;
import com.api.crud.services.JefeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/jefe")

public class JefeController {
    @Autowired
    private JefeService jefeService;

    @GetMapping()
    public ArrayList<JefepracModel>getJefes(){
        return jefeService.getJefes();
    }

    @PostMapping()
    public JefepracModel savePractice(@RequestBody JefepracModel jefe) {
        return jefeService.saveJefe(jefe);
    }
    @GetMapping(path = "/{id}")
    public Optional<JefepracModel> getPracticesById(@PathVariable("id") Long id) {
        return jefeService.getJefeById(id);
    }
    @PutMapping(path = "/{id}")
    public JefepracModel updatePracticeById(@RequestBody JefepracModel request,@PathVariable Long id) {
        return jefeService.updateJefeById(request,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePracticeById(@PathVariable("id") Long id) {
        boolean ok = this.jefeService.deleteJefeById(id);

        if (ok) {
            return "The boss id" + id + "Deleted";
        }else {
            return "boss with id" + id + "Not found";
        }
    }
}
