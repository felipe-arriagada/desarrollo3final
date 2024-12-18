package com.api.crud.controllers;


import com.api.crud.models.EmpresaModel;
import com.api.crud.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/empresa")

public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping()
    public ArrayList<EmpresaModel> getEmpresas(){
        return empresaService.getEmpresas();
    }
    @PostMapping()
    public EmpresaModel saveEmpresa(@RequestBody EmpresaModel empresa){
        return empresaService.saveEmpresa(empresa);
    }
    @GetMapping(path = "/{id}")
    public Optional<EmpresaModel> getEmpresasById(@PathVariable("id") Long id) {
        return empresaService.getEmpresaById(id);
    }
    @PutMapping(path = "/{id}")
    public EmpresaModel updateEmpresaById(@RequestBody EmpresaModel request,@PathVariable Long id) {
        return empresaService.updateEmpresaById(request,id);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteEmpresaById(@PathVariable("id") Long id) {
        boolean ok = this.empresaService.deleteEmpresaById(id);

        if (ok) {
            return "The empresa id" + id + "Deleted";
        }else {
            return "empresa with id" + id + "Not found";
        }
    }
}
