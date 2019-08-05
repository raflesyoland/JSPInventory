/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.DepartemenController;
import controllers.InventoriController;
import controllers.RekapInvDeptController;
import icontrollers.IDepartemenController;
import icontrollers.IInventoriController;
import icontrollers.IRekapInvDeptController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RRAAAA
 */
@WebServlet(name = "rekapStokInventoriServlet2", urlPatterns = {"/rekapStokInventoriServlet2"})
public class rekapStokInventoriServlet2 extends HttpServlet {

    IRekapInvDeptController iridc = new RekapInvDeptController();
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
            response.sendRedirect("menuRekapStokInventori.jsp");
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
        int tJum = 0;

        String invenId = request.getParameter("invenId");
        String tglK = request.getParameter("tglKirim");
        String deptId = request.getParameter("dept");
        String itemK = request.getParameter("itemKeluar");
        String ket = request.getParameter("keterangan");

        String invenNama = request.getParameter("invenNama");
        String invenInp = request.getParameter("invenInp");
        String invenMasuk = request.getParameter("invenMasuk");

        if (request.getParameter("invenKeluar").equals("null")) {
            iic.insertUpdate(invenId, invenNama, invenInp, tglK, invenMasuk, itemK);
        } else {
            tJum = Integer.parseInt(request.getParameter("invenKeluar")) + Integer.parseInt(itemK);
            iic.insertUpdate(invenId, invenNama, invenInp, tglK, invenMasuk, Integer.toString(tJum));
        }
        iridc.insertupdate(deptId, invenId, itemK, tglK, ket, "0");
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
