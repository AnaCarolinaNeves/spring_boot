package br.gov.sp.fatec.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot.entity.Trabalho;
import br.gov.sp.fatec.springboot.repository.TrabalhoRepository;

@Service
public class TrabalhoService {
    
    @Autowired
    private TrabalhoRepository trabalhoRepo;

    public Trabalho cadastrarTrabalho(Trabalho trabalho) {
        if(trabalho == null ||
                trabalho.getTitulo() == null ||
                trabalho.getTitulo().isBlank() ||
                trabalho.getDataHoraEntrega() == null ||
                trabalho.getGrupo() == null ||
                trabalho.getGrupo().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos");
        }

        return trabalhoRepo.save(trabalho);
    }

    public List<Trabalho> buscarTodos() {
        return trabalhoRepo.findAll();
    }

    public Trabalho buscarPorId(Long id) {
        Optional<Trabalho> trabalhoOp = trabalhoRepo.findById(id);
        if(trabalhoOp.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trabalho não encontrado"); 
        }
        return trabalhoOp.get();
    }

}
