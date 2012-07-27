<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/CET/padrao/bootstrap/css/bootstrap.css">

<style type="text/css">
	
	td{
		border:solid black 1pt;
		border-collapse: collapse;
		padding: 2px;
	}
	
	.cabecalho{
		font-family: serif;
		font-size: 12px;
		font-weight: bold;
		text-align: center;
		font-size: 12pt;
		font-family:"Times New Roman","serif";
	}


	.corpo{
		font-size: 9pt;
		font-family:"Arial","sans-serif";
		padding: 500px;
	}

</style>

</head>
<body>

<table width="100%" height="100%" style="margin-top: 30px;">
	<thead> 
		<tr>
			<td colspan="4" class="cabecalho">
				POSTO DE ENSAIO DE CRONOTAC�GRAFOS N� 13/2010<br />
				RELAT�RIO MENSAL - M�S JANEIRO / Per�odo de 02/01/2012 � 04/01/2012
				
			</td>
		</tr>
		
		<tr class="corpo">
			<td width="60%" colspan="2" >
				NOME: CARLITO COM�RCIO DE PE�AS LTDA
			</td>
			<td colspan="2" >
				ENDERE�O: R. VISC. DE S�O LEOPOLDO 437
			</td>
		</tr>
		<tr class="corpo">
			<td width="30%">
				BAIRRO: SANTOS
			</td>
			<td width="30%">
				CEP: 11010-201
			</td>
			<td width="20%">
				CIDADE: SANTOS
			</td>
			<td width="20%">
				ESTADO:  SP
			</td>
		</tr>
		<tr class="corpo">
			<td width="30%">
				TELEFONE: (13) 3023-4466
			</td>
			<td width="30%">
				FAX: (13) 3023-4466
			</td>
			<td width="20%">
				SITE: WWW.CAPNET.COM.BR
			</td>
			<td width="20%">
				E-MAIL: LUCIANO@CAPNET.COM.BR
			</td>
		</tr>
		
		<tr class="corpo">
			<td colspan="4" bgcolor="grey" height="8px" />
		</tr>
	</thead>
</table>
<table border="1" width="100%" style="border-top-style: hidden;">

	<tr align="center" class="corpo">
		<th width="30%" rowspan="2">
			PROPRIET�RIO
		</th>
		<th width="10%" rowspan="2">
			VE�CULO<br />
			PLACA
		</th>
		<th width="30%" colspan="3">
			CRONOTAC�GRAFO
		</th>
		<th width="10%" rowspan="2">
			GRU N�
		</th>
		<th width="10%" rowspan="2">
			DATA<br /> 
			ENSAIO
		</th>
	</tr>
	<tr align="center" class="corpo">
		<th width="10%">
			MARCA
		</th>
		<th width="10%">
			MODELO
		</th>
		<th width="10%">
			N� S�RIE
		</th>
		
	</tr>
	<tbody>
	
		<s:iterator begin="0" end="30">
		
			<tr style="font-size: 10px;">
				<td>
					Paulo Santos
				</td>
				<td>
					ABC-1234
				</td>
				<td>
					VDO
				</td>
				<td>
					MTCO 1390
				</td>
				<td>
					182763527839
				</td>
				<td>
					A049836356745
				</td>
				<td>
					10/12/2012
				</td>
			
			</tr>
		
		</s:iterator>
	</tbody>
	<tfoot>
		<tr>
			<td>
				Data:
			</td>
			<td colspan="6">
				Respons�vel:
			</td>
		</tr>
	</tfoot>
	

</table>


</body>
</html>