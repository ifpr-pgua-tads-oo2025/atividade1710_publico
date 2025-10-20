package br.edu.ifpr.pgua.eic.tads.controllers;

import java.util.List;

import br.edu.ifpr.pgua.eic.tads.model.Agenda;
import br.edu.ifpr.pgua.eic.tads.model.Contato;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ListaController {
    
    private Agenda agenda;
    
    public ListaController(Agenda agenda){
        this.agenda = agenda;
    }

    public Handler get = (Context ctx)->{

        List<Contato> lista = agenda.getLista();
        
        String retorno = "<ul>";
        for(Contato c:lista){
            retorno += "<li>"+c.toString()+"</li>";
        }
        retorno += "</ul>";

        ctx.html(retorno);

    };

}
