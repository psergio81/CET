<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="visualization" style="width: 350px; height: 260px;"> </div>

<%@ attribute name="tituloDaSerie" required="true" description="Titulo da Série"%>
<%@ attribute name="tituloDoGrafico" required="false" description="Titulo do gráfico"%>

 

<script type="text/javascript" src="http://www.google.com/jsapi" ></script>

<script type="text/javascript">

	google.load('visualization', '1');
	google.setOnLoadCallback(drawVisualization);
	
	var tituloDoGrafico = '<c:out value="${tituloDoGrafico}" />';
	var tituloDaSerie = '<c:out value="${tituloDaSerie}" />';
    var valores = new String('<c:out value="${ultimosEnsaiosJson}" />');
	
    var arrayValores = new Array(); 
    arrayValores = quebraTexto(valores, ",");
    
	function drawVisualization() {
		
// 	    var data = new google.visualization.DataTable();
// 	    data.addColumn('string', tituloDaSerie);
// 	    data.addColumn('number', tituloDaSerie);
 	    
// 	   for (var i in arrayValores) {
// 	        var j = new Array();
	        
// 	        j = quebraTexto(arrayValores[i],":");
	        
// 		    data.addRow([j[0],parseInt(j[1])]);
// 	    }


var data = new google.visualization.DataTable();
       data.addColumn('string', 'Mês'); // Implicit domain column.
       data.addColumn('number', '2012'); // Implicit data column.
       data.addColumn('number', '2013');
       data.addRows([
         ['Jan', 1100,   400],
         ['Fev', 1200,   460],
         ['Mar',  800,  1120],
         ['Abr',  600,    540]
       ]);
	    
	    var wrapper = new google.visualization.ChartWrapper({
	      chartType: 'ColumnChart',
	      dataTable: data,
	      options: {'title': tituloDoGrafico},
	      containerId: 'visualization'
	    });
	    wrapper.draw();
	  }

    function quebraTexto(texto, delimitador){
        
        var arrayRetorno = texto.split(delimitador);

        return arrayRetorno;
    }

</script>
