package com.atp53.atp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.atp53.atp.models.CategoriaModel;


public class CategoriaDao {
    
    public int insert(CategoriaModel model){
        int idGerado = 0 ;
        try(Connection conn = new ConnectionFactory().getConnection()) {            
        	
            
            String sql = "INSERT INTO categoria(nome,descricao)values(?,?)";
            PreparedStatement prepStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, model.getNome());
            prepStatement.setString(2,model.getDescricao());

            prepStatement.execute();            
            ResultSet ids = prepStatement.getGeneratedKeys();

            while(ids.next()){
                idGerado= ids.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idGerado;
    }

    public CategoriaModel readById(int id){
        CategoriaModel model = new CategoriaModel();
        try(Connection conn = new ConnectionFactory().getConnection()) {
            PreparedStatement prepStatement = conn.prepareStatement("SELECT * FROM categoria WHERE id = ?");
            prepStatement.setInt(1, id);
            prepStatement.execute();
            ResultSet result = prepStatement.getResultSet(); 
            while(result.next()){
                model.setId(result.getInt("id"));
                model.setNome(result.getString("nome"));
                break;
            }            

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return model;
    }

    public ArrayList<CategoriaModel> read(String nome) {

        ArrayList<CategoriaModel> list = new ArrayList<CategoriaModel>();
        try(Connection conn = new ConnectionFactory().getConnection()) {
            PreparedStatement prepStatement = conn.prepareStatement("SELECT * FROM categoria WHERE nome = ?");
            prepStatement.setString(1, nome);
            prepStatement.execute();
            ResultSet result = prepStatement.getResultSet();
            list = createList(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return list;
    }

    private ArrayList<CategoriaModel> createList(ResultSet result) throws SQLException {
        ArrayList<CategoriaModel> list = new ArrayList<CategoriaModel>();
        while(result.next()){
            CategoriaModel model = new CategoriaModel();                
            model.setId(result.getInt("id"));
            model.setNome(result.getString("nome"));
            model.setDescricao(result.getString("descricao"));
            list.add(model);
        }
        return list;
    }

	public ArrayList<CategoriaModel> read() {
        ArrayList<CategoriaModel> list = new ArrayList<CategoriaModel>();

        try(Connection conn = new ConnectionFactory().getConnection()) {            
            
            PreparedStatement prepStatement = conn.prepareStatement("SELECT * FROM categoria order by id asc");
            prepStatement.execute();
            ResultSet result = prepStatement.getResultSet();
            while(result.next()){
                CategoriaModel model = new CategoriaModel();                
                model.setId(result.getInt("id"));
                model.setNome(result.getString("nome"));
                model.setDescricao(result.getString("descricao"));
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int update(CategoriaModel model) {
        int linhasAfetadas = 0;
        try(Connection conn = new ConnectionFactory().getConnection()) {                 
            
            String sql = "UPDATE categoria SET nome=?,descricao=? WHERE id = ?";            
            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, model.getNome());
            prepStatement.setString(2,model.getDescricao());
            prepStatement.setInt(3, model.getId());

            prepStatement.execute();  
                      
            linhasAfetadas = prepStatement.getUpdateCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    public int delete(CategoriaModel model) {
        int linhasAfetadas = 0;
        try(Connection conn = new ConnectionFactory().getConnection()) 
        {     
            String sql = "DELETE FROM categoria WHERE id = ?";

            try ( PreparedStatement prepStatement = conn.prepareStatement(sql)) {
                prepStatement.setInt(1, model.getId());
                prepStatement.execute();   
                linhasAfetadas = prepStatement.getUpdateCount();                  
            } catch (Exception e) {
                e.printStackTrace();
            }            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }  
}
