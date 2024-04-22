package br.gov.sp.fatec.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {

    @Query("select t from Trabalho t where t.titulo like %?1% and t.nota > ?2")
    public List<Trabalho> findByTituloNota(String titulo, int nota);
}
