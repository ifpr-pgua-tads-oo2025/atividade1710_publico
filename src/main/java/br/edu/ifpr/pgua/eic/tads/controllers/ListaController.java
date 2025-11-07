package br.edu.ifpr.pgua.eic.tads.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Contato;
import br.edu.ifpr.pgua.eic.tads.model.repositories.ContatoRepository;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ListaController {
    
    private ContatoRepository repositorio;
    
    public ListaController(ContatoRepository repositorio){
        this.repositorio = repositorio;
    }

    public Handler get = (Context ctx)->{

        Resultado<List<Contato>> resultado = repositorio.listar();
        
        Map<String,Object> dados = new HashMap<>();
        
        if(resultado.foiSucesso()){
            dados.put("contatos",resultado.comoSucesso().getObj());
            dados.put("totalContatos",resultado.comoSucesso().getObj().size());
        }else{
            dados.put("erro",resultado.getMsg());
        }
        
        dados.put("titulo","Lista de Contatos");

        ctx.render("list.html",dados);

    };

}
