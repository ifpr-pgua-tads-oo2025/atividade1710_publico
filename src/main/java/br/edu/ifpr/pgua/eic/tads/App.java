package br.edu.ifpr.pgua.eic.tads;

import br.edu.ifpr.pgua.eic.tads.controllers.CadastroController;
import br.edu.ifpr.pgua.eic.tads.controllers.IndexController;
import br.edu.ifpr.pgua.eic.tads.controllers.ListaController;
import br.edu.ifpr.pgua.eic.tads.controllers.compromisso.CadastroCompromissoController;
import br.edu.ifpr.pgua.eic.tads.model.FabricaConexoes;
import br.edu.ifpr.pgua.eic.tads.model.daos.ContatoDAO;
import br.edu.ifpr.pgua.eic.tads.model.daos.JDBCContatoDAO;
import br.edu.ifpr.pgua.eic.tads.model.daos.TxtContatoDAO;
import br.edu.ifpr.pgua.eic.tads.model.daos.XMLContatoDAO;
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
        ContatoDAO contatoDAOTxt = new TxtContatoDAO();
        ContatoDAO contatoDAOXml = new XMLContatoDAO();

        ContatoRepository repositorioContato = new ContatoRepository(contatoDAOXml);
        
        IndexController indexController = new IndexController();
        CadastroController cadastroController = new CadastroController(repositorioContato);
        ListaController listaController = new ListaController(repositorioContato);

        CadastroCompromissoController cadastroCompromisso = new CadastroCompromissoController();

        //rota
        app.get("/", indexController.get);
        app.get("/hello2",indexController.get2);

        app.get("/add",cadastroController.get);
        app.post("/add",cadastroController.post);
        
        app.get("/list",listaController.get);

        app.get("/compromisso/add",cadastroCompromisso.get);
        app.post("/compromisso/add", cadastroCompromisso.post);

    }
}
