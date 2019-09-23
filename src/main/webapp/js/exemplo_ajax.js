
function chamadaAjax() {
	
	$.ajax({

        url: "http://localhost:8080/aprendendo/consultaajax",
        data: "consulta=disciplina",
        type: "POST",
        async: true,
        timeout:10000,

        beforeSend: function(xhr) {
            //xhr.setRequestHeader("Accept", "application/json");
            //xhr.setRequestHeader("Content-Type", "application/json");
            $("#respostaajax").html("ENVIANDO...");
        },

        success: function(resposta) {

        	$("#respostaajax").html("RECEBIDO COM SUCESSO !");
        	$("#dados_id").html(resposta.id);
        	$("#dados_titulo").html(resposta.titulo);
        	$("#dados_area").html(resposta.area);
        	$("#resposta_completa").html(JSON.stringify(resposta, null, 4));
        },

        error: function(msg) {

        	$("#respostaajax").html("Não houve Resposta do Servidor !")
        	//$("#respostaajax").html("ERRO: " + msg.responseText);       	
        }
        

    });
	
}




function chamadaAjaxLista() {
	
	$.ajax({

        url: "http://localhost:8080/aprendendo/consultaajax",
        data: "consulta=alunos",
        type: "POST",
        async: true,
        timeout:10000,

        beforeSend: function(xhr) {
            //xhr.setRequestHeader("Accept", "application/json");
            //xhr.setRequestHeader("Content-Type", "application/json");
            $("#respostaajaxLista").html("ENVIANDO...");
        },

        success: function(resposta) {

        	$("#respostaajaxLista").html("RECEBIDO COM SUCESSO !");
        	$("#resposta_completaLista").html(JSON.stringify(resposta, null, 4));
        	
        },

        error: function(msg) {

        	$("#respostaajaxLista").html("Não houve Resposta do Servidor !")
        	//$("#respostaajax").html("ERRO: " + msg.responseText);       	
        }
        

    });

	
}

