package br.com.ivanfsilva.financeiro.repository;

import br.com.ivanfsilva.financeiro.model.Entidade;
import br.com.ivanfsilva.financeiro.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Titulos extends JpaRepository<Titulo, Long> {

    @Query("select t from Titulo t where t.descricao like %?1% and (t.entidade = ?2 or ?2 is null)")
    List<Titulo> filtrados(String descricao, Entidade entidade);

}
