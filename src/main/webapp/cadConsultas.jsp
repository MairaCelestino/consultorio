<%@page import="pacote.dao.AgendaMedico"%>
<%@page import="pacote.dao.AgendaConsulta"%>
<%@page import="pacote.dao.AgendaPaciente"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"
    import="java.util.*, pacote.to.Medico, pacote.to.Paciente, pacote.util.ConverterDate"  
    %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="styles.css" rel="stylesheet" type="text/css" />
<title>Agenda Consulta</title>
</head>
<body>
	<div id="holder">
		<div id="header"></div>
		<div id="shadow">
			<div id="menu">
				<li><a href="AgendaConsultaServlet?cmd=listar">Consultar Consulta</li>
				</a>
				<li><a href="index.jsp">Inicio</a>
				</li>
			</div>
			<div id="content">
			<h3>Agendar Consulta</h3><br>
				<form name="form" id="form" onsubmit="return validar(this);" action="AgendaConsultaServlet?cmd=addconsul" method="post">
				
				<label>Nome do Paciente:</label><small> * </small>
				<select name="tabPaciente" id="nome_paciente">
				<option>Selecione</option>
				<%	
				AgendaPaciente daopac = new AgendaPaciente();
				List<Paciente> pacienteList = daopac.todosPacientes();
				for ( Iterator i = pacienteList.iterator( ); i.hasNext( ); ) {
				
					  Paciente l = ( Paciente )i.next( ); %>
				
							
				<option value="<%= l.getRe_pac()%>"><%= l.getNome_pac()%></option>
				<% }%>
				</select><br><br>
				
				<label>Nome do Medico: <small> * </small></label> 
				<select name="tabMedico" id="nome_medico">
				<option>Selecione</option>
				<%	
				AgendaMedico dao = new AgendaMedico();
				List<Medico> medicoList = dao.todosMedicos();
				for ( Iterator i = medicoList.iterator( ); i.hasNext( ); ) {
				
					  Medico l = ( Medico )i.next( ); %>
				
							
				<option value="<%= l.getCrm_med()%>"><%= l.getNome_med()%></option>
				<% }%>
				</select><br><br>
				
				<label>Data Consulta:  </label> <small> * </small>
				<input type="text" id="data_consulta" name="data_consulta" size="10" maxlength="10" /><br><br class="clear" /> 
									
				
				<label>Horario:</label> <small>*</small>
				<input type="text" id="horario_consulta" name="horario_consulta" size=5 maxlength=10 />hrs<br><br class="clear" />
				
				
				 <label><span>
				 <small>*</small>Todos os campos são obrigatórios.</span><br> <br class="clear" />
				</label>
				 <label> <input type="submit" id="enviar" name="btCadastrar" value="Enviar" width=20px; height= 5px; />
				 		 <input type="reset" name="btLimpar" value="Limpar" /><br class="clear" /> 
				 </label>
				</form>

			</div>
			<div id="edito">
				<div id="vertical_barr">
					<div id="vertical_barr"></div>
				</div>
				
				<script type="text/javascript" src="jquery-1.9.1.min.js"></script>
				<script type="text/javascript" src="jquery.maskedinput-1.3.min.js" ></script>
				<script type="text/javascript">
					function validar(form) {
						if(form.nome_pac.value == 'Selecione'){
							alert("O campo Nome do Paciente é obrigatório.");
							return false;
						}
						if (form.nome_med.value == 'Selecione') {
							alert("O campo Nome do Medico é obrigatório.");
							return false;
						}

						if (form.data_consulta.value == ''){
							alert("O campo Data da Consulta é obrigatório.");
							return false;
						}

						if (form.horario_consulta.value == '') {
							alert("O campo Horario é obrigatório.")
							return false;
						}
						return true;
					}
				</script>
				<!-- ADICIONA MASCARAS NO CAMPO DATA E HORA!!! -->
				<script type="text/javascript">
					$(document).ready(function(){
						$("#horario_consulta").mask("99:99:99");
					});
				</script>
</body>
</html>