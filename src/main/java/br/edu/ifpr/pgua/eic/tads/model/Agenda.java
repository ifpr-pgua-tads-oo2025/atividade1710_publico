package br.edu.ifpr.pgua.eic.tads.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agenda {
    

    private ArrayList<Contato> lista;
    

    public Agenda(){
        lista = new ArrayList<>();
    }

    public String cadastrar(String nome, String email, String telefone){
        
        //1-Estabelecer uma conexão

        String url = "jdbc:mysql://localhost:3306/contatos";
        //String url = "jdbc:mysql://wagnerweinert.com.br:3306/SEUBANCO";
        String username = "root";
        String password = "1234";

        Connection con=null;
        
        try{
            con = DriverManager.getConnection(url,username,password);
            Contato contato = new Contato(nome, telefone, email);

            String sql = "INSERT INTO oo_contatos(nome,telefone,email) VALUES (?,?,?)";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, nome);
            pstm.setString(2, telefone);
            pstm.setString(3,email);

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

    public List<Contato> getLista(){

        String url = "jdbc:mysql://localhost:3306/contatos";
        String username = "root";
        String password = "1234";

        Connection con;
        lista.clear();

        try{
            con = DriverManager.getConnection(url, username, password);
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
