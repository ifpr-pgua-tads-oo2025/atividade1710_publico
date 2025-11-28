package br.edu.ifpr.pgua.eic.tads.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.model.Compromisso;
import br.edu.ifpr.pgua.eic.tads.model.Contato;
import br.edu.ifpr.pgua.eic.tads.model.FabricaConexoes;
import br.edu.ifpr.pgua.eic.tads.utils.DBUtils;

public class JDBCCompromissoDAO implements CompromissoDAO {
    

    private FabricaConexoes fabricaConexoes;

    public JDBCCompromissoDAO(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }

    public Resultado<Compromisso> salvar(Compromisso compromisso){
        
        String sql = "INSERT INTO oo_compromissos(descricao,dataHora,idCategoria) VALUES (?,?,?)";

        try(Connection con = fabricaConexoes.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, compromisso.getDescricao());
            pstmt.setTimestamp(2, Timestamp.valueOf(compromisso.getDataHora()));
            pstmt.setInt(3, compromisso.getCategoria().getId());

            int rows = pstmt.executeUpdate();
            if(rows == 1){
                int id = DBUtils.getLastId(pstmt);
                compromisso.setId(id);

                String sql2 = "INSERT INTO contatos_compromissos(idCompromisso,idContato) VALUES(?,?)";
                PreparedStatement pstmt2 = con.prepareStatement(sql2);

                for(Contato contato:compromisso.getConvidados()){
                    pstmt2.setInt(1, id);
                    pstmt2.setInt(2, contato.getId());

                    pstmt2.executeUpdate();
                }
                pstmt2.close();


                return Resultado.sucesso("Compromisso salvo!", compromisso);
            }else{
                return Resultado.erro("Erro ao inserir compromisso!!");
            }
        }catch(SQLException e){
            e.printStackTrace();
            return Resultado.erro(e.getMessage());
        }
    }

    public Resultado<List<Compromisso>> listar(){
        
        List<Compromisso> lista = new ArrayList<>();
        String sql = "SELECT * FROM oo_compromissos";
        try(Connection con = fabricaConexoes.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet resultSet = pstmt.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String descricao = resultSet.getString("descricao");
                LocalDateTime dataHora = resultSet.getTimestamp("dataHora").toLocalDateTime();
                
                Compromisso compromisso = new Compromisso(id,dataHora, descricao,null);
                lista.add(compromisso);
            }

            return Resultado.sucesso("Lista de compromissos!", lista);

        }catch(SQLException e){
            e.printStackTrace();
            return Resultado.erro(e.getMessage());
        }

    }



}
