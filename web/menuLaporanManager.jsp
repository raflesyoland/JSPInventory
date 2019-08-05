<%-- 
    Document   : menuInventori
    Created on : Jul 26, 2019, 4:44:00 PM
    Author     : tikko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Inventori</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
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
				<li><a href="#">Laporan</a></li>
			</ul>
			
			<!-- start: Content -->
			<div class="container-fluid">
                            <h1>Laporan</h1>
                            <br>
                            <table>
                                <tr>
                                  <th>Tampilkan Data : </th>
                                  <td>
                                    <a href="menuLaporanManajerView.jsp"><button class="btn btn-info fadeToggle"><i class="halflings-icon white book"></i>Master Inventori</button></a>
                                    <button class="btn btn-warning fadeToggle1"><i class="halflings-icon white file"></i>Master Departemen</button>
                                  </td>
                                </tr>
                            </table>
                            
                        </div>
			<!-- end: Content -->
			
			
		</div>
		</div>
		</div>

	
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
</html>