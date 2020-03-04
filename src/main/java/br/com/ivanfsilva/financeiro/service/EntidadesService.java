package br.com.ivanfsilva.financeiro.service;

import br.com.ivanfsilva.financeiro.model.Entidade;
import br.com.ivanfsilva.financeiro.repository.Entidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntidadesService {

    @Autowired
    private Entidades entidades;

    public void salvar(Entidade entidade){
        entidades.save(entidade);
    }

    public void remover(Long codigo) {
        entidades.delete(codigo);
    }

}
