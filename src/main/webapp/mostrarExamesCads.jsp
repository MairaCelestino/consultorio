<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"
    import="java.util.*, to.Exame, to.Paciente, util.ConverterDate"  
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
	    $('#tableExame').dataTable( {
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
    <li> <a href="cadExame.jsp">Novo Exame</a> </li>
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
		<form method="get" action="AgendaExameServlet">
		 <tr>
			<td>Nome do Paciente:</td>
				<td><input type="text" id="nome_paciente" name="nome_paciente" size=50 maxlength=30/>
				<input type="hidden" id="cmd" name="cmd" value="exame"></td>
				<input type="submit" name="Pesquisar" value="Pesquisar">
			</tr>
		</form>

<%
Exame exame = new Exame();
List exameList = ( List )request.getAttribute( "exameList" ); 
	if(exameList != null){%>
		<br>
		<br>


	<table "style=width:50%" class="linhasalternadas" id="tableExame">
	<thead>
		<tr align="left"> 
			<center>
		     <th>Registro Estat.</th>
		     <th>Paciente</th>
		     <th>Ações</th>
		    </center>
		</tr>
	</thead>
		
<tbody>
<% 		
for( Iterator i=exameList.iterator( ); i.hasNext( ); ) 
{
  Exame l = ( Exame )i.next( );

%>
 <tr> 	
     
     <td><%=l.getRe_paciente().getRe_pac() %></td>
     <td><%=l.getRe_paciente().getNome_pac() %></td>
  		<td>
     	<a href="AgendaMedicoServlet?cmd=exib&id_exame=<%=l.getId_exame( )%>">    
        <img title="visualizar" src="icone3.jpg" alt="Pulpit rock" width="15" height="15"/> 
        </a>
        <a href="AgendaExameServlet?cmd=atu&id_exame=<%=l.getId_exame( )%>">    
        <img title="alterar" src="icone2.jpg" alt="Pulpit rock" width="15" height="15"/> 
        </a>
        <a href="javascript:excluir(<%=l.getId_exame( )%>)"> 
        <img title="exluir" src="icon.gif" alt="Pulpit rock" width="15" height="15"/> 
      	</a>
     </td>
</tr>

<script>
function excluir(id) {
	if (confirm("Tem certeza?")) {
		location.href="AgendaExameServlet?cmd=exc&id_exame=" + id;
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
