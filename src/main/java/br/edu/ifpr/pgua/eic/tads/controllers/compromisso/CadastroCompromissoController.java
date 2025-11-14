package br.edu.ifpr.pgua.eic.tads.controllers.compromisso;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Contato;
import br.edu.ifpr.pgua.eic.tads.model.repositories.ContatoRepository;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class CadastroCompromissoController {
    
    
    public CadastroCompromissoController(){
        
    }

    public Handler get = (Context ctx)->{
        ctx.render("compromisso/add.html");
    };

    public Handler post = (Context ctx)->{
        String descricao = ctx.formParam("descricao");
        String data = ctx.formParam("data");
        String hora = ctx.formParam("hora");
        LocalDateTime dataHora = LocalDateTime.parse(data+"T"+hora);


    };

}
