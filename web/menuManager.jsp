<%-- 
    Document   : menuInventori
    Created on : Jul 26, 2019, 4:44:00 PM
    Author     : tikko
--%>

<%@page import="models.RekapInventoriDept"%>
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
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
    </head>
    <%
        List<RekapInventoriDept> listMana = (List<RekapInventoriDept>) session.getAttribute("rekapMana");
        if (session.getAttribute("rekapMana") == null) {
            response.sendRedirect("menuManajerServlet");
        }
    %>
    <body>


        <%@include file="navbarManager.jsp"%>

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
                <li><a href="#">Manajer</a></li>
            </ul>

            <!-- start: Content -->
            <div class="row-fluid sortable">		
                <div class="box span12">
                    <div class="box-header" data-original-title>
                        <h2><i class="halflings-icon file"></i><span class="break"></span>Persetujuan Pengiriman</h2>
                    </div>
                    <div class="box-content">
                        <table class="table table-striped table-bordered bootstrap-datatable datatable">
                            <thead>
                                <tr>
                                    <!--<th>Id Barang</th>-->
                                    <th>Nama Departemen</th>
                                    <th>Inventori </th>
                                    <th>Tanggal</th>
                                    <th>Jumlah Keluar</th>
                                    <th>Status</th>
                                    <th>Tindakan :</th>
                                </tr>
                            </thead>   
                            <tbody>
                                <% if (session.getAttribute("rekapMana") != null) {
                                        for (RekapInventoriDept rid  : listMana) {%>
                                <tr>
                                    <td><%=rid.getIdDepartemen().getNama() %></td>
                                    <td><%=rid.getIdInventori().getNama() %></td>
                                    <td><%=rid.getTglMasuk() %></td>
                                    <td><%=rid.getJumlahKeluar() %></td>
                                    <td><%=(rid.getStatus()==0)?"Butuh Konfirmasi":(rid.getStatus()==1)?"Setuju":"Ditolak" %></td>
                                    <td><button class="btn btn-primary" data-toggle="modal" data-target="#edit<%=rid.getId()%>"><i class="halflings-icon white edit"></i> Edit</button></td>
                                </tr><%}
                                    }%>
                            </tbody>
                        </table>            
                    </div>
                </div><!--/span-->
                <!-- end: Content -->


            </div>
        </div></div></div>


<%
    if (session.getAttribute("rekapMana") != null) {
        for (RekapInventoriDept rid : listMana) {
%>
<!-- Modal Terima-->
<div class="modal fade" id="edit<%=rid.getId() %>" role="dialog" style="width: 400px; margin-left: -200px">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title" align="center">Persetujuan</h4>

            </div>
            <div class="modal-body" style="padding-left: 50px; padding-right: 50px" >
                <form action="menuManajerServlet" method="POST">
                    
                    <input type="hidden" value="<%=rid.getIdDepartemen() %>" name="rIdDept">
                    <input type="hidden" value="<%=rid.getIdInventori() %>" name="rIdInven">
                    <input type="hidden" value="<%=rid.getKeterangan() %>" name="rKet">
                    <input type="hidden" value="<%=rid.getJumlahDeptTerpakai() %>" name="rJumTerpakai">
                    <input type="hidden" value="<%=rid.getTglMasuk() %>" name="rTglMasuk">
                    <input type="number" readonly value="<%=rid.getId() %>" name="rekapId">
                    <input type="text" readonly value="<%=rid.getIdDepartemen().getNama() %>" name="deptNama">
                    <input type="text" readonly value="<%=rid.getIdInventori().getNama() %>" name="invenNama">
                    <input type="text" readonly value="<%=rid.getJumlahKeluar() %>" name="jumlahKeluar">
                        <label class="radio">
                        <input type="radio" name="status" value="Terima" id="statusTerima" checked>Terima
                        </label>
                        <label class="radio">
                        <input type="radio" name="status" value="Tolak" id="statusTolak">Tolak
                        </label>
                    </div> 
                     <br>
                    <div align="right">
                        <input  type="submit" value="Simpan" class="btn btn-info">&nbsp;&nbsp;&nbsp;
                        <button type="button" class="btn btn-danger" data-dismiss="modal" >Batal</button>&nbsp;&nbsp;&nbsp;
                    </div>
                    <br>
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
<script src='assets/js/jquery.dataTables.min.js'></script>
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
%>
</html>