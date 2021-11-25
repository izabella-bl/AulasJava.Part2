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

@WebServlet(urlPatterns = "/categoria/alterar")
public class CategoriaAlterar extends HttpServlet {
     
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");

        CategoriaModel model = new CategoriaModel();
        model.setId(id);
        model.setNome(nome);
        model.setDescricao(descricao);

        CategoriaDao dao = new CategoriaDao();
        dao.update(model);

        RequestDispatcher rd = req.getRequestDispatcher("/Categoria/categoria-alterado-sucesso.jsp");
        req.setAttribute("id", model.getId());
        rd.forward(req, resp);
    }
}
