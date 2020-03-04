package br.com.ivanfsilva.financeiro.controller;

import br.com.ivanfsilva.financeiro.model.Situacao;
import br.com.ivanfsilva.financeiro.model.Tipo;
import br.com.ivanfsilva.financeiro.model.Titulo;
import br.com.ivanfsilva.financeiro.repository.Entidades;
import br.com.ivanfsilva.financeiro.service.TitulosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/titulos")
public class TitulosController {

    private final String INDEX = "titulo/CadastroTitulo";

    @Autowired
    private Entidades entidades;

    @Autowired
    private TitulosService titulosService;

    @RequestMapping(value = "/novo")
    public ModelAndView index(Titulo titulo){
        ModelAndView mv = new ModelAndView(INDEX);
        mv.addObject("listaDeEntidades", entidades.findAll());
        mv.addObject("todosOsTipos", Tipo.values());
        mv.addObject("todasAsSituacoes", Situacao.values());
        return mv;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView salvar(Titulo titulo){

        titulosService.salvar(titulo);

        return new ModelAndView("redirect:/titulos/novo");
    }

}
