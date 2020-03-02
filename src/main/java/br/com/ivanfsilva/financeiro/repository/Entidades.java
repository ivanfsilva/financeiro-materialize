package br.com.ivanfsilva.financeiro.repository;

import br.com.ivanfsilva.financeiro.model.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entidades extends JpaRepository<Entidade, Long>{

}
