

function exibirMsg() {
	
    var elemento = document.getElementById('usuario');
    
    var nome = "Anônimo";
    
    if (elemento != null)
	   nome = elemento.innerHTML;
	
	window.alert("Oi " + nome + " Essa mensagem é resultado de programação CLIENTE SIDE em Java Script");
	
}

