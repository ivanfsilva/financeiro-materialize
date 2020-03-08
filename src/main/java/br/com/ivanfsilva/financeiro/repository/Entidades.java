package br.com.ivanfsilva.financeiro.repository;

import br.com.ivanfsilva.financeiro.dto.EntidadeDTO;
import br.com.ivanfsilva.financeiro.model.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Entidades extends JpaRepository<Entidade, Long>{

    List<Entidade> findByNomeContainingIgnoreCase(String nome);

    @Query("select e from Entidade e where nome like %?1% or ?1 is null")
    List<Entidade> porNome(String nome);

    @Query("select new br.com.ivanfsilva.financeiro.dto.EntidadeDTO(codigo, nome) from Entidade where lower(nome) like %?1%")
    List<EntidadeDTO> filtradas(String nome);
}
