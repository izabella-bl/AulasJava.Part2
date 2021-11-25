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

@WebServlet(urlPatterns = "/categoria/carregar")
public class CategoriaBuscarById extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoriaDao catDao = new CategoriaDao();
        int id = Integer.parseInt(req.getParameter("id"));
        CategoriaModel model = catDao.readById(id);

        RequestDispatcher rd = req.getRequestDispatcher("/Categoria/categoria-alterar.jsp");
        req.setAttribute("model", model);
        rd.forward(req, resp);
        
    }
    
}
