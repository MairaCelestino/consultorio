<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"
    import="java.util.*, pacote.to.Medico, pacote.util.ConverterDate"  
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<link href="styles.css" rel="stylesheet" type="text/css">
<link href="demo_table.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="jquery.dataTables.min.js"></script>
<script type="text/javascript" src="jquery.dataTables.js"></script>
<head>
<title>Agenda Consulta</title>
</head>
<body>

<script>
	$(document).ready(function() {
	    $('#tableMedico').dataTable( {
	    	"sPaginationType": "full_numbers"
	    } );
	} );
</script>
	 <div id="holder">																																																																																																																																																																																																																																																																																																																				
<!--BEGIN OF TERMS OF USE. DO NOT EDIT OR DELETE THESE LINES. IF YOU EDIT OR DELETE THESE LINES AN ALERT MESSAGE MAY APPEAR WHEN TEMPLATE WILL BE ONLINE-->
 <div id="footer_terms">
 </div>
<!--END OF TERMS OF USE-->
<!-- HEADER -->
 <div id="header"> <h1>SYSTEM ADMIN </h1><p></a> </div> 
<!-- END HEADER -->
<div id="shadow">
  <!-- MENU -->
  <ul id="menu">
    <li> <a href="cadMedico.html">Novo Medico</a> </li>
    <li> | </li>
    <li> <a href="index.jsp">Inicio</a> </li>
  </ul>
  <div class="clear"></div>
  <!-- END MENU -->
  <!-- EDITO -->
  <div id="edito">
    	
   </div>
  <!-- END EDITO -->
  <div id="toal"> </div>
  <!-- CONTENT -->

  <div id="content">
    <br>
		<form method="get" action="AgendaMedicoServlet">
		 <tr>
			<td>Nome do Medico:</td>
				<td><input type="text" id="nome_med" name="nome_med" size=50 maxlength=30/>
				<input type="hidden" id="cmd" name="cmd" value="medico"></td>
				<input type="submit" name="Pesquisar" value="Pesquisar">
			</tr>
		</form>

<%
List medicoList = ( List )request.getAttribute( "medicoList" ); 
	if(medicoList != null){%>
		<br>
		<br>

	<table "style=width:80%" class="linhasalternadas" id="tableMedico">
	<thead>
		<tr align="left"> 
			<center>
		     <th>CRM</th>
		     <th>Nome do Medico</th>
		     <th>Especialidade</th>
		     <th> Ações </th>
		    </center>
		</tr>
	</thead>
		
<tbody>
<% 		
for( Iterator i=medicoList.iterator( ); i.hasNext( ); ) 
{
  Medico l = ( Medico )i.next( );
%>
 <tr> 	
     <td><%=l.getCrm_med()%></td>
     <td><%=l.getNome_med( )%></td>
     <td><%=l.getEspecialidade( )%></td>
     <td>
     	<a href="AgendaMedicoServlet?cmd=exib&crm_med=<%=l.getCrm_med( )%>">    
        <img title="visualizar" src="icone3.jpg" alt="Pulpit rock" width="15" height="15"> 
        </a>
        <a href="AgendaMedicoServlet?cmd=atu&crm_med=<%=l.getCrm_med( )%>">    
        <img title="alterar" src="icone2.jpg" alt="Pulpit rock" width="15" height="15"> 
        </a>
        <a href="javascript:excluir(<%=l.getCrm_med( )%>)"> 
        <img title="exluir" src="icon.gif" alt="Pulpit rock" width="15" height="15"> 
        </a>
     </td>
</tr>

<script>
function excluir(id) {
	if (confirm("Tem certeza?")) {
		location.href="AgendaMedicoServlet?cmd=exc&crm_med=" + id;
	}
	else {
	}
	
}
</script>


<%
}
}// end for
%>
</tbody>
</table>
 <div class="clear"></div>
</div>
</div>
<!-- END HOLDER -->
</body>
</html>
