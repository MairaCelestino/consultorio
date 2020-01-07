<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"
    import="util.ConverterDate, to.Medico, dao.AgendaMedico"
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="style.css" rel="stylesheet" type="text/css">
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
    <li> <a href="index.jsp">Home</a> </li>
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
  <% Medico medico = (Medico)request.getAttribute("medico"); %>
<table "style=width:100%" class="linhasalternadas" >
	<tr>
	<td>CRM : <%= medico.getCrm_med()%><br></td>
	</tr>
	<tr>
	<td>Nome do Medico: <%= medico.getNome_med()%><br></td>
	</tr>
	<tr>
		<td>Especialidade:<%= medico.getEspecialidade()%><br></td>  
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
