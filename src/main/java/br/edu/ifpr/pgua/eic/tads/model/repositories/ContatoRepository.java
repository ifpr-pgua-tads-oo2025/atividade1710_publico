package br.edu.ifpr.pgua.eic.tads.model.repositories;

import java.util.List;

import br.edu.ifpr.pgua.eic.tads.model.Contato;
import br.edu.ifpr.pgua.eic.tads.model.daos.ContatoDAO;

public class ContatoRepository {
    
    private ContatoDAO dao;
    
    public ContatoRepository(ContatoDAO dao){
        this.dao = dao;
    }

    public String cadastrar(String nome, String telefone, String email){

        Contato contato = new Contato(nome, telefone, email);
        return dao.salvar(contato);

    }

    public List<Contato> listar(){
        return dao.listar();
    }


}
