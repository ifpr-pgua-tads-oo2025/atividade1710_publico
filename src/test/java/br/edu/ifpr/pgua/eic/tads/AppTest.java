package br.edu.ifpr.pgua.eic.tads;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import br.edu.ifpr.pgua.eic.tads.model.Agenda;
import br.edu.ifpr.pgua.eic.tads.model.Compromisso;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Agenda agenda = new Agenda();

        agenda.cadastrarCompromisso(LocalDateTime.now(), "Teste 1");
    }

    @Test
    public void ListarCompromissos(){
        Agenda agenda = new Agenda();

        List<Compromisso> lista = agenda.listarCompromissos();

        for(Compromisso c:lista){
            System.out.println(c.getDataHora());
        }
    }
}
