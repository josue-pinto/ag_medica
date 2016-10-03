
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** PROBLEMA ENCONTRADO HTML JUNTO COM CONTROLLER
 * CONTROLLER
 * @author Josue Jr, Jair Silva , Vitor
 */
public class ServletOO extends HttpServlet {
    Paciente contato = new Paciente();
    DaoPaciente contato2 = new DaoPaciente();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            try{
                List<Paciente> lista;
                contato.setNm_Pac(request.getParameter("nome"));                
                contato.setTel_Pac(request.getParameter("telefone"));
                contato.setEmail_Pac(request.getParameter("email"));
                int Codigo;
                String cmd = request.getParameter("cmd");
                
                switch (cmd){
                    case "i": contato2.inserirBanco(contato);
                        out.println("<h1>O paciente "+contato.getNm_Pac()+" foi inserido com Sucesso!!!</h1>");
                        response.setHeader("Refresh","3;URL=index.html");
                        break;
                    case "e": Codigo = Integer.parseInt(request.getParameter("codigo"));
                        contato2.excluirBanco(Codigo);
                        out.println("<h1>O paciente "+Codigo+" foi excluido com Sucesso!!!</h1>");
                        //out.println("<meta http-equiv="Refresh" content="5;url=index.html>");
                        response.setHeader("Refresh","3;URL=index.html");
                        break;
                    case "c": lista = contato2.consultarBanco();
                        out.println("<table border=\"1\">");
                        out.println("<tr><th>Nome</th>"  + "<th>Telefone</th>" + "<th>Email</th></tr>");
                        for (Iterator<Paciente> it = lista.iterator(); it.hasNext(); ) {  
                            Paciente p = it.next();
                            out.println("<tr><td>"+p.getNm_Pac()+"</td>");                            
                            out.println("<td>"+p.getTel_Pac()+"</td>");
                            out.println("<td>"+p.getEmail_Pac()+"</td></tr>");
                        }
                        out.println("</table>");
                        break;
                    case "a": Codigo = Integer.parseInt(request.getParameter("codigo"));
                        lista = contato2.alterarBanco(Codigo);
                        out.println("<table border=\"1\">");
                        out.println("<tr><th>Nome do Paciente</th>" +  "<th>Telefone</th>" + "<th>Email</th></tr>");
                        for (Iterator<Paciente> it = lista.iterator(); it.hasNext(); ) {  
                            Paciente p = it.next();
                            out.println("<form action=ServletOO?cmd=a2&codigo="+Codigo+" method=post>");
                            out.println("<tr><td><input type=text name=nome value="+p.getNm_Pac()+"/></td>");                            
                            out.println("<td><input type=text name=telefone value="+p.getTel_Pac()+"/></td>");
                            out.println("<td><input type=text name=email value="+p.getEmail_Pac()+"/></td></tr>");
                            out.println("<tr><td colspan=4><input type=submit value=Gravar /></td></tr>");
                            out.println("</form>");
                        }
                        out.println("</table>");
                        break;
                    case "a2": Codigo = Integer.parseInt(request.getParameter("codigo"));
                        contato2.gravarAltBanco(contato, Codigo);
                        out.println("<h1>O paciente "+Codigo+" foi alterado com Sucesso!!!</h1>");
                        response.setHeader("Refresh","3;URL=index.html");
                        break;
                }
            }finally
            {
               
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
