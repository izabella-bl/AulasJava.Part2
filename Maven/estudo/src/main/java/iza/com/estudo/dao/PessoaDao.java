package iza.com.estudo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import iza.com.estudo.model.Pessoa;

public class PessoaDao {


    public void insert(Pessoa p){

       try(Connection conn = new ConnectionFactory().getConnection()){

            String sql = "insert into pessoas(nome,sobrenome,idade,endereco) values(?,?,?,?)";
            PreparedStatement prepStatement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            prepStatement.setString(1, p.getNome());
            prepStatement.setString(2, p.getSobrenome());
            prepStatement.setInt(3, p.getIdade());
            prepStatement.setString(4, p.getEndereco());
    
             prepStatement.execute();
    
            ResultSet ids = prepStatement.getGeneratedKeys();
    
             while (ids.next()) {
                int id = ids.getInt("id");
                System.out.printf("id nº: %s inserido com sucesso! ",id);
            }
    
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void select(){
        try(Connection conn = new ConnectionFactory().getConnection()) {

            String sql = "select * from pessoas order by id ASC";
            PreparedStatement prepStatement = conn.prepareStatement(sql); 
            prepStatement.execute();            
            ResultSet result = prepStatement.getResultSet();
     
            while(result.next()){
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String sobrenome = result.getString("sobrenome");
                int idade = result.getInt("idade");
                System.out.printf("%d - Nome completo: %s %s| Idade: %d \n",id,nome,sobrenome,idade);
            }
     
        } catch (SQLException e) {
             e.printStackTrace();
        }            
             
    }

    public void update(Pessoa p, String tipo){

       try(Connection conn = new ConnectionFactory().getConnection()){

            if(tipo.equals("nome")){
                String sql = "UPDATE pessoas SET  nome = ? WHERE id = ?";
                PreparedStatement prepStatement = conn.prepareStatement(sql);
                prepStatement.setString(1, p.getNome());
                prepStatement.setInt(2, p.getId());

                prepStatement.execute();
            }

           else if(tipo.equals("sobrenome")){
                String sql = "UPDATE pessoas SET sobrenome = ? WHERE id = ?";
                PreparedStatement prepStatement = conn.prepareStatement(sql);
                prepStatement.setString(1, p.getSobrenome());
                prepStatement.setInt(2, p.getId());

                prepStatement.execute();
           }

           else if(tipo.equals("idade")){
                String sql = "UPDATE pessoas SET idade = ? WHERE id = ?";
                PreparedStatement prepStatement = conn.prepareStatement(sql);
                prepStatement.setInt(1,p.getIdade());
                prepStatement.setInt(2, p.getId());

                prepStatement.execute();
            }
            
            else if(tipo.equals("endereco")){
                String sql = "UPDATE pessoas SET endereco = ? WHERE id = ?";
                PreparedStatement prepStatement = conn.prepareStatement(sql);
                prepStatement.setString(1, p.getEndereco());
                prepStatement.setInt(2, p.getId());

                prepStatement.execute();
            }
            
           
            conn.close();
        }catch (SQLException e) {
          e.printStackTrace();
        }
    }
    
    public void update2(Pessoa p) {
    	 try(Connection conn = new ConnectionFactory().getConnection()){
    		 String sql = "UPDATE pessoas SET  nome = ?,sobrenome = ?,idade = ?, endereco = ? WHERE id = ?";
             PreparedStatement prepStatement = conn.prepareStatement(sql);
             prepStatement.setString(1, p.getNome());
             prepStatement.setString(2, p.getSobrenome());
             prepStatement.setInt(3, p.getIdade());
             prepStatement.setString(4, p.getEndereco());
             prepStatement.setInt(5, p.getId());

             prepStatement.execute();

           conn.close();
         }catch (SQLException e) {
           e.printStackTrace();
         }
    }

   public void delete(Pessoa p){

    try(Connection conn = new ConnectionFactory().getConnection()){
        String sql = "DELETE FROM pessoas WHERE id = ?";
   
        PreparedStatement prepStatement = conn.prepareStatement(sql);
        prepStatement.setInt(1,p.getId());

        prepStatement.execute();   
        int linhasAfetadas = prepStatement.getUpdateCount();
        System.out.println(linhasAfetadas);    

        conn.close();


    }catch (SQLException e) {
     e.printStackTrace();
    }
 
   }
   
   public ArrayList<Pessoa> read() {
       ArrayList<Pessoa> list = new ArrayList<Pessoa>();

       try(Connection conn = new ConnectionFactory().getConnection()) {            
           
           PreparedStatement prepStatement = conn.prepareStatement("SELECT * FROM pessoas order by id ASC");
           prepStatement.execute();
           ResultSet result = prepStatement.getResultSet();
           while(result.next()){
               Pessoa model = new Pessoa();                
               model.setId(result.getInt("id"));
               model.setNome(result.getString("nome"));
               model.setSobrenome(result.getString("sobrenome"));
               model.setIdade(result.getInt("idade"));
               model.setEndereco(result.getString("endereco"));
               list.add(model);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return list;
   }

}