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
	<title>Print Inventori</title>
</head>
 <%
        List<Inventori> listInven = (List<Inventori>) session.getAttribute("rekapInven");
        if (session.getAttribute("rekapInven") == null) {
            response.sendRedirect("laporanInvenViewServlet");
        }
    %>
<body>
 
	<center>
 
		<h2>DATA LAPORAN INVENTORI</h2>
		<h4>MASTER INVENTORI</h4>
 
	</center>
 
	<table border="1" style="width: 100%">
		<tr>
			<th width="1%">No</th>
			<th>Nama Barang</th>
			<th>Tanggal Update</th>
			<th>Jumlah Masuk</th>
			<th>Jumlah Keluar</th>
			
		</tr>
		 <% if (session.getAttribute("rekapInven") != null) {
             for (Inventori inventori : listInven) {%>
		<tr>
                                    <td><%=inventori.getId()%></td>
                                    <td><%=inventori.getNama()%></td>
                                    <td><%=inventori.getTglUpdate()%></td>
                                    <td><%=inventori.getJumlahMasuk()%></td>
                                    <td><%=inventori.getJumlahKeluar()%></td>
                                   
                                </tr><%}
                                    }%>
	</table>
 
	<script>
		window.print();
	</script>
 
</body>
</html>