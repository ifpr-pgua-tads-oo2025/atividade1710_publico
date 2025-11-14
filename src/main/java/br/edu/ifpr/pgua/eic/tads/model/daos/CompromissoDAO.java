package br.edu.ifpr.pgua.eic.tads.model.daos;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Compromisso;

public interface CompromissoDAO {
    

    public Resultado<Compromisso> salvar(Compromisso compromisso);
    public Resultado<List<Compromisso>> listar();
}
