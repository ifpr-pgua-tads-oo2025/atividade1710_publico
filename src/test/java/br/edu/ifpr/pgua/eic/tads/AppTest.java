package br.edu.ifpr.pgua.eic.tads;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Categoria;
import br.edu.ifpr.pgua.eic.tads.model.Compromisso;
import br.edu.ifpr.pgua.eic.tads.model.Contato;
import br.edu.ifpr.pgua.eic.tads.model.FabricaConexoes;
import br.edu.ifpr.pgua.eic.tads.model.daos.CategoriaDAO;
import br.edu.ifpr.pgua.eic.tads.model.daos.CompromissoDAO;
import br.edu.ifpr.pgua.eic.tads.model.daos.ContatoDAO;
import br.edu.ifpr.pgua.eic.tads.model.daos.JDBCCategoriaDAO;
import br.edu.ifpr.pgua.eic.tads.model.daos.JDBCCompromissoDAO;
import br.edu.ifpr.pgua.eic.tads.model.daos.JDBCContatoDAO;
import br.edu.ifpr.pgua.eic.tads.model.repositories.CompromissoRepository;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    @Test
    public void deveCadastarCompromisso(){

        CompromissoDAO dao = new JDBCCompromissoDAO(FabricaConexoes.getInstance());
        CategoriaDAO daoCategoria = new JDBCCategoriaDAO(FabricaConexoes.getInstance());
        ContatoDAO daoContato = new JDBCContatoDAO(FabricaConexoes.getInstance());
        
        CompromissoRepository repositorio = new CompromissoRepository(dao,daoCategoria);

        Resultado<List<Contato>> resultadoContatos= daoContato.listar();

        List<Contato> contatos = resultadoContatos.comoSucesso().getObj().subList(0,1);

        Resultado<List<Categoria>> resultadoCategoria = daoCategoria.listar();

        Categoria categoria = resultadoCategoria.comoSucesso().getObj().get(0);

        Resultado<Compromisso> resultado = repositorio.cadastrar("Churrasco", LocalDateTime.of(2025, 11, 14, 11, 0, 0),categoria,contatos);

        System.out.println(resultado.getMsg());

        assertTrue(resultado.foiSucesso());

        Compromisso compromisso = resultado.comoSucesso().getObj();

        assertEquals("Nome deve ser igual", "Reunião 1", compromisso.getDescricao());
        assertNotEquals(compromisso.getId(), 0);
    }

    @Test
    public void deveRecuperarCompromissos(){

        CompromissoDAO dao = new JDBCCompromissoDAO(FabricaConexoes.getInstance());
        CategoriaDAO daoCategoria = new JDBCCategoriaDAO(FabricaConexoes.getInstance());
        CompromissoRepository repositorio = new CompromissoRepository(dao,daoCategoria);

        Resultado<List<Compromisso>> resultado = repositorio.listar();

        assertTrue(resultado.foiSucesso());
        
        List<Compromisso> lista = resultado.comoSucesso().getObj();

        assertEquals(1, lista.size());

        System.out.println(lista.get(0).getCategoria().getNome());

    }


}
