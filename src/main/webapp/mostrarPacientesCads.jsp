<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"
    import="java.util.*, pacote.to.Paciente"  
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="jquery.dataTables.min.js"></script>
<script type="text/javascript" src="jquery.dataTables.js"></script>
<title>Modelo CSS/HTML Básico</title>
</head>
<body>

<script>
	$(document).ready(function() {
	    $('#tablePaciente').dataTable( {
	    	"sPaginationType": 
	    	"full_numbers"
	    } );
	} );
</script>
	<div id="geral">
		<div id="topo">
        
        </div>     
        
        <ul id="menu">
            <li>
            <a href="index.jsp" title="Entrada no site">Home</a>
            </li>
            <li>
            <a href="indexPaciente.jsp" title="Área de tutorial CSS">Paciente</a>
            </li>
            <li>
            <a href="cadMedico.html" title="Técnicas de layout com CSS">Médico</a>
            </li>
            <li>
            <a href="cadConsultas.jsp" title="Técnicas de efeitos em links">Consulta</a>
            </li>
            </ul>    
            
            <br>
		<form method="get" action="AgendaServlet">
		 <tr>
			<td>Nome do Paciente:</td>
				<td><input type="text" id="nome_pac" name="nome_pac" size=50 maxlength=30/>
				<input type="hidden" id="cmd" name="cmd" value="paciente"/></td>
				<input type="submit" name="Pesquisar" value="Pesquisar">
			</tr>
		</form>

<%
List pacienteList = ( List )request.getAttribute( "pacienteList" ); 
	if(pacienteList != null){%>
		<br>
		<br>

	<table "style=width:80%" class="linhasalternadas" id="tablePaciente">
	<thead>
		<tr> 
		    <th>Registro Est.</th>
		    <th>Nome do Paciente</th>
		    <th>Sexo Paciente</th>
		    <th>Data Nascimento</th>
		    <th> Ações </th>
		</tr>
	</thead>
		
<tbody>
<% 		
for( Iterator i=pacienteList.iterator( ); i.hasNext( ); ) 
{
  Paciente l = ( Paciente )i.next( );

%>
 <tr> 	
     <td><%=l.getRe_pac()%></td>
     <td><%=l.getNome_pac( )%></td>
     <td><%=l.getSexo_pac( )%></td>
	 <td><%=l.getDataNasc_pac()%> </td>
     <td>
     <a href="javascript:excluir(<%=l.getRe_pac( )%>)"> 
        <img title="exluir" src="icon.gif" alt="Pulpit rock" width="15" height="15"> 
     </a>
      <a href="AgendaServlet?cmd=atu&re_pac=<%=l.getRe_pac( )%>">    
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
	<script>
function excluir(id) {
	if (confirm("Tem certeza que deseja excluir?")) {
		location.href="AgendaServlet?cmd=exc&re_pac=" + id;
	}
	else {
	}
	
}
</script>
	</div>
    <div id="rodape"><br/>
     	<p class="texto">Todos os Direitos Reservados - Junho de 2013<br />
        <a href="www.techs.com.br" target="_blank">www.techs.com.br</a></p>
     </div>  
</body>
</html>