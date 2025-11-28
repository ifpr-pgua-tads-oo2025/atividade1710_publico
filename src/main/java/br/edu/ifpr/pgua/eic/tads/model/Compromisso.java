package br.edu.ifpr.pgua.eic.tads.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Compromisso {
    private int id;
    private LocalDateTime dataHora;
    private String descricao;
    private Categoria categoria;
    private List<Contato> convidados;
    
    public Compromisso(LocalDateTime dataHora, String descricao, Categoria categoria){
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.categoria = categoria;
    }
    
    public Compromisso(int id, LocalDateTime dataHora, String descricao, Categoria categoria) {
        this.id = id;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.categoria = categoria;
    }


    public List<Contato> getConvidados(){
        return convidados;
    }

    public void setConvidados(List<Contato> convidados){
        this.convidados = convidados;
    }


    public Categoria getCategoria(){
        return categoria;
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
