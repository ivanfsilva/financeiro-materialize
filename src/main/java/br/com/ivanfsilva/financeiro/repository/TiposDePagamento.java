package br.com.ivanfsilva.financeiro.repository;

import br.com.ivanfsilva.financeiro.model.TipoDePagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposDePagamento extends JpaRepository<TipoDePagamento, Long> {
}
