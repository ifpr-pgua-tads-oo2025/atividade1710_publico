package br.edu.ifpr.pgua.eic.tads.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Compromisso {
    private int id;
    private LocalDateTime dataHora;
    private String descricao;
    
    public Compromisso(LocalDateTime dataHora, String descricao){
        this.dataHora = dataHora;
        this.descricao = descricao;
    }
    
    public Compromisso(int id, LocalDateTime dataHora, String descricao) {
        this.id = id;
        this.dataHora = dataHora;
        this.descricao = descricao;
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
