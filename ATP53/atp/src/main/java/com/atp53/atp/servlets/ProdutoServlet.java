package com.atp53.atp.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import com.atp53.atp.models.ProdutoModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/produto")
public class ProdutoServlet  extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         /*ATP53
         PrintWriter out = resp.getWriter();
         out.println("Modulo Produto.");*/

        /*ATP54
        PrintWriter out = resp.getWriter();

        String parametroNome = req.getParameter("nome");
        String paremetroDesc = req.getParameter("descricao");
        String parametroValor =req.getParameter("preco");
        String paramentroIdCat = req.getParameter("categoria_id");*/

        PrintWriter out = resp.getWriter();
        ProdutoModel prod = new ProdutoModel();

        String parametroValor = req.getParameter("preco");
        String paramentroIdCat = req.getParameter("categoria_id");


        prod.setNome(req.getParameter("nome"));
        prod.setDescricao(req.getParameter("descricao"));
       
        
        if(parametroValor != "" && paramentroIdCat != ""){

            double valor = Double.parseDouble(parametroValor);
            int  idCat = Integer.parseInt(paramentroIdCat);
            prod.setValor(valor);
            prod.setIdCategoria(idCat);
            out.printf("Modulo Produtos - Prod = %s - Descricao: %s -R$ %f - Categoria: %d", prod.getNome(),prod.getDescricao(), prod.getValor(),prod.getIdCategoria());
        }
        else{
            out.printf("Modulo Produtos - Prod = %s", prod.getNome());
        }
    }
    
}
