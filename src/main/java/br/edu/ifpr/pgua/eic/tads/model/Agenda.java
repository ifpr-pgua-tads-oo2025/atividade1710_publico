package br.edu.ifpr.pgua.eic.tads.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agenda {
    

    private ArrayList<Contato> lista;
    

    public Agenda(){
        lista = new ArrayList<>();
    }

    public String cadastrar(String nome, String email, String telefone){
        Contato contato = new Contato(nome, telefone, email);
        lista.add(contato);

        return "Contato cadastrado!";
    }

    public List<Contato> getLista(){
        return Collections.unmodifiableList(lista);
    }

}
