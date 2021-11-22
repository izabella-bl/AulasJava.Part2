import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/produto")
public class produto  extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         /*PrintWriter out = resp.getWriter();
         out.println("Modulo Produto.");*/

         PrintWriter out = resp.getWriter();

        String parametroNome = req.getParameter("nome");
        String parametroValor =req.getParameter("preco");
        String paramentroIdCat = req.getParameter("categoria_id");
        
        if(parametroValor != null){
            float valor = Float.parseFloat(parametroValor);
            out.printf("Modulo Produtos - Prod = %s - R$ %f - Categoria: %s", parametroNome, valor, paramentroIdCat);
        }
        else{
            out.printf("Modulo Produtos - Prod = %s", parametroNome);
        }
    }
    
}
