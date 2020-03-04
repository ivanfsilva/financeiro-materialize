package br.com.ivanfsilva.financeiro.repository;

import br.com.ivanfsilva.financeiro.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Titulos extends JpaRepository<Titulo, Long> {

}
