package com.atp53.atp.dao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.atp53.atp.models.ProdutoModel;


public class ProdutoDao {
    
    public int insert(ProdutoModel model){
        int idGerador = 0;
        try(Connection conn = new ConnectionFactory().getConnection()) {            
        	
            
            String sql = "INSERT INTO produto(nome,descricao,preco,categoria_id)values(?,?,?,?)";
            PreparedStatement prepStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, model.getNome());
            prepStatement.setString(2,model.getDescricao());
            prepStatement.setBigDecimal(3, model.getValor());
            prepStatement.setInt(4,model.getIdCategoria());

            prepStatement.execute();            
            ResultSet ids = prepStatement.getGeneratedKeys();

            while(ids.next()){
                idGerador = ids.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idGerador;
    }
    
	public ArrayList<ProdutoModel> read() {
        ArrayList<ProdutoModel> list = new ArrayList<ProdutoModel>();

        try(Connection conn = new ConnectionFactory().getConnection()) {            
            
            PreparedStatement prepStatement = conn.prepareStatement("SELECT * FROM produto order by id asc");
            prepStatement.execute();
            ResultSet result = prepStatement.getResultSet();

            while(result.next()){
                ProdutoModel model = new ProdutoModel();             
                model.setId(result.getInt("id"));
                model.setNome(result.getString("nome"));
                model.setDescricao(result.getString("descricao"));
                BigDecimal valor = new BigDecimal(result.getString("preco").replace(",","").replace("$", ""));
                model.setValor(valor);
                model.setIdCategoria(result.getInt("categoria_id"));
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int update(ProdutoModel model) {
        int linhasAfetadas = 0;
       
        try(Connection conn = new ConnectionFactory().getConnection()) {                 
            
            String sql = "UPDATE produto SET nome=?,descricao=?,preco=?,categoria_id=? WHERE id = ?";            
            PreparedStatement prepStatement = conn.prepareStatement(sql);
            prepStatement.setString(1, model.getNome());
            prepStatement.setString(2,model.getDescricao());
            prepStatement.setBigDecimal(3,model.getValor());
            prepStatement.setInt(4, model.getIdCategoria());
            prepStatement.setInt(5, model.getId());

            prepStatement.execute();  
                      
            linhasAfetadas = prepStatement.getUpdateCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    public int delete(ProdutoModel model) {
        int linhasAfetadas = 0;
        try(Connection conn = new ConnectionFactory().getConnection()) 
        {     
            String sql = "DELETE FROM  WHERE id = ?";

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
