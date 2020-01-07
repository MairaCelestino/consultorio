<%@page import="dao.AgendaMedico"%>
<%@page import="dao.AgendaConsulta"%>
<%@page import="dao.AgendaPaciente"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"
    import="java.util.*, to.Anamnese, to.Paciente, util.ConverterDate" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Modelo CSS/HTML Básico</title>
<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>
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
			<a href="AgendaAnamneseServlet?cmd=listar">Buscar Anamnese</a></li>
            </li>
            </ul> 
<fieldset>
<legend><h3> Dados do Paciente</h3> </legend>
<form name="form1" id="form1" action="AgendaAnamneseServlet?cmd=addanam" method="post">

<label>Nome do Paciente:</label><small> * </small>
				<select name="tabPaciente" id="nome_pac">
				<option>Selecione</option>
				<%	
				AgendaPaciente daopac = new AgendaPaciente();
				List<Paciente> pacienteList = daopac.todosPacientes();
				for ( Iterator i = pacienteList.iterator( ); i.hasNext( ); ) {
				
					  Paciente l = ( Paciente )i.next( ); %>
				
							
				<option value="<%= l.getRe_pac()%>"><%= l.getNome_pac()%></option>
				<% }%>
				</select><br>
Registro Estatístico: <input type="text" id="re_paci" name="re_paci" size="5" maxlength="6" />
Data de Nascimento:   <input type="date" name="datanasc_pac">
Idade:				   <input type="text" name="idade" size="3" maxlength="2"/> anos <br><br>
Estado Civil: <select name="estado_civil" id="estado_civil">
						<option>Selecione</option>
						<option>Solteiro</option>
						<option>Casado</option>
			  </select>
Filhos:<input type="radio" name="filho" class="filho" value="Sim" /> Sim
	   <input type="radio" name="filho" class="filho" value="Não" />Não<br>
Religião:<input type="text" name="religiao" size="10" maxlength="10"><br>

 <h3> Histórico do Paciente </h3>

Internações:<textarea rows="2" cols="100" name="internacao" maxlength="1000"> </textarea>
Patologias:		<textarea rows="2" cols="100" name="patologia" maxlength="1000"> </textarea>
 Cirurgias:	     <textarea rows="2" cols="100" name="cirurgia" maxlength="1000"> </textarea>
 Uso de Medicação Diária: <textarea rows="2" cols="100" name="medicacao" maxlength="1000"> </textarea>
 Alergias: <textarea rows="2" cols="100" name="alergia" maxlength="1000"> </textarea>
 Vicios: <textarea rows="2" cols="100" name="vicio" maxlength="1000"> </textarea>
 Vacinas: <textarea rows="2" cols="100" name="vacina" maxlength="1000"> </textarea>
 
<h3> Histórico do Familiar</h3>

Infarto:  <textarea rows="2" cols="100" name="infarto" maxlength="1000"> </textarea>
Câncer:   <textarea rows="2" cols="100" name="cancer" maxlength="1000"> </textarea>
AVC:   	  <textarea rows="2" cols="100" name="avc" maxlength="1000"> </textarea>
Diabetes: <textarea rows="2" cols="100" name="diabete" maxlength="1000"> </textarea>
HAS:      <textarea rows="2" cols="100" name="has" maxlength="1000"> </textarea>
Anotações: <textarea rows="2" cols="100" name="anotacao" maxlength="1000"> </textarea><br>

<input type="submit" name="enviar" value="Salvar"></input>
<input type="reset" name="limpar" value="Limpar"></input>

</form>
</fieldset>      
	</div>
    <div id="rodape"><br/>
     	<p class="texto">Todos os Direitos Reservados - Junho de 2013<br />
        <a href="www.techs.com.br" target="_blank">www.techs.com.br</a></p>
     </div>  
</body>
</html>