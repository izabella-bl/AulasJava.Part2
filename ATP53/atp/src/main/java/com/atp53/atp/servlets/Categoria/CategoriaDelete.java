package com.atp53.atp.servlets.Categoria;

import java.io.IOException;

import com.atp53.atp.dao.CategoriaDao;
import com.atp53.atp.models.CategoriaModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/categoria/deletar")
public class CategoriaDelete extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         CategoriaDao catDao = new CategoriaDao();
         CategoriaModel model = new CategoriaModel();

         int id = Integer.parseInt(req.getParameter("id"));

         model.setId(id);
         catDao.delete(model);

         
        RequestDispatcher rd = req.getRequestDispatcher("/Categoria/categoria/listar");
        rd.forward(req, resp);
     


    }


    
}
