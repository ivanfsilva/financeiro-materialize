package br.com.ivanfsilva.financeiro.controller;

import br.com.ivanfsilva.financeiro.model.Situacao;
import br.com.ivanfsilva.financeiro.model.Tipo;
import br.com.ivanfsilva.financeiro.model.Titulo;
import br.com.ivanfsilva.financeiro.repository.Entidades;
import br.com.ivanfsilva.financeiro.repository.TiposDePagamento;
import br.com.ivanfsilva.financeiro.service.TitulosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/titulos")
public class TitulosController {

    private final String INDEX = "titulo/CadastroTitulo";

    @Autowired
    private Entidades entidades;

    @Autowired
    private TitulosService titulosService;

    @Autowired
    private TiposDePagamento tiposDePagamento;

    @RequestMapping(value = "/novo")
    public ModelAndView novo(Titulo titulo){
        ModelAndView mv = new ModelAndView(INDEX);
        mv.addObject("listaDeEntidades", entidades.findAll());
        mv.addObject("todosOsTipos", Tipo.values());
        mv.addObject("todasAsSituacoes", Situacao.values());
        mv.addObject("tiposDePagamento", tiposDePagamento.findAll());
        return mv;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView salvar(@Valid Titulo titulo, BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors()) {
            return novo(titulo);
        }

        titulo.setDataDeEmissao(new Date());
        titulosService.salvar(titulo);
        attributes.addFlashAttribute("mensagem", "Título salvo com sucesso");

        return new ModelAndView("redirect:/titulos/novo");
    }

}
