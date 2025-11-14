package br.edu.ifpr.pgua.eic.tads.model.repositories;

import java.time.LocalDateTime;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Compromisso;
import br.edu.ifpr.pgua.eic.tads.model.daos.CompromissoDAO;

public class CompromissoRepository {
    
    private CompromissoDAO dao;

    public CompromissoRepository(CompromissoDAO dao){
        this.dao = dao;
    }

    public Resultado<Compromisso> cadastrar(String descricao, LocalDateTime dataHora){
        Compromisso compromisso = new Compromisso(dataHora, descricao);

        return dao.salvar(compromisso);
    }

    public Resultado<List<Compromisso>> listar(){
        return dao.listar();
    }
    
}
