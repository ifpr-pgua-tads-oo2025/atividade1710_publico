package br.edu.ifpr.pgua.eic.tads.controllers;

import java.util.HashMap;
import java.util.Map;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Contato;
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

        Resultado<Contato> resultado = repositorio.cadastrar(nome, email, telefone);

        Map<String,Object> dados = new HashMap<>();

        if(resultado.foiSucesso()){
            dados.put("mensagem",resultado.getMsg());
        }else{
            dados.put("erro",resultado.getMsg());
        }

        
        ctx.render("add.html",dados);
    };

}
