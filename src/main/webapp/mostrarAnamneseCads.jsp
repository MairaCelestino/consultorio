<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"
    import="java.util.*, pacote.to.Anamnese, pacote.util.ConverterDate"  
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
	    $('#tableAnamnese').dataTable( {
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
    <li> <a href="cadPaciente.html">Novo Paciente</a> </li>
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
		<form method="get" action="AgendaAnamneseServlet" >
		 <tr>
			<td>Nome do Paciente:</td>
				<td><input type="text" id="nome_pac" name="nome_pac" size=50 maxlength=100/>
				<input type="hidden" id="cmd" name="cmd" value="anamnese"></td>
				<input type="submit" name="Pesquisar" value="Pesquisar">
			</tr>
		</form>

<%
List anamneseList = ( List )request.getAttribute( "anamneseList" ); 
	if(anamneseList != null){%>
		<br>
		<br>

	<table "style=width:100%" class="linhasalternadas" id="tableAnamnese">
	<thead>
		<tr> 
		    <th>ID ANAMNESE.</th>
		     <th>REGISTRO EST.</th>
		    <th>NOME PACIENTE</th>
		    <th> Ações </th>
		</tr>
	</thead>
		
<tbody>
<% 		
for( Iterator i=anamneseList.iterator( ); i.hasNext( ); ) 
{
  Anamnese l = ( Anamnese )i.next( );

%>
 <tr> 	
     <td><%=l.getId_anamnese()%></td>
     <td><%=l.getPaciente().getRe_pac()%></td>
     <td><%=l.getPaciente().getNome_pac()%></td>
     <td>
     <a href="javascript:excluir(<%=l.getId_anamnese( )%>)"> 
        <img title="exluir" src="icon.gif" alt="Pulpit rock" width="15" height="15"/> 
     </a>
      <a href="AgendaAnamneseServlet?cmd=atu&id_anamnese=<%=l.getId_anamnese()%>">
       <img title="alterar" src="icone2.jpg" alt="Pulpit rock" width="15" height="15"/> </a>
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
<!-- END HOLDER -->
<script>
function excluir(id) {
	if (confirm("Tem certeza que deseja excluir?")) {
		location.href="AgendaAnamneseServlet?cmd=exc&id_anamnese=" + id;
	}
	else {
	}
	
}
</script>
</body>
</html>
