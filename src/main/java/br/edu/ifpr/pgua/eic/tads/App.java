package br.edu.ifpr.pgua.eic.tads;

import br.edu.ifpr.pgua.eic.tads.controllers.CadastroController;
import br.edu.ifpr.pgua.eic.tads.controllers.IndexController;
import br.edu.ifpr.pgua.eic.tads.controllers.ListaController;
import br.edu.ifpr.pgua.eic.tads.model.Agenda;
import br.edu.ifpr.pgua.eic.tads.utils.JavalinUtils;
import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        var app = JavalinUtils.makeApp(7070);
        
        Agenda agenda = new Agenda();

        IndexController indexController = new IndexController();
        CadastroController cadastroController = new CadastroController(agenda);
        ListaController listaController = new ListaController(agenda);

        app.get("/", indexController.get);
        app.get("/hello2",indexController.get2);
        app.get("/add",cadastroController.get);
        app.post("/add",cadastroController.post);
        app.get("/list",listaController.get);

    }
}
