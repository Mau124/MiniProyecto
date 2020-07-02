/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Optional;

import DataBase.OptionalDB;
import Models.Optional;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
@WebServlet(name = "UpdateOptionalController", urlPatterns = {"/UpdateOptionalController"})
public class UpdateOptionalController extends HttpServlet {
    private boolean result;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            OptionalDB optional = new OptionalDB();
            
            int IDOptional = Integer.parseInt(request.getParameter("codeOptional"));
            String name = request.getParameter("name");
            int credits = Integer.parseInt(request.getParameter("credits"));
            int IDCarer = Integer.parseInt(request.getParameter("codeCarer"));
            
            Optional opt = new Optional(IDOptional, name, credits, IDCarer);
            
            if (optional.updateOptional(IDOptional, opt))
            {
                result = true;
            } else 
            {
                result = false;
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Modificar materia opcional</title>");  
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            
            if (result)
            {
                out.println("<div class=\"alert alert-success\" role=\"alert\">");
                out.println("Operacion realizada con exito");
                out.println("</div>");
            } else 
            {
                out.println("<div class=\"alert alert-warning\" role=\"alert\">");
                out.println("Ha ocurrido un error con la base de datos");
                out.println("</div>");
            }
            
            out.println("<a href=\"OptionalList.jsp\">Regresar</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
            out.close();
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
