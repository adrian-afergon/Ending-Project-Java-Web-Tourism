/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(urlPatterns = {"/serveletImagen"})
public class serveletImagen extends HttpServlet {

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
        PrintWriter out = response.getWriter();
                String id=request.getParameter("id"); 
        try{
            String connectionURL = "jdbc:mysql://localhost/db_turismo_tenerife";
            java.sql.Connection con=null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con=DriverManager.getConnection(connectionURL,"root","");  
            java.sql.Statement st1=con.createStatement();
            ResultSet rs1 = st1.executeQuery("select image from tb_recorrido where id_recorrido="+id+"");
            String imgLen="";
            if(rs1.next()){
                imgLen = rs1.getString(1);
                System.out.println(imgLen.length());
            }  
            rs1 = st1.executeQuery("select image from tb_recorrido where id_recorrido="+id+"");
            if(rs1.next()){
                int len = imgLen.length();
                byte [] rb = new byte[len];
                InputStream readImg = rs1.getBinaryStream(1);
                int index=readImg.read(rb, 0, len);  
                System.out.println("index"+index);
                st1.close();
                response.reset();
                response.setContentType("image/jpg");
                response.getOutputStream().write(rb,0,len);
                response.getOutputStream().flush();  
            }
        }
        catch (Exception e){
            e.printStackTrace();
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
