package br.edu.ifpr.pgua.eic.tads;

import br.edu.ifpr.pgua.eic.tads.controllers.CadastroController;
import br.edu.ifpr.pgua.eic.tads.controllers.IndexController;
import br.edu.ifpr.pgua.eic.tads.controllers.ListaController;
import br.edu.ifpr.pgua.eic.tads.model.FabricaConexoes;
import br.edu.ifpr.pgua.eic.tads.model.daos.ContatoDAO;
import br.edu.ifpr.pgua.eic.tads.model.daos.JDBCContatoDAO;
import br.edu.ifpr.pgua.eic.tads.model.repositories.ContatoRepository;
import br.edu.ifpr.pgua.eic.tads.utils.JavalinUtils;
import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        var app = JavalinUtils.makeApp(7070);
        
        ContatoDAO contatoDAO = new JDBCContatoDAO(FabricaConexoes.getInstance());
        ContatoRepository repositorioContato = new ContatoRepository(contatoDAO);
        
        IndexController indexController = new IndexController();
        CadastroController cadastroController = new CadastroController(repositorioContato);
        ListaController listaController = new ListaController(repositorioContato);

        //rota
        app.get("/", indexController.get);
        app.get("/hello2",indexController.get2);

        app.get("/add",cadastroController.get);
        app.post("/add",cadastroController.post);
        
        app.get("/list",listaController.get);

    }
}
