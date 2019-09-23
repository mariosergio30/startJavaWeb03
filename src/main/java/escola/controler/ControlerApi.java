package escola.controler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import escola.model.entidade.Aluno;
import escola.model.entidade.Disciplina;
import escola.model.business.AlunosBusiness;
import escola.model.business.ResponseAvisoJson;

/* @RestController indica que essa a classe é um controlador WEB (expõe os métodos da classe como recursos web)  
 * Em outras palavras: faz com que esse classe fique escutando as requisições web que chegam a neste endereço localhost:8080
 * 
 * A diferença do @Controller é que:  
 * o @RestController faz com que o valor retornado no método (return) seja enviado para o browser no Corpo do Response HTTP
 * @RestController = @Controler + ResponseBody, por isso não precisamos anotar os metodos com @ResponseBody 
 * 
 * Se o return for um valor STRING, o conteúdo é enviado diretamente ao browser, 
 * sem passar por qualquer pré-processamento do Spring MVC (o Spring não tentará substituir por uma pagina jsp)
 * 
 * Se o return for o OBJETO JAVA qualquer, o Spring sabe que deverá processar (serializar) a resposta no formato JSON
	  antes de enviar o response ao browser.   
	  OBS: para isso, o Spring utiliza a library Jackson JSON Processor jackson-databind, 
	   importada automaticamente pelo Spring Boot 
 */


@RestController  
@RequestMapping("/api")  // Indica o mapeamento inicial para todos os recursos disponiveis neste Controler
public class ControlerApi {


	/* @Autowired: Injeção de Dependencia: injeta uma instancia de CidadeBusiness sem que seja necessário
	 *  instanciar o objeto explicitamente: 'new AlunosBusiness()'
	 */
	@Autowired
	AlunosBusiness alunosBusiness;

	
	
	// @ResponseBody  desnecessário, pois a classe já está anotada com @RestController 
    @RequestMapping(value = "/exemplo/frutas", method = RequestMethod.GET)
    public List<String> frutas() {
    	
		List<String> lista = new ArrayList<String>();
		lista.add("Abacaxi");
		lista.add("Manga");
		lista.add("Acerola");
		lista.add("Banana");
		lista.add("Goiaba");
		
		return lista;
    }
	
	/* @ResponseEntity também resultaria em um response JSON
	 * mesmo que a classe não estivesse anotada com @RestController
	 * ou o método anotado com @ResponseBody
	 * a diferença é que seria possivel alterar outros valores como:
	 * HttoStatus e Header do response  
	 	
    @RequestMapping(value = "/exemplo/frutas", method = RequestMethod.GET)
    public ResponseEntity<List<String>> frutas2() {
    	
    	List<String> lista = new ArrayList<String>();
		lista.add("Abacaxi");
		lista.add("Manga");
		lista.add("Acerola");
		lista.add("Banana");
		lista.add("Goiaba");
				
        return new ResponseEntity<List<String>>(lista, HttpStatus.OK);
    }
	*/
  	
	 	
    @RequestMapping(value = "/exemplo/umaDisciplina", method = RequestMethod.GET)
    public Disciplina umaDisciplina() {
    	
		Disciplina disciplina = new Disciplina();
		disciplina.setId(5);
		disciplina.setTitulo("Matemática");
		disciplina.setArea("Exatas");
		
        return disciplina;
    }
	
		 	
    @RequestMapping(value = "/exemplo/disciplinas", method = RequestMethod.GET)
    public List<Disciplina> listagemDisciplinas() {
    			
		Disciplina d1 = new Disciplina(1,"Portugues","Humanas");
		Disciplina d2 = new Disciplina(2,"Historia","Humanas");
		Disciplina d3 = new Disciplina(3,"Matematica","Exatas");
		Disciplina d4 = new Disciplina(4,"Física","Exatas");

		List<Disciplina> lista = new ArrayList<Disciplina>();
		lista.add(d1);
		lista.add(d2);
		lista.add(d3);
		lista.add(d4);
		
        return lista;
    }
	
	
	    
	
	// Este recurso somente será acionado em caso de requests pelo metodo GET
	@RequestMapping( value="aluno/listagem", method = RequestMethod.GET)	  
	public List<Aluno> alunolisgagem() {


		return alunosBusiness.getListAlunos(); // @RestController transforma a lista de aluno para o formato JSON
	}
		
	
	@RequestMapping( value="aluno/consulta", method = RequestMethod.GET)
    public Aluno alunoconsulta(@RequestBody String matricula) {
	
    	
        return  alunosBusiness.buscarAluno(matricula);  // @RestController transforma o objeto aluno para o formato JSON
    }
	
	
	// Este recurso somente será acionado em caso de requests pelo metodo POST
	@RequestMapping( value="aluno/salvar", method = RequestMethod.POST)
	public ResponseAvisoJson alunosalva(@RequestBody Aluno aluno) {  
		
		/* @RequestBody: os valores passados no body do request no formato JSON
			são deserializados em um objeto java
			neste caso do tipo Aluno
		*/

		alunosBusiness.salvaAluno(aluno);
		return new ResponseAvisoJson("Operação Realizada com sucesso !");   // @RestController transforma o Aviso para o formato JSON
	}

	

	

}



