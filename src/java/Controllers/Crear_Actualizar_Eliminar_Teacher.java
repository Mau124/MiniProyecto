/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DataBase.TeacherDB;
import Models.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Angel Manuel
 */
@WebServlet(name = "Crear_Actualizar_Eliminar_Teacher", urlPatterns = {"/Crear_Actualizar_Eliminar_Teacher"})
public class Crear_Actualizar_Eliminar_Teacher extends HttpServlet {
    private static final long seralVersionUID = 1L;
    TeacherDB DB;
    public Crear_Actualizar_Eliminar_Teacher(){
        super();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
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
                String action = request.getParameter("action");
        System.out.println(action);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          switch(action){
              case "index":
                  index(request,response);
                  break;
              case "nuevo":
                  nuevo(request,response);
                  break;
              case "register":
                  System.out.println("entro");
                  registrar(request,response);
                  break;
              case "mostrar":
                  mostrar(request,response);
                  break;
              case "showedit":
                  showEditar(request,response);
                  break;
              case "editar":
                  editar(request,response);
                  break;
              case "eliminar":
                  eliminar(request,response);
                  break;
              default:
                  break;
          }
        }catch (SQLException e){
            e.getStackTrace();
        }
    
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
        doGet(request,response);
    }
    
    private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.hmtl");
        dispatcher.forward(request, response);
    }
    
    private void registrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        Teacher maestro = new Teacher(Integer.parseInt(request.getParameter("IDTeacher")),request.getParameter("Name"),request.getParameter("LastName"),Integer.parseInt(request.getParameter("IDAcademy")));
        DB.Insertar(maestro);
        
	RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
	dispatcher.forward(request, response);
    }
    
    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/register.jsp");
        dispatcher.forward(request, response);
    }
    
    private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrar.jsp");
        
        List<Teacher> listaMaestros = DB.ListarMaestros();
        request.setAttribute("lista", listaMaestros);
        dispatcher.forward(request, response);
    }
    
    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        Teacher maestro = DB.obtenerPorID(Integer.parseInt(request.getParameter("IDTeacher")));
        request.setAttribute("maestro", maestro);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editar.jsp");
        dispatcher.forward(request, response);
        
    }
    
    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        Teacher maestro = new Teacher (Integer.parseInt(request.getParameter("IDTeacher")),request.getParameter("Name"),request.getParameter("LastName"),Integer.parseInt(request.getParameter("IDAcademy")));
        DB.Actualizar(maestro);
        index(request, response);
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        Teacher maestro = DB.obtenerPorID(Integer.parseInt(request.getParameter("IDTeacher")));
        DB.Eliminar(maestro);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        dispatcher.forward(request, response);
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
