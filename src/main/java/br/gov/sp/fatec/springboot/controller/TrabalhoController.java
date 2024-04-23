package br.gov.sp.fatec.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot.entity.Trabalho;
import br.gov.sp.fatec.springboot.service.TrabalhoService;

@RestController
@RequestMapping("/trabalho")
@CrossOrigin
public class TrabalhoController {
    
    @Autowired
    private TrabalhoService service;

    @GetMapping
    public List<Trabalho> buscarTodos() {
        return service.buscarTodos();
    }

    @PostMapping
    public Trabalho cadastrarTrabalho(@RequestBody Trabalho trabalho) {
        return service.cadastrarTrabalho(trabalho);
    }

    @GetMapping(value = "/{id}")
    public Trabalho buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

}
