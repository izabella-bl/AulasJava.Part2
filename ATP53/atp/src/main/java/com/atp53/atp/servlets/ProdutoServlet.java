package com.atp53.atp.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import com.atp53.atp.dao.ProdutoDao;
import com.atp53.atp.models.ProdutoModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/produto")
public class ProdutoServlet  extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        ProdutoModel prodModel = new ProdutoModel();
        ProdutoDao prodDao = new ProdutoDao();

        String parametroValor = req.getParameter("preco");
        String paramentroIdCat = req.getParameter("categoria_id");


        prodModel.setNome(req.getParameter("nome"));
        prodModel.setDescricao(req.getParameter("descricao"));

       
        
        if(parametroValor != "" && paramentroIdCat != ""){

            int  idCat = Integer.parseInt(paramentroIdCat);
            prodModel.setValor(new BigDecimal(parametroValor));
            prodModel.setIdCategoria(idCat);
            
            prodModel.setId(prodDao.insert(prodModel));
            out.printf("ID %d - Modulo Produtos - Prod = %s - Descricao: %s -R$ %f - Categoria: %d",prodModel.getId(),prodModel.getNome(),prodModel.getDescricao(), prodModel.getValor(),prodModel.getIdCategoria());
        }
        else{
            out.printf("Modulo Produtos - Prod = %s", prodModel.getNome());
        }
    }
    
}
