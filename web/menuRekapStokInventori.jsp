<%-- 
    Document   : menuInventori
    Created on : Jul 26, 2019, 4:44:00 PM
    Author     : tikko
--%>

<%@page import="models.Departemen"%>
<%@page import="java.math.BigInteger"%>
<%@page import="models.Inventori"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventori</title>
        <!-- start: Mobile Specific -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- end: Mobile Specific -->

        <!-- start: CSS -->
        <link id="bootstrap-style" href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link id="base-style" href="assets/css/style.css" rel="stylesheet">
        <link id="base-style-responsive" href="assets/css/style-responsive.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
        <!-- end: CSS -->
    </head>
    <%
        List<Inventori> listInven = (List<Inventori>) session.getAttribute("rekapInven");
        List<Departemen> listDept = (List<Departemen>) session.getAttribute("getAllDept");
        
        if (session.getAttribute("rekapInven") == null || session.getAttribute("getAllDept")==null) {
            response.sendRedirect("rekapStokInventoriServlet");
        }
    %>
    <body>


        <%@include file="navbarInventori.jsp"%>

        <div id="content" class="span10">
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    <a href="menuUtama.jsp">Home</a> 
                    <i class="icon-angle-right"></i>
                </li>
                <li><a href="#">Data Master</a>
                    <i class="icon-angle-right"></i>
                </li>
                <li><a href="#">Inventori</a></li>
            </ul>

            <!-- start: Content -->
            <div class="row-fluid sortable">		
                <div class="box span12">
                    <div class="box-header" data-original-title>
                        <h2><i class="halflings-icon file"></i><span class="break"></span>Inventori</h2>
                    </div>
                    <div class="box-content">
                        <table class="table table-striped table-bordered bootstrap-datatable datatable" id="rekapInven">
                            <thead>
                                <tr>
                                    <th>Id Barang</th>
                                    <th>Nama Barang</th>
                                    <th>Tgl Update</th>
                                    <th>Jumlah Masuk</th>
                                    <th>Jumlah Keluar</th>
                                    <!--<th>Total Jumlah</th>-->
                                    <th>Actions : </th>
                                </tr>
                            </thead>   
                            <tbody>
                                <% if (session.getAttribute("rekapInven") != null) {
                                        for (Inventori inventori : listInven) {%>
                                <tr>
                                    <td><%=inventori.getId()%></td>
                                    <td><%=inventori.getNama()%></td>
                                    <td><%=inventori.getTglUpdate()%></td>
                                    <td><%=inventori.getJumlahMasuk()%></td>
                                    <td><%=inventori.getJumlahKeluar()%></td>
                                    <td>
                                    <button class="btn btn-success" data-toggle="modal" href=# data-target="#insert<%=inventori.getId()%>"><i class="halflings-icon white download-alt"></i> Terima Barang</button>
                                    <button class="btn btn-warning" data-toggle="modal" href=# data-target="#edit<%=inventori.getId() %>"><i class="halflings-icon white envelope"></i> Kirim ke Devisi</button></td>
                                </tr><%}
                                    }%>
                            </tbody>
                        </table>            
                    </div>
                </div><!--/span-->
                <!-- end: Content -->



            </div>
        </div>

        <!-- Modal Insert-->
        <% if (session.getAttribute("rekapInven")!=null){
            for (Inventori inven : listInven) {
        %>
        <div class="modal fade" id="edit<%=inven.getId() %>" role="dialog" style="width: 400px; margin-left: -200px">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title" align="center">Kirim Barang Ke Divisi</h4>

                    </div>
                    <div class="modal-body" style="padding-left: 50px; padding-right: 50px" >
                        <form action="rekapStokInventoriServlet2" method="POST">
                            <input type="hidden" value="<%=inven.getId() %>" name="invenId">
                            <input type="hidden" value="<%=inven.getNama() %>" name="invenNama">
                            <input type="hidden" value="<%=inven.getTglInput() %>" name="invenInp">
                            <input type="hidden" value="<%=inven.getJumlahMasuk() %>" name="invenMasuk">
                            <input type="hidden" value="<%=inven.getJumlahKeluar() %>" name="invenKeluar">
                            <label><b>Tanggal </b></label>
                            <input class="form-control" type="date" name="tglKirim" id="datePick" value=""/>
                            <br>
                            <label><b>Jumlah Item Dikirim </b></label>
                            <input class="form-control" type="text" name="itemKeluar" value=""/>
                            <br>
                            <label><b>Ke Departemen </b></label>
                            <select name="dept" required>
                            <% if (session.getAttribute("getAllDept")!=null){
                                for (Departemen dept : listDept) {
                            %>
                            <option value="<%=dept.getId() %>"><%=dept.getNama() %></option><%}}%>
                            </select>
                            
                            <br>
                            <label><b>Keterangan </b></label>
                            <input class="form-control" type="text" name="keterangan" value="">
                            <br><br>
                            <div align="right">
                                <input  type="submit" value="Simpan" class="btn btn-info">&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-danger" data-dismiss="modal" >Batal</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div><%}}%>
        <!--End of Modal Insert-->
        <%
            if (session.getAttribute("rekapInven") != null) {
                for (Inventori inventori : listInven) {
        %>
        <!-- Modal Terima-->
        <div class="modal fade" id="insert<%=inventori.getId()%>" role="dialog" style="width: 400px; margin-left: -200px">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title" align="center">Item Masuk</h4>

                    </div>
                    <div class="modal-body" style="padding-left: 50px; padding-right: 50px" >
                        <form action="rekapStokInventoriServlet" method="POST">
                            <label><b>Tanggal </b></label>
                            <input type="hidden" value="<%=inventori.getId()%>" name="barangId">
                            <input type="hidden" value="<%=inventori.getNama()%>" name="barangNama">
                            <input type="hidden" value="<%=inventori.getTglInput()%>" name="tglInput">
                            <input type="hidden" value="<%=inventori.getJumlahKeluar()%>" name="itemKeluar" id="itemKeluar">
                            <input type="hidden" value="<%=inventori.getJumlahMasuk()%>" name="itemMasuk1" id="itemMasuk1">
                            <input class="form-control" type="date" name="tglTerima" id=""/>
                            <br>
                            <label><b>Jumlah Item Diterima </b></label>
                            <input class="form-control" type="text" name="itemMasuk" id="itemMasuk"/>
                            <!--<input type="hidden" id="hasil" name="jawab" value=""/>-->
                            <br><br>
                            <div align="right">
                                <input  type="submit" value="Simpan" class="btn btn-info">&nbsp;&nbsp;&nbsp;
                                <button type="button" class="btn btn-danger" data-dismiss="modal" >Batal</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div><%}
            }%>
        <!--End of Modal Terima-->


        <footer>
            <p>
                <span style="text-align:left;float:left">&copy; 2019 <a href="">Bootstrap MII</a></span>
            </p>
        </footer>


        <!-- start: JavaScript-->
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="assets/js/jquery-1.9.1.min.js"></script>
        <script src="assets/js/jquery-migrate-1.0.0.min.js"></script>
        <script src="assets/js/jquery-ui-1.10.0.custom.min.js"></script>
        <script src="assets/js/jquery.ui.touch-punch.js"></script>
        <script src="assets/js/modernizr.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.cookie.js"></script>
        <script src='assets/js/fullcalendar.min.js'></script>
        <script src="assets/js/jquery.dataTables.min.js"></script>
        <script src="assets/js/excanvas.js"></script>
        <script src="assets/js/jquery.flot.js"></script>
        <script src="assets/js/jquery.flot.pie.js"></script>
        <script src="assets/js/jquery.flot.stack.js"></script>
        <script src="assets/js/jquery.flot.resize.min.js"></script>
        <script src="assets/js/jquery.chosen.min.js"></script>
        <script src="assets/js/jquery.uniform.min.js"></script>
        <script src="assets/js/jquery.cleditor.min.js"></script>
        <script src="assets/js/jquery.noty.js"></script>
        <script src="assets/js/jquery.elfinder.min.js"></script>
        <script src="assets/js/jquery.raty.min.js"></script>
        <script src="assets/js/jquery.iphone.toggle.js"></script>
        <script src="assets/js/jquery.uploadify-3.1.min.js"></script>
        <script src="assets/js/jquery.gritter.min.js"></script>
        <script src="assets/js/jquery.imagesloaded.js"></script>
        <script src="assets/js/jquery.masonry.min.js"></script>
        <script src="assets/js/jquery.knob.modified.js"></script>
        <script src="assets/js/jquery.sparkline.min.js"></script>
        <script src="assets/js/counter.js"></script>
        <script src="assets/js/retina.js"></script>
        <script src="assets/js/custom.js"></script>
        <script>
                                    $(function () {
                                        $("#datepicker").datepicker();
                                    });
        </script>

        <script>
            function sum() {
                var f1 = document.getElementById("itemMasuk").value;
                var f2 = document.getElementById("itemMasuk1").value;
                var result = parseFloat(f1) + parseFloat(f2);
                document.getElementById("hasil").value = result;
            }
        </script>
        <!-- end: JavaScript-->
    </body>
    <%
        session.removeAttribute("rekapInven");
        session.removeAttribute("getAllDept");
    %>
</html>