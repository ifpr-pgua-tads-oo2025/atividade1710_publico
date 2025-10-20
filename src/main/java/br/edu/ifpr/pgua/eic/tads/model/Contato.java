package br.edu.ifpr.pgua.eic.tads.model;

public class Contato {

    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome(){
        return nome;
    }

    public String toString(){
        return "Nome:"+nome+" Telefone:"+telefone+" Email:"+email;
    }
}
