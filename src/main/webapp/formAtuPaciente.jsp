<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"
    import="util.ConverterDate, to.Paciente"
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="styles.css" rel="stylesheet" type="text/css">
<title>Agenda Consulta</title>
</head>
<body>
    <jsp:useBean id="paciente" scope="session" class="to.Paciente" /> 
<body>
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
   <form action="AgendaPacienteServlet?cmd=atualizar" method="post">
<table>
	<tr>
	<td><label>Registro Estátistico:</label></td><td><input type="text" name="re_pac" size=10 maxlength=10 value="${paciente.re_pac}" readonly="readonly"/><br></td>
	</tr>
	<tr>
	<td><label>Nome do Paciente</label></td><td><input type="text" id="nome_pac" name="nome_pac" size=50 maxlength=30 value="${paciente.nome_pac}"/><br></td>
	</tr>
	<tr>
		<td><label>Sexo:</label></td>  
						
						<% 
						Paciente teste = new Paciente();
						teste = (Paciente) session.getAttribute("paciente"); 
						if(teste.getSexo_pac()== "Masculino"){%>
						<td><input type="radio" name="sexo_pac" class="sexo_pac"
							value="Masculino" checked="true"/> Masculino 
							<input type="radio" name="sexo_pac" class="sexo_pac" value="Feminino" />
							Feminino</td> <%}else { %><td><input type="radio" name="sexo_pac" class="sexo_pac"
							value="Masculino" /> Masculino 
							<input type="radio" name="sexo_pac" class="sexo_pac" value="Feminino" checked="true" />
							Feminino<br></td><%}%>
	</tr>
	<tr>
		<td><label>Data Nascimento:</label></td><td><input type="text" name="dataNasc_pac" value="${paciente.dataNasc_pac}" /><br></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" name="btAtualizar" value="Atualizar" />
		</td>
	</tr>	

</table>
</form>
	</div>
    <div>
     
      
    </div>
    <!-- END ABOUT ME -->
    <!-- NEWS -->
    <div id="vertical_barr">
    
      </div>
    <!-- END NEWS -->
    <!-- SERVICES -->
    <div>
      <h1></h1>
      <p></p>
      <ul>
      
      </ul>
      
     </div>
    <!-- END SERVICES -->
  </div>
      <!-- END CONTENT -->
  <div class="clear"></div>
     <!-- END SHADOW -->
</div>
<!-- FOOTER -->
<div id="footer">
  <p>My Company &copy;2013 I <a href="#">Contact</a> </p>
</div>
<!-- END FOOTER -->
</div>
<!-- END HOLDER -->
</body>
</html>
