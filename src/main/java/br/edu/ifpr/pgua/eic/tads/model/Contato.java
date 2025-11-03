package br.edu.ifpr.pgua.eic.tads.model;

public class Contato {
    private int id;
    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Contato(int id, String nome, String telefone, String email){
        this(nome,telefone,email);
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public String toString(){
        return "Nome:"+nome+" Telefone:"+telefone+" Email:"+email;
    }
}
