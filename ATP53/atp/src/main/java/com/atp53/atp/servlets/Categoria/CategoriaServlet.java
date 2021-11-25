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

@WebServlet(urlPatterns = "/categoria")
public class CategoriaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         /*Atp53
         PrintWriter out = resp.getWriter();
         out.println("Modulo Categoria.");
         */
        
         /*Atp54
         String nome = req.getParameter("nome");
         String descricao = req.getParameter("descricao");*/

         //ATP56
         CategoriaModel catModel = new CategoriaModel();
         CategoriaDao  catDao = new CategoriaDao();


         catModel.setNome(req.getParameter("nome"));
         catModel.setDescricao(req.getParameter("descricao"));
         int id = catDao.insert(catModel);

        /*Atp56
         catModel.setId(catDao.insert(catModel));


         PrintWriter out = resp.getWriter();
         out.printf("ID- %d | Categoria : %s ,Descricao: %s ",catModel.getId(),catModel.getNome(),catModel.getDescricao()); */

         catModel.setId(id);
        
         req.setAttribute("id", catModel.getId());

        
        
         RequestDispatcher rd = req.getRequestDispatcher("/Categoria/categoria-sucesso.jsp");
         rd.forward(req, resp);
        
    }
    
}
