package com.api.crud.controllers;


import com.api.crud.models.DetpracModel;
import com.api.crud.models.UserModel;
import com.api.crud.services.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
///  convierte automáticamente los objetos Java en respuestas JSON o XML para APIs RESTful.
@RequestMapping("/practices")
public class PracticeController {
    @Autowired
    private PracticeService practiceService;

    @GetMapping()
    public ArrayList<DetpracModel> getPractices() {
        return practiceService.getPractices();
    }

    @PostMapping()
    public DetpracModel savePractice(@RequestBody DetpracModel practice) {
        return practiceService.savePractice(practice);
    }


    @GetMapping(path = "/{id}")
    public Optional<DetpracModel> getPracticesById(@PathVariable("id") Long id) {
        return practiceService.getPracticeById(id);
    }
    @PutMapping(path = "/{id}")
    public DetpracModel updatePracticeById(@RequestBody DetpracModel request,@PathVariable Long id) {
        return practiceService.updatePracticeById(request,id);
    }
    @DeleteMapping(path = "/{id}")
    public String deletePracticeById(@PathVariable("id") Long id) {
        boolean ok = this.practiceService.deletePractice(id);

        if (ok) {
            return "The practice id" + id + "Deleted";
        }else {
            return "Practice with id" + id + "Not found";
        }
    }
}

