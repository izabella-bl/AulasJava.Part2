package com.banco;

import com.banco.DAO.CategoriaDao;
import com.banco.Model.Categoria;

public class AppCategoria {
    public static void main( String[] args )
    {
        CategoriaDao dao = new CategoriaDao();

        Categoria model = new Categoria();
        model.setId(26);
        model.setNome("Teste no id 26");       

        dao.delete(26);
                
        for (Categoria categoria : dao.read()) {
            System.out.printf("%d - %s\n",categoria.getId(),categoria.getNome());
        }

    }
}
