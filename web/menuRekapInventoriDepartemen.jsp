<%-- 
    Document   : menuInventori
    Created on : Jul 26, 2019, 4:44:00 PM
    Author     : tikko
--%>

<%@page import="models.RekapInventoriDept"%>
<%@page import="models.Departemen"%>
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

        <!--start modal in modal-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootsrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!--end-->
    </head>
    <%
        List<Departemen> listDept = (List<Departemen>) session.getAttribute("deptAll");
        List<RekapInventoriDept> listRekapInvDept = (List<RekapInventoriDept>) session.getAttribute("rekapDeptAll");
        if (session.getAttribute("deptAll") == null || session.getAttribute("rekapDeptAll")==null) {
            response.sendRedirect("rekapInvenDeptServlets");
        }
    %>
    <body>


        <%@include file="navbarDepartemen.jsp"%>

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
                <li><a href="#">Rekap Inventori Departemen</a></li>
            </ul>

            <!-- start: Content -->
            <div class="row-fluid sortable">		
                <div class="box span12">
                    <div class="box-header" data-original-title>
                        <h2><i class="halflings-icon tasks"></i><span class="break"></span>Rekap Inventori Departemen</h2>
                    </div>
                    <div class="box-content">
                        <table class="table table-striped table-bordered bootstrap-datatable datatable">
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>Nama Departemen</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>   
                            <tbody>
                                <% if (session.getAttribute("deptAll")!=null){
                                    for (Departemen dept : listDept) {%>
                                <tr>
                                    <td><%=dept.getNama() %></td>
                                    <td><%=dept.getIdDivisi().getNama() %></td>
                                    <td class="center">
                                        <!--<button class="btn btn-primary" data-toggle="modal" data-target="#myModal"><i class="halflings-icon white eye-open"></i> Detail</button>-->
                                        <a role="button" class="btn btn-primary" data-toggle="modal" href=# data-target="#dept<%=dept.getId() %>">
                                            <i class="halflings-icon white eye-open"></i> Detail</a>
                                    </td>
                                </tr><%}}%>
                            </tbody>
                        </table>            
                    </div>
                </div><!--/span-->
                <!-- end: Content -->
            </div>
        </div></div></div>


<!-- Modal tabel-->
<% if (session.getAttribute("deptAll")!=null){
    for (Departemen dept : listDept) {
%>
<div class="modal fade" id="dept<%=dept.getId() %>" role="dialog" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true" style="width: 900px; margin-left: -400px">
    <div class="modal-dialog modal-dialog-centered">
        <!-- Modal Content -->
        <div class="modal-content">
            <div class="modal-header" data-original-title>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h2 class="modal-title"><i class="halflings-icon tasks"></i><span class="break"></span>Rekap Inventori Departemen</h2>
            </div>
            <div class="modal-body">
                <!--					<div class="box-content">-->
                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                    <thead>
                        <tr>
                            <th>Nama Inventori</th>
                            <th>Tanggal Update</th>
                            <th>Jumlah</th>
                            <th>Actions</th>
                        </tr>
                    </thead>   
                    <tbody>
                        <%  if (session.getAttribute("rekapDeptAll")!=null)
                            for (RekapInventoriDept rid : listRekapInvDept) {
                            if (dept.getId().equals(rid.getIdDepartemen().getId()) && rid.getStatus()==1){ %>
                        <tr>
                            <td><%=rid.getIdInventori().getNama() %></td>
                            <td><%=rid.getTglUpdate() %></td>
                            <td><%=rid.getJumlahKeluar() %></td>
                            <td class="center">
                                <a href=# data-target="#used<%=rid.getId() %>" role="button" class="btn btn-primary" data-toggle="modal">Stok Terpakai</a>
                                <!--									<button class="btn btn-primary"><i class="halflings-icon white plus"></i> Tambah Stok</button>
                                                                                                        <button class="btn btn-warning"><i class="halflings-icon white pencil"></i> Stok Terpakai </button>-->
                            </td>
                        </tr><%}}%>
                    </tbody>
                </table>            
            </div>
        </div>
    </div>
</div><%}}%>


<!--Modal Of Edit-->
<% if (session.getAttribute("rekapDeptAll")!=null) {
    for (RekapInventoriDept rid : listRekapInvDept) {%>
<div id="used<%=rid.getId() %>" class="modal fade modal-child" data-backdrop-limit="1" tabindex="0" role="dialog" data-modal-parent="#myModal">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Stok Inventori Terpakai</h4>
            </div>
            <div class="modal-body" style="padding-left: 50px; padding-right: 50px">
                <form action="rekapInvenDeptServlets" method="POST">
                    <input type="hidden" value="<%=rid.getId() %>" name="rId">
                    <input type="hidden" value="<%=rid.getIdDepartemen() %>" name="rIdDept">
                    <input type="hidden" value="<%=rid.getIdInventori() %>" name="rIdInven">
                    <input type="hidden" value="<%=rid.getJumlahKeluar() %>" name="rJumKel">
                    <input type="hidden" value="<%=rid.getKeterangan() %>" name="rKet">
                    <input type="hidden" value="<%=rid.getStatus() %>" name="rStat">
                    <input type="hidden" value="<%=rid.getTglMasuk() %>" name="rTglMasuk">
                    <input type="hidden" value="<%=rid.getTglUpdate() %>" name="rTglUpdate">
                    <label><b>Jumlah Stok Terpakai </b></label>
                    <input class="form-control" type="text" name="stokTerpakai" value="">
                    <br><br>
                    <div align="right">
                        <input  type="submit" value="Simpan" class="btn btn-info">&nbsp;&nbsp;&nbsp;
                        <button type="button" class="btn btn-danger" data-dismiss="modal" >Batal</button>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" data-dismiss="modal" data-dismiss="modal" aria-hidden="true">Cancel</button>
            </div>

        </div>
    </div>
</div><%}}%>

<!--End of Modal Edit-->
<footer>
    <p>
        <span style="text-align:left;float:left">&copy; 2019 <a href="">Bootstrap MII</a></span>
    </p>
</footer>
<!-- start: JavaScript-->
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
<!-- end: JavaScript-->
</body>
<%
  session.removeAttribute("deptAll");
  session.removeAttribute("rekapDeptAll");
%>
</html>