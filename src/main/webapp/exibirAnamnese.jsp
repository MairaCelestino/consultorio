<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"
    import="pacote.util.ConverterDate, pacote.to.Anamnese, pacote.dao.AgendaAnamnese"
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="styles.css" rel="stylesheet" type="text/css">
<title>Agenda Consulta</title>
</head>
<body>
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
  	   <br>
		<form method="get" action="AgendaAnamneseServlet">
		 <tr>
			<td>ID ANAMNESE:</td>
				<td><input type="text" id="id_anamnese" name="id_anamense" size=50 maxlength=30/>
				<input type="hidden" id="cmd" name="cmd" value="anamnese"></td>
				<input type="submit" name="Pesquisar" value="Pesquisar">
			</tr>
		</form>
		
  <% Anamnese anamnese = (Anamnese)request.getAttribute("anamnese"); %>
  
<table "style=width:100%" class="linhasalternadas" >
	<tr>
	<td>Paciente :<%= anamnese.getNome_pac()%><br></td>
	</tr>
	<tr>
	<td>Registro Est: <%= anamnese.getRe_paci()%><br></td>
	</tr>
	<tr>
	<td>Data Nascimento:<%= anamnese.getDatanasc_pac()%><br></td>  
	</tr>
	<tr>
	<td>Idade :<%= anamnese.getIdade()%><br></td>
	</tr>
	<tr>
	<td>Filhos: <%= anamnese.getFilho()%><br></td>
	</tr>
	<tr>
	<td>Religião:<%= anamnese.getReligiao()%><br></td>  
	</tr>
	<tr>
	<td>Internações:<%= anamnese.getInternacao()%><br></td>
	</tr>
	<tr>
	<td>Patologias:<%= anamnese.getPatologia()%><br></td>
	</tr>
	<tr>
	<td>Cirurgias:<%= anamnese.getCirurgia()%><br></td>  
	</tr>
	<tr>
	<td>Uso de Medicação :<%= anamnese.getMedicacao()%><br></td>
	</tr>
	<tr>
	<td>Alergias: <%= anamnese.getAlergia()%><br></td>
	</tr>
	<tr>
	<td>Vicios:<%= anamnese.getVicio()%><br></td>  
	</tr>	
	<tr>
	<td>Vacinas:<%= anamnese.getVacina()%><br></td>  
	</tr>
	<tr>
	<td>Infarto:<%= anamnese.getInfarto()%><br></td>
	</tr>
	<tr>
	<td>Cancêr:<%= anamnese.getCancer()%><br></td>
	</tr>
	<tr>
	<td>AVC:<%= anamnese.getAvc()%><br></td>  
	</tr>
	<tr>
	<td>Diabete:<%= anamnese.getDiabete()%><br></td>
	</tr>
	<tr>
	<td>HAS: <%= anamnese.getHas()%><br></td>
	</tr>
	<tr>
	<td>Anotações:<%= anamnese.getAnotacao()%><br></td>  
	</tr>	
</table>
	<br></br>
	<td colspan="2">
			<input type="submit" name="btVoltar" value="Voltar" onclick="javascript:history.go(-1)" /> 
		</td>
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
</div>
<!-- END FOOTER -->
</div>
<!-- END HOLDER -->
</body>
</html>
