/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.DepartemenController;
import controllers.RekapInvDeptController;
import icontrollers.IDepartemenController;
import icontrollers.IRekapInvDeptController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RRAAAA
 */
@WebServlet(name = "rekapInvenDeptServlets", urlPatterns = {"/rekapInvenDeptServlets"})
public class rekapInvenDeptServlets extends HttpServlet {

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
            request.getSession().setAttribute("deptAll", idc.getAll());
            request.getSession().setAttribute("rekapDeptAll", iridc.getAll());
            response.sendRedirect("menuRekapInventoriDepartemen.jsp");
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
        String rId = request.getParameter("rId");
        String rIdDept = request.getParameter("rIdDept");
        String rIdInven = request.getParameter("rIdInven");
        String rKet = request.getParameter("rKet");
        
        int jKel = Integer.parseInt(request.getParameter("rJumKel")) - Integer.parseInt(request.getParameter("stokTerpakai"));
//        String rJumKel = request.getParameter("rJumKel");
        String rJumKel = Integer.toString(jKel);
        if ("null".equals(rKet)) {
            rKet = "-";
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String dateF = formatter.format(date);
        
        String rStat = request.getParameter("rStat");
        String rTglMasuk = request.getParameter("rTglMasuk");
//        String rTglUpdate = request.getParameter("rTglUpdate");
        String stokTerpakai = request.getParameter("stokTerpakai");

        iridc.insertupdate(rId, rIdDept, rIdInven, rTglMasuk, dateF, rJumKel, stokTerpakai, rKet, rStat);
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
