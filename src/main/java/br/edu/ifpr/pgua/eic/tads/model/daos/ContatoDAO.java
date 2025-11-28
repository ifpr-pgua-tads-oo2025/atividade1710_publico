package br.edu.ifpr.pgua.eic.tads.model.daos;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Contato;

public interface ContatoDAO {
    //CRUD

    public Resultado<Contato> salvar(Contato contato);
    public Resultado<List<Contato>> listar();
    public Resultado<List<Contato>> listarConvidadosCompromisso(int idCompromisso);

    
}
