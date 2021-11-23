package com.atp53.atp.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import com.atp53.atp.dao.CategoriaDao;
import com.atp53.atp.models.CategoriaModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/categoria")
public class CategoriaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         /*Atp53
         PrintWriter out = resp.getWriter();
         out.println("Modulo Categoria.");
         */
        
         /*Atp4
         String nome = req.getParameter("nome");
         String descricao = req.getParameter("descricao");*/

         CategoriaModel catModel = new CategoriaModel();
         CategoriaDao  catDao = new CategoriaDao();


         catModel.setNome(req.getParameter("nome"));
         catModel.setDescricao(req.getParameter("descricao"));
         catModel.setId(catDao.insert(catModel));


         PrintWriter out = resp.getWriter();
         out.printf("ID- %d | Categoria : %s ,Descricao: %s ",catModel.getId(),catModel.getNome(),catModel.getDescricao());
    }
    
}
