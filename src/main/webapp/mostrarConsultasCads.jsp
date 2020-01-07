<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"
    import="java.util.*, pacote.to.Consulta, pacote.util.ConverterDate"  
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
	    $('#tableConsulta').dataTable( {
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
    <li> <a href="cadConsultas.jsp">Novo Agendamento</a> </li>
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
		<form method="get" action="AgendaConsultaServlet">
		 <tr>
			<td>Nome do Medico:</td>
				<td><input type="text" id="nome_med" name="nome_med" size=50 maxlength=30/>
				<input type="hidden" id="cmd" name="cmd" value="consulta"></td>
				<input type="submit" name="Pesquisar" value="Pesquisar">
			</tr>
		</form>

<% 
List consultaList = ( List )request.getAttribute( "consultaList" ); 
	if(consultaList != null){%>
		<br>
		<br>

	<table "style=width:80%" class="linhasalternadas" id="tableConsulta">
	<thead>
		<tr align="left"> 
			<center>
		     <th>Nome do Paciente</th>
		     <th>Nome do Medico</th>
		     <th>Data Consulta</th>
		     <th>Horario Consulta</th>
		     <th> Ações </th>
		    </center>
		</tr>
	</thead>
		
<tbody>
<% 		
for( Iterator i=consultaList.iterator( ); i.hasNext( ); ) 
{
  Consulta l = ( Consulta )i.next( );

%>
 <tr> 	
     <td><%=l.getRe_paciente().getNome_pac()%></td>
     <td><%=l.getCrm_medico().getNome_med()%></td>
     <td><%=l.getData_consulta( )%></td>
     <td><%=l.getHorario_consulta( )%></td>
   	 <td>
      <a a href="AgendaConsultaServlet?cmd=exib&id_consulta=<%=l.getId_consulta( )%>">    
        <img title="visualizar" src="icone3.png" alt="Pulpit rock" width="15" height="15">
      </a> 
      <a href="AgendaConsultaServlet?cmd=exc&id_consulta=<%=l.getId_consulta( )%>"> 
        <img title="exluir" src="icon.gif" alt="Pulpit rock" width="15" height="15"> 
      </a>
      <a href="AgendaConsultaServlet?cmd=atu&id_consulta=<%=l.getId_consulta( )%>">    
        <img title="alterar" src="icone2.jpg" alt="Pulpit rock" width="15" height="15"> 
       </a>
     </td>
</tr>
<%
}
}// end for
%>
</tbody>
</table>
 <div class="clear"></div>
</div>
</div>
</body>
</html>
