<%-- 
    Document   : menuInventori
    Created on : Jul 26, 2019, 4:44:00 PM
    Author     : tikko
--%>

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
        <!--JSq-->

        <!--END JSq-->
    </head>

    <%
        List<Inventori> listInven = (List<Inventori>) session.getAttribute("inven");
        if (session.getAttribute("inven") == null) {
            response.sendRedirect("menuInventoriServlet");
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
                <li><a href="#">Rekap Stok Inventori</a></li>
            </ul>

            <!-- start: Content -->
            <div class="row-fluid sortable">		
                <div class="box span12">
                    <div class="box-header" data-original-title>
                        <h2><i class="halflings-icon align-justify"></i><span class="break"></span>Inventori</h2>
                    </div>
                    <div class="box-content">
                        <table class="table table-striped table-bordered bootstrap-datatable datatable">
                            <thead>
                                <tr>
                                    <th>Nama</th>
                                    <th>Tanggal Input</th>
                                    <th>Actions : </th>
                            <button class="btn btn-success" data-toggle="modal" data-target="#myModal" title="Tambah Data" data-rel="tooltip"><i class="halflings-icon white plus"></i></button>
                            </tr>
                            </thead>
                            <tbody>
                                <% if (session.getAttribute("inven") != null) {
                                        for (Inventori inventori : listInven) {%>
                                <tr align="center">
                                    <td><%=inventori.getNama()%></td>
                                    <td><%=inventori.getTglInput()%></td>
                                    <td><button class="btn btn-info" data-toggle="modal" href=# data-target="#edit<%=inventori.getId() %>" title="Edit Data" data-rel="tooltip"><i class="halflings-icon white edit"></i></button>&nbsp;&nbsp;&nbsp;
                                        <a href="menuInventoriServlet?action=delete&id=<%=inventori.getId()%>"><input type = "button" value = "Hapus Data" class="btn btn-danger" onclick = "getConfirmation();" /><i class="halflings-icon white trash"></i></button></a></td>
                                        <!--<button class="btn btn-danger"><i class="halflings-icon white trash"></i>Hapus</button>-->
                                        <!--<a href="menuInventoriServlet?action=delete&id=<%=inventori.getId()%>"><button type="button" class="btn btn-danger" title="Hapus Data" data-rel="tooltip" ><i class="halflings-icon white trash"></i></button></a></td>-->
                                </tr><%}
                                    }%>

                            </tbody>
                        </table>            
                    </div>
                </div><!--/span-->
                <!-- end: Content -->


            </div>
        </div></div></div>

<!-- Modal Insert-->
<div class="modal fade" id="myModal" role="dialog" style="width: 400px; margin-left: -200px">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <!-- Modal Header -->

            <div class="modal-header">
                <h4 class="modal-title" align="center">Tambah Data Inventori</h4>

            </div>
            <div class="modal-body" style="padding-left: 50px; padding-right: 50px" >
                <form action="menuInventoriServlet2" method="POST">
                    <label><b>Nama Barang </b></label>
                    <input class="form-control" type="text" name="namaBarang" value="">
                    <br>
                    <label><b>Diinput Tanggal </b></label>
                    <input class="form-control" type="date" name="datInput" value="">
                    <br><br>
                    <div align="right">
                        <input  type="submit" value="Simpan" class="btn btn-success">&nbsp;&nbsp;&nbsp;
                        <button type="button" class="btn btn-danger" data-dismiss="modal" >Batal</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!--End of Modal Insert-->
<% if (session.getAttribute("inven") != null) {
        for (Inventori inventori : listInven) {
%>
<!-- Modal Edit-->
<div class="modal fade" id="edit<%=inventori.getId()%>" role="dialog" style="width: 400px; margin-left: -200px">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title" align="center">Edit Data Divisi</h4>

            </div>
            <div class="modal-body" style="padding-left: 50px; padding-right: 50px" >
                <form action="menuInventoriServlet" method="POST">
                    <input type="hidden" name="invenId" value="<%=inventori.getId()%>" >
                    <input type="hidden" name="tglUpdate" value="<%=inventori.getTglUpdate()%>">
                    <input type="hidden" name="itemMasuk" value="<%=inventori.getJumlahMasuk()%>">
                    <input type="hidden" name="itemKeluar" value="<%=inventori.getJumlahKeluar()%>">
                           <label><b>Nama Barang </b></label>
                    <input class="form-control" type="text" name="namaBarang" value="<%=inventori.getNama()%>">
                    <br>
                    <label><b>Diinput Tanggal </b></label>
                    <input class="form-control" type="date" name="datInput" value="<%=inventori.getTglInput()%>">
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
<!--End of Modal Edit-->

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
<!--        <script>
            $(function () {
                $("#datePick").datepicker();
            });
        </script>-->
<!-- end: JavaScript-->

<script type = "text/javascript">
         <!--
            function getConfirmation() {
               var retVal = confirm("Apakah anda yakin ingin menghapus data ?");
               if( retVal == true ) {
                  document.write ("");
                  return true;
               } else {
                  document.write ("");
                  return false;
               }
            }
         //-->
      </script>
</body>
<%
    session.removeAttribute("inven");
%>
</html>