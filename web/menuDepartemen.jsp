<%-- 
    Document   : menuInventori
    Created on : Jul 26, 2019, 4:44:00 PM
    Author     : tikko
--%>

<%@page import="models.Divisi"%>
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
    </head
    <%
        List<Divisi> listDiv = (List<Divisi>) session.getAttribute("divSes");
        List<Departemen> listDept = (List<Departemen>) session.getAttribute("dept");
        if (session.getAttribute("dept") == null || session.getAttribute("divSes") == null) {
            response.sendRedirect("menuDepartemenServlet");
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
                <li><a href="#">Departemen</a></li>
            </ul>

            <!-- start: Content -->
            <div class="row-fluid sortable">		
                <div class="box span12">
                    <div class="box-header" data-original-title>
                        <h2><i class="halflings-icon file"></i><span class="break"></span>Departemen</h2>
                    </div>
                    <div class="box-content">
                        <table class="table table-striped table-bordered bootstrap-datatable datatable">
                            <thead>
                                <tr>
                                    <th>Nama Departemen</th>
                                    <th>Divisi</th>
                                    <th>Actions : </th>
                            <button class="btn btn-success" data-toggle="modal" data-target="#myModal" title="Tambah Data" data-rel="tooltip"><i class="halflings-icon white plus"></i></button>
                            </tr>
                            </thead>   
                            <tbody>
                                <% if (session.getAttribute("dept") != null) {
                                        for (Departemen departemen : listDept) {%>
                                <tr align="center">
                                    <td><%=departemen.getNama()%></td>
                                    <td><%=departemen.getIdDivisi().getNama()%></td>
                                    <td><button class="btn btn-info" data-toggle="modal" href=# data-target="#edit<%=departemen.getId()%>" title="Edit Data" data-rel="tooltip"><i class="halflings-icon white edit"></i></button>&nbsp;&nbsp;&nbsp;
                                    <a href="menuDepartemenServlet?action=delete&id=<%=departemen.getId()%>"><button class="btn btn-danger" title="Hapus Data" data-rel="tooltip"><i class="halflings-icon white trash"></i></button></a></td>
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
                        <h4 class="modal-title" align="center">Tambah Data Departemen</h4>

                    </div>
                    <div class="modal-body" style="padding-left: 50px; padding-right: 50px" >
                        <form action="menuDepartemenServlet" method="POST">
                            <label><b>Nama Departemen </b></label>
                            <input class="form-control" type="text" name="deptNama" value=""/ style="padding-left: 15px; width: 280px">
                                   <br>
                            <label><b>ID Divisi</b></label>
                            <select name="divisi" required>
                                <% if (session.getAttribute("divSes") != null) {
                                        for (Divisi divisi : listDiv) {%>
                                <option value="<%=divisi.getId()%>" ><%=divisi.getNama()%></option><%}
                                        }%>
                            </select>

                            <!--<input class="form-control" type="text" name="regionName" value="" / style="padding-left: 15px; width: 280px">-->
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

        <!-- Modal Edit-->
        <% if (session.getAttribute("dept") != null) {
                for (Departemen dept : listDept) {
        %>
        <div class="modal fade" id="edit<%=dept.getId()%>" role="dialog" style="width: 400px; margin-left: -200px">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title" align="center">Edit Data Departemen</h4>

                    </div>
                    <div class="modal-body" style="padding-left: 50px; padding-right: 50px" >
                        <form action="menuDepartemenServlet" method="POST">
                            <input type="hidden" name="deptId" value="<%=dept.getId() %>">
                                   <label><b>Nama Departemen</b></label>
                            <input class="form-control" type="text" name="deptNama" value="<%=dept.getNama()%>">
                            <br>
                            <label><b>Divisi</b></label>
                            <select name="divisi" required>
                                <% if (session.getAttribute("divSes") != null) {
                                        for (Divisi divisi : listDiv) {%>
                                <option value="<%=divisi.getId()%>" <%=(divisi.getId().equals(dept.getIdDivisi().getId())) ? "selected" : ""%>><%=divisi.getNama()%></option><%}
                                        }%>
                            </select>
                            <!--<input class="form-control" type="text" name="regionName" value="">-->
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
        session.removeAttribute("dept");
        session.removeAttribute("divSes");
    %>
</html>