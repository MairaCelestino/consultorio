<%@page import="pacote.dao.AgendaMedico"%>
<%@page import="pacote.dao.AgendaConsulta"%>
<%@page import="pacote.dao.AgendaPaciente"%>

<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"
    import="java.util.*,pacote.util.ConverterDate, pacote.to.Consulta, pacote.to.Paciente, pacote.to.Medico"
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="styles.css" rel="stylesheet" type="text/css">
<title>Agenda Consulta</title>
</head>
<body>
    <jsp:useBean id="consulta" scope="session" class="pacote.to.Consulta" /> 
<div id="holder">
		<div id="header"></div>
		<div id="shadow">
			<div id="menu">
				<li><a href="AgendaConsultaServlet?cmd=listar">Consultar Consulta</a></li>
				<li><a href="index.jsp">Inicio</a></li>
			</div>
		<div id="content">
   			<form name="form" id="form" action="AgendaConsultaServlet?cmd=atualizar" method="post">
				<table>	
					<tr>	
						<td><label>Nome do Paciente:</label><td>
						<td><select name="tabPaciente" id="nome_paciente">
							<%	
								AgendaPaciente daopac = new AgendaPaciente();
								List<Paciente> pacienteList = daopac.todosPacientes();
								for ( Iterator i = pacienteList.iterator( ); i.hasNext( ); ) {
				  						Paciente l = ( Paciente )i.next( ); %>
						<option value="<%= l.getRe_pac()%>"<% if(consulta.getRe_paciente().getNome_pac() == l.getNome_pac()){%>
		 						selected <%}%>><%= l.getNome_pac()%>
						</option> <%}%>
						</select></td>
					</tr><br><br>
					<tr>
						<td><label>Nome do Medico:</label><td>
						<td><select name="tabMedico" id="nome_medico">
							<%	
								AgendaMedico dao = new AgendaMedico();
								List<Medico> medicoList = dao.todosMedicos();
								for ( Iterator i = medicoList.iterator( ); i.hasNext( ); ) {
				        			Medico l = ( Medico )i.next( ); %>
							<option value="<%= l.getCrm_med()%>"<% if(consulta.getCrm_medico().getNome_med() == l.getNome_med()){%>
		 						selected <%}%>><%= l.getNome_med()%>
							</option> <%}%>
							</select></td>
						</tr><br><br>
	
						<tr>
							<td><label>Data Consulta:</label><td><td><input type="text" id="data_consulta" name="data_consulta" size=10 maxlength=10 value="${consulta.data_consulta}"/><br></td>
                       </tr>	
                       <tr>
 							<td><label>Horario Consulta:</label><td><td><input type="text" id="horario_consulta" name="horario_consulta" size=5 maxlength=10 value="${consulta.horario_consulta}"/><br></td>  
						</tr>
						<tr>
						<td colspan="2">
						<input type="submit" name="btAtualizar" value="Atualizar" />
							</td>
						</tr>
                 </table>
          </form>
	</div>
</div>
</div>

<script type="text/javascript" src="jquery-1.9.1.min.js"></script>
				<script type="text/javascript" src="jquery.maskedinput-1.3.min.js" ></script>
				<script type="text/javascript">
					$(document).ready(function(){
						$("#data_consulta").mask("9999-99-99");
						$("#horario_consulta").mask("99:99:99");
					});
				</script>
</body>
</html>
