package br.com.ivanfsilva.financeiro.service;

import br.com.ivanfsilva.financeiro.model.Titulo;
import br.com.ivanfsilva.financeiro.repository.Titulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitulosService {

    @Autowired
    private Titulos titulos;

    public void salvar(Titulo titulo){
        titulos.save(titulo);
    }

    public void excluir(Long codigo) {
        titulos.delete(codigo);
    }
}
