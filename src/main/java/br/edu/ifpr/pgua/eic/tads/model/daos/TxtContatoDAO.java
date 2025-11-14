package br.edu.ifpr.pgua.eic.tads.model.daos;

import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Contato;

public class TxtContatoDAO implements ContatoDAO{

    private List<Contato> lista;

    public TxtContatoDAO(){
        lista = new ArrayList<>();
    }


    @Override
    public Resultado<Contato> salvar(Contato contato) {
        lista.add(contato);
        System.out.println("Salvando contato no txt!!");

        return Resultado.sucesso("Contato salvo!", contato);
    }

    @Override
    public Resultado<List<Contato>> listar() {
        System.out.println("Lendo contatos do txt!!");
        return Resultado.sucesso("Lista de contatos", lista);
    }
    
}
