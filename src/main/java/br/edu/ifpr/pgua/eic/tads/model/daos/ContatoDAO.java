package br.edu.ifpr.pgua.eic.tads.model.daos;

import java.util.List;

import br.edu.ifpr.pgua.eic.tads.model.Contato;

public interface ContatoDAO {
    //CRUD

    public String salvar(Contato contato);
    public List<Contato> listar();

    
}
