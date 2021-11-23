package com.atp53.atp.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import com.atp53.atp.dao.ProdutoDao;
import com.atp53.atp.models.ProdutoModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/produto/listar")
public class ProdutoReadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        ProdutoDao prodDao = new  ProdutoDao();

        for (ProdutoModel prod: prodDao.read()) {
            out.printf("%d - %s - %s\n",prod.getId(),prod.getNome(),prod.getDescricao());
        }
    }
}
