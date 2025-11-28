package br.edu.ifpr.pgua.eic.tads.model.repositories;

import java.time.LocalDateTime;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Categoria;
import br.edu.ifpr.pgua.eic.tads.model.Compromisso;
import br.edu.ifpr.pgua.eic.tads.model.Contato;
import br.edu.ifpr.pgua.eic.tads.model.daos.CategoriaDAO;
import br.edu.ifpr.pgua.eic.tads.model.daos.CompromissoDAO;
import br.edu.ifpr.pgua.eic.tads.model.daos.ContatoDAO;

public class CompromissoRepository {
    
    private CompromissoDAO dao;
    private CategoriaDAO daoCategoria;
    private ContatoDAO daoContato;

    public CompromissoRepository(CompromissoDAO dao, CategoriaDAO daoCategoria, ContatoDAO daoContato){
        this.dao = dao;
        this.daoCategoria = daoCategoria;
        this.daoContato = daoContato;
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

                Resultado<List<Contato>> resultadoContatos = daoContato.listarConvidadosCompromisso(compromisso.getId());
                if(resultadoContatos.foiSucesso()){
                    compromisso.setConvidados(resultadoContatos.comoSucesso().getObj());
                }else{
                    return Resultado.erro(resultadoContatos.getMsg());
                }
            }
        }

        return resultado;
        
        
    }
    
}
