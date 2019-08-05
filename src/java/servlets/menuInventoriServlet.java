/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.InventoriController;
import icontrollers.IInventoriController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RRAAAA
 */
@WebServlet(name = "menuInventoriServlet", urlPatterns = {"/menuInventoriServlet"})
public class menuInventoriServlet extends HttpServlet {

    IInventoriController iic = new InventoriController();

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
            request.getSession().setAttribute("inven", iic.getAll());
            response.sendRedirect("menuInventori.jsp");
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
        String action = request.getParameter("action")+"";
        String id = request.getParameter("id")+"";
        if(action.equals("delete")){
            iic.delete(id);
        }
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
        String invenBar = request.getParameter("namaBarang");
//        String invenNama = request.getParameter("barInput");
        String dateIn = request.getParameter("datInput");
//        String tglIn = request.getParameter("tglInput");
        String invId = request.getParameter("invenId");
        String tglUp = request.getParameter("tglUpdate");
        String itemM = request.getParameter("itemMasuk");
        String itemK = request.getParameter("itemKeluar");
//        if(("null".equals(invId)) && ("null".equals(tglUp)) && ("null".equals(itemK))){
//            iic.insertUpdate(invenBar, dateIn);
//        } else if ("null".equals(tglUp) && "null".equals(itemK)) {
//            iic.insertUpdate(invId, invenBar, dateIn);
//        } else if ("null".equals(itemK)){
//            iic.insertUpdate(invId, invenBar, dateIn, tglUp, itemM);
//        } else {
//            iic.insertUpdate(invId, invenBar, dateIn, tglUp, itemM, itemK);
//        }        
        
        if (!"null".equals(invId) && !"null".equals(tglUp) && !"null".equals(itemK)){
            iic.insertUpdate(invId, invenBar, dateIn, tglUp, itemM, itemK);
        } else if ((!"null".equals(invId)) && (!"null".equals(tglUp))) {
            iic.insertUpdate(invId, invenBar, dateIn, tglUp, itemM);
        } else if (!"null".equals(invId)) {
            iic.insertUpdate(invId, invenBar, dateIn);
        } else {
            iic.insertUpdate(invenBar, dateIn);
        }
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
