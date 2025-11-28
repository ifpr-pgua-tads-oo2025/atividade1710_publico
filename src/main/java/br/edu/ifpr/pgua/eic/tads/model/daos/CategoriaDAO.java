package br.edu.ifpr.pgua.eic.tads.model.daos;

import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Categoria;

public interface CategoriaDAO {
    
    public Resultado<Categoria> salvar(Categoria categoria);
    public Resultado<List<Categoria>> listar();
    public Resultado<Categoria> buscarCategoriaCompromisso(int idCompromisso);

}
