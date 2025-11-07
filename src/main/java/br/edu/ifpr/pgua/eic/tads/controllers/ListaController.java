package br.edu.ifpr.pgua.eic.tads.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<Contato> lista = repositorio.listar();
        
        Map<String,Object> dados = new HashMap<>();
        dados.put("contatos",lista);
        dados.put("titulo","Lista de Contatos");
        dados.put("totalContatos",lista.size());

        ctx.render("list.html",dados);

    };

}
