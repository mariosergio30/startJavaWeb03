package escola.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import escola.model.business.AlunosBusiness;
import escola.model.entidade.Aluno;

/* @Controller indica que essa a classe é um controlador WEB (expõe os métodos da classe como recursos web)  
 * Em outras palavras: faz com que essa classe fique escutando as requisições web que chegam a neste endereço localhost:8080  
 */

@Controller  
@RequestMapping("/site")  // Indica o mapeamento inicial para todos os recursos disponiveis neste Controler (endpoints)
public class ControlerSite {
    
	/* @Autowired: Injeção de Dependencia: injeta uma instancia de CidadeBusiness sem que seja necessário
	 *  instanciar o objeto explicitamente: 'new AlunosBusiness()'
	*/	
	@Autowired   
	AlunosBusiness alunosBusiness;
	
	
	
	@RequestMapping("aluno/listagem")  // Indica o nome do recurso que será parte final do mapeamento, ex: localhost:8080/escola/alunolistagem
    public String alunolisgagem(Model model) {
    	
				
		if (!alunosBusiness.getConexaoJdbc().isConnectado()) 
			return this.preparaAviso(model, "A conexão ao banco de dados não foi realizada !");
				
		// Injeta um atributo Lista na View
    	model.addAttribute("listaAlunos", alunosBusiness.getListAlunos());  
    	
    	
        return "escola_aluno_listagem";  // responde ao browser com a view escola_aluno_listagem.jsp (ver WebConfig)
    }
	
	
	
	
	
	
	@RequestMapping("aluno/consulta") 
    public String alunoconsulta(Model model, @RequestParam( value="matricula", required=true) String matricula) {
    	
		
		if (!alunosBusiness.getConexaoJdbc().isConnectado()) 
			return this.preparaAviso(model, "A conexão ao banco de dados não foi realizada !");

		
		// Injeta um atributo Objeto na View
    	model.addAttribute("aluno", alunosBusiness.buscarAluno(matricula))  ;
    	
        return "escola_aluno_cadastro";  // responde ao browser com a view escola_aluno_listagem.jsp (ver WebConfig)
    }
	
	
	
	
	// Este recurso somente será acionado em caso de requests pelo metodo POST
	@RequestMapping( value="aluno/salvar", method = RequestMethod.POST)
    public String alunosalvar(Model model, @ModelAttribute("aluno") Aluno aluno) {   

		// @ModelAttribute: os valores passados por um <form> são deserializados em um objeto java
		
		if (!alunosBusiness.getConexaoJdbc().isConnectado()) 
			return this.preparaAviso(model, "A conexão ao banco de dados não foi realizada !");
		

		alunosBusiness.salvaAluno(aluno);		
    	return this.preparaAviso(model, "Operação realizada com Sucesso !");
    }
	
	
	
	
	/* coloque esse endpoint no action do formulario, para testar o recebimento dos parametros individualmente como String */
	@RequestMapping( value="aluno/salvarparametros", method = RequestMethod.POST)
    public String alunosalvarTeste(Model model, 
    		@RequestParam( value="nome", required=true) String nome,
			@RequestParam( value="matricula", required=true) String matricula,
			@RequestParam( value="idade", required=true) int idade) {
    	
		System.out.println("Nome: " + nome + ", Matricula :" + matricula + ", idade  + idade");
		return this.preparaAviso(model, "Nome: " + nome + ", Matricula :" + matricula + ", idade  + idade");			
    }


	
	private String preparaAviso(Model model,String aviso) {
		
		model.addAttribute("aviso", aviso);  
    	
        return "aviso";
		
	}
	   
    
}
