<%@page import="dao.AgendaMedico"%>
<%@page import="dao.AgendaExame"%>
<%@page import="dao.AgendaPaciente"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"
    import="java.util.*, to.TipoExame, to.Exame, to.Paciente, util.ConverterDate"  
    %>
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
            </ul>
            
            <form action="AgendaExameServlet?cmd=addexa" method="post">
				<label>Nome do Paciente:</label>
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
				
				<label>Ano: </label>
				<select name="ano_exame">
				<option>Selecione o ano</option>
				<%	
				for(int i=2013; i<2030; i++ ) { %>				
				<option value="<%= i%>"><%= i%></option>
				<% }%>
				</select>
				
				
				
				<% AgendaExame exameDAO = new AgendaExame();
					List<TipoExame> tipoexame= exameDAO.todosExames(); //Select de todos os dados da tabela exame
					Exame exame = new Exame();
				%>
				<table border="2">
				<tr>
					<td>Exame</td>
					<td>Resultado</td>
				</tr>
			<% for( Iterator i=tipoexame.iterator( ); i.hasNext( ); ) 
					{
  						TipoExame examet = (TipoExame)i.next( );
				%>
				<tr>
				<td><%= examet.getNome_exame() %></td>
				<td><input type="hidden" name="id_tipoexame<%=examet.getId_tipoexame()%>" value="<%=examet.getId_tipoexame()%>"></input>
				<input type="text" name="resultado<%=examet.getId_tipoexame()%>" size="7"/>
				</td>
				</tr>
				<% } %>
				
				<br>
				<br>
				</table>
				<input type="submit" name="salvar" value="Salvar"/>
				<input type="reset" name="limpar" value="Limpar"/>
				
		</form>       
	</div>
    <div id="rodape"><br/>
     	<p class="texto">Todos os Direitos Reservados - Junho de 2013<br />
        <a href="www.techs.com.br" target="_blank">www.techs.com.br</a></p>
     </div>  
</body>
</html>