package br.edu.ifpr.pgua.eic.tads.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Categoria;
import br.edu.ifpr.pgua.eic.tads.model.Compromisso;
import br.edu.ifpr.pgua.eic.tads.model.FabricaConexoes;

public class JDBCCategoriaDAO implements CategoriaDAO{

    private FabricaConexoes fabrica;

    public JDBCCategoriaDAO(FabricaConexoes fabrica){
        this.fabrica = fabrica;
    }


    @Override
    public Resultado<Categoria> salvar(Categoria categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'salvar'");
    }

    @Override
    public Resultado<List<Categoria>> listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM Categoria";
        try(Connection con = fabrica.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet resultSet = pstmt.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                
                Categoria categoria = new Categoria(id,nome);
                lista.add(categoria);
            }

            return Resultado.sucesso("Lista de categorias!", lista);

        }catch(SQLException e){
            e.printStackTrace();
            return Resultado.erro(e.getMessage());
        }
    }

    @Override
    public Resultado<Categoria> buscarCategoriaCompromisso(int idCompromisso) {
        
        String sql = "SELECT * FROM Categoria INNER JOIN oo_compromissos";
               sql +=" ON Categoria.id = oo_compromissos.idCategoria WHERE oo_compromissos.id = ?";
        
        try(Connection con = fabrica.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, idCompromisso);

            ResultSet resultSet = pstmt.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                
                Categoria categoria = new Categoria(id,nome);
                return Resultado.sucesso("Categoria carregada", categoria);
            }

            return Resultado.erro("Categoria não encontrada");

        }catch(SQLException e){
            e.printStackTrace();
            return Resultado.erro(e.getMessage());
        }
    }
    
}
