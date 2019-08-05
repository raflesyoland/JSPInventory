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
@WebServlet(name = "rekapStokInventoriServlet", urlPatterns = {"/rekapStokInventoriServlet"})
public class rekapStokInventoriServlet extends HttpServlet {

    IInventoriController iic = new InventoriController();
    IDepartemenController idc = new DepartemenController();
    IRekapInvDeptController iridc = new RekapInvDeptController();

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
            request.getSession().setAttribute("rekapInven", iic.getAll());
            request.getSession().setAttribute("getAllDept", idc.getAll());
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
        int jumlah = 0;
        String brgId = request.getParameter("barangId");
        String brgNama = request.getParameter("barangNama");
        String tglInput = request.getParameter("tglInput");
        String tglMasuk = request.getParameter("tglTerima");
        if (!"null".equals(request.getParameter("itemMasuk1"))){
        jumlah = (Integer.parseInt(request.getParameter("itemMasuk")) + Integer.parseInt(request.getParameter("itemMasuk1")));
        } else {
            jumlah = Integer.parseInt(request.getParameter("itemMasuk"));
        }
        String itemMasuk = Integer.toString(jumlah);
        String itemKel = request.getParameter("itemKeluar");
        String keterangan = request.getParameter("keterangan");
        
        if ("null".equals(itemKel)) {
            iic.insertUpdate(brgId, brgNama, tglInput, tglMasuk, itemMasuk);
        } else if(!"null".equals(itemKel)) {
            iic.insertUpdate(brgId, brgNama, tglInput, tglMasuk, itemMasuk, itemKel);
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
