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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tikko
 */
@WebServlet(name = "laporanInvenViewServlet", urlPatterns = {"/laporanInvenViewServlet"})
public class laporanInvenViewServlet extends HttpServlet {
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
            request.getSession().setAttribute("rekapInven", iic.getAll());
            response.sendRedirect("menuLaporanInventoriView.jsp");
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
        String brgId = request.getParameter("barangId");
        String brgNama = request.getParameter("barangNama");
        String tglInput = request.getParameter("tglInput");
        String totalBrg = request.getParameter("totalBarang");
        String tglMasuk = request.getParameter("tglTerima");
        String itemMasuk = request.getParameter("hasil");
        String itemKeluar = request.getParameter("itemKeluar");
        String keterangan = request.getParameter("keterangan");
        iic.insertUpdate(brgId, brgNama, tglInput, tglMasuk, itemMasuk, itemKeluar);
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
