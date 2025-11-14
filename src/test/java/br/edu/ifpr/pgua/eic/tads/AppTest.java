package br.edu.ifpr.pgua.eic.tads;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Compromisso;
import br.edu.ifpr.pgua.eic.tads.model.FabricaConexoes;
import br.edu.ifpr.pgua.eic.tads.model.daos.CompromissoDAO;
import br.edu.ifpr.pgua.eic.tads.model.daos.JDBCCompromissoDAO;
import br.edu.ifpr.pgua.eic.tads.model.repositories.CompromissoRepository;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    @Test
    public void deveCadastarCompromisso(){

        CompromissoDAO dao = new JDBCCompromissoDAO(FabricaConexoes.getInstance());
        CompromissoRepository repositorio = new CompromissoRepository(dao);

        Resultado<Compromisso> resultado = repositorio.cadastrar("Reunião 1", LocalDateTime.of(2025, 11, 14, 11, 0, 0));

        assertTrue(resultado.foiSucesso());

        Compromisso compromisso = resultado.comoSucesso().getObj();

        assertEquals("Nome deve ser igual", "Reunião 1", compromisso.getDescricao());
        assertNotEquals(compromisso.getId(), 0);




    }


}
