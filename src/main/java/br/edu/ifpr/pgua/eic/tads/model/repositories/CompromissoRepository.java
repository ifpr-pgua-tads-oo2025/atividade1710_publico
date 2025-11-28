package br.edu.ifpr.pgua.eic.tads.model.repositories;

import java.time.LocalDateTime;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Categoria;
import br.edu.ifpr.pgua.eic.tads.model.Compromisso;
import br.edu.ifpr.pgua.eic.tads.model.Contato;
import br.edu.ifpr.pgua.eic.tads.model.daos.CategoriaDAO;
import br.edu.ifpr.pgua.eic.tads.model.daos.CompromissoDAO;

public class CompromissoRepository {
    
    private CompromissoDAO dao;
    private CategoriaDAO daoCategoria;

    public CompromissoRepository(CompromissoDAO dao, CategoriaDAO daoCategoria){
        this.dao = dao;
        this.daoCategoria = daoCategoria;
    }

    public Resultado<Compromisso> cadastrar(String descricao, LocalDateTime dataHora, Categoria categoria, List<Contato> convidados){
        Compromisso compromisso = new Compromisso(dataHora, descricao,categoria);
        compromisso.setConvidados(convidados);

        return dao.salvar(compromisso);
    }

    public Resultado<List<Compromisso>> listar(){
        
        Resultado<List<Compromisso>> resultado = dao.listar();

        if(resultado.foiSucesso()){
            List<Compromisso> lista = resultado.comoSucesso().getObj();
            for(Compromisso compromisso:lista){
                Resultado<Categoria> resultadoCategoria = daoCategoria.buscarCategoriaCompromisso(compromisso.getId());
                if(resultadoCategoria.foiSucesso()){
                    compromisso.setCategoria(resultadoCategoria.comoSucesso().getObj());
                }else{
                    return Resultado.erro(resultadoCategoria.getMsg());
                }
            }
        }

        return resultado;
        
        
    }
    
}
