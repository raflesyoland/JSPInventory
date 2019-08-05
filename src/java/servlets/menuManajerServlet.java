/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.InventoriController;
import controllers.RekapInvDeptController;
import icontrollers.IInventoriController;
import icontrollers.IRekapInvDeptController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tikko
 */
@WebServlet(name = "menuManajerServlet", urlPatterns = {"/menuManajerServlet"})
public class menuManajerServlet extends HttpServlet {

    IInventoriController iic = new InventoriController();
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
            request.getSession().setAttribute("rekapMana", iridc.getAll());
            response.sendRedirect("menuManager.jsp");
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
        String rIdDept = request.getParameter("rIdDept");
        String rIdInven = request.getParameter("rIdInven");
        String rKet = request.getParameter("rKet");
        if ("null".equals(rKet)) {
            rKet = "-";
        }
        String rJumTerpakai = request.getParameter("rJumTerpakai");
        String rekapId = request.getParameter("rekapId");
        String rJumKeluar = request.getParameter("jumlahKeluar");
        String rStatus = request.getParameter("status");
        String rTglMasuk = request.getParameter("rTglMasuk");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dateF = formatter.format(date);
//        System.out.println(formatter.format(date));
        if (rStatus.equals("Terima")) {
            iridc.insertApprove(rekapId, rIdDept, rIdInven, rTglMasuk, dateF, rJumKeluar, rKet, "1");
        } else if (rStatus.equals("Tolak")) {
            iridc.insertApprove(rekapId, rIdDept, rIdInven, rTglMasuk, dateF, rJumKeluar, rKet, "2");
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
