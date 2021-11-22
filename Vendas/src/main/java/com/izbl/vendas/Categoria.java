package com.izbl.vendas;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/categoria")
public class Categoria  extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 System.out.println("Recebendo requisito");
		 PrintWriter out = resp.getWriter();
		 out.println("<html>");
		 out.println("<body>");
		 out.println("<h1> Cadastro Vendas </h1>");
		 out.println("</body>");
		 out.println("</html>");
		 
	}
}
