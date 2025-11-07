package br.edu.ifpr.pgua.eic.tads.controllers;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifpr.pgua.eic.tads.model.repositories.ContatoRepository;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class CadastroController {
    
    private ContatoRepository repositorio;

    public CadastroController(ContatoRepository repositorio){
        this.repositorio = repositorio;
    }

    public Handler get = (Context ctx)->{
        ctx.render("add.html");
    };

    public Handler post = (Context ctx)->{
        String nome = ctx.formParam("nome");
        String email = ctx.formParam("email");
        String telefone = ctx.formParam("telefone");

        String retorno = repositorio.cadastrar(nome, email, telefone);

        Map<String,Object> dados = new HashMap<>();

        dados.put("mensagem",retorno);

        ctx.render("add.html",dados);
    };

}
