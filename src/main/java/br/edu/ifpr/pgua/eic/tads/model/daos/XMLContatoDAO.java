package br.edu.ifpr.pgua.eic.tads.model.daos;

import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Contato;

public class XMLContatoDAO implements ContatoDAO{
    
    List<Contato> lista = new ArrayList<>();

    @Override
    public Resultado<Contato> salvar(Contato contato){
        System.out.println("Salvei o contato em XML!!!");
        lista.add(contato);

        return Resultado.sucesso("Contato salvo em XML!", contato);

    }

    @Override
    public Resultado<List<Contato>> listar(){
        System.out.println("Carregando e processando XML!!");
        return Resultado.sucesso("Lista XML carregada!", lista);
    } 
}
