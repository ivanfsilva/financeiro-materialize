package br.com.ivanfsilva.financeiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TitulosController {

    private final String INDEX = "index";

    @RequestMapping
    public String index() {
        return INDEX;
    }
}
