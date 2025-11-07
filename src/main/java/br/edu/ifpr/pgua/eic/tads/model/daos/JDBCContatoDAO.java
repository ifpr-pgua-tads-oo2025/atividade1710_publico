package br.edu.ifpr.pgua.eic.tads.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.ifpr.pgua.eic.tads.model.Contato;
import br.edu.ifpr.pgua.eic.tads.model.FabricaConexoes;

public class JDBCContatoDAO implements ContatoDAO{

    private FabricaConexoes fabrica;

    public JDBCContatoDAO(FabricaConexoes fabrica){
        this.fabrica = fabrica;
    }


    @Override
    public String salvar(Contato contato) {
        //1-Estabelecer uma conexão
        Connection con=null;
        
        try{
            con = fabrica.getConnection();
            
            String sql = "INSERT INTO oo_contatos(nome,telefone,email) VALUES (?,?,?)";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, contato.getNome());
            pstm.setString(2, contato.getTelefone());
            pstm.setString(3, contato.getEmail());

            int rows = pstm.executeUpdate();

            if(rows == 1){
                return "Contato cadastrado!";
            }else{
                return "Problema ao inserir o contato!";
            }


            
        }catch(SQLException e){
            e.printStackTrace();
            return "Erro SQL:"+e.getMessage();
        }
        
    
    }

    @Override
    public List<Contato> listar() {
        
        List<Contato> lista = new ArrayList<>();
        Connection con;
        
        try{
            con = fabrica.getConnection();
            String sql = "SELECT * FROM oo_contatos";
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet result = pstm.executeQuery();

            while(result.next()){
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String telefone = result.getString("telefone");
                String email = result.getString("email");

                Contato contato = new Contato(id,nome, telefone, email);
                lista.add(contato);
            }
            return Collections.unmodifiableList(lista);

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;   

    
    }


    
}
