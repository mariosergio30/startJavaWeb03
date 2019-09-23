package escola.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/* @Controller indica que essa a clase é um controlador WEB (expõe os métodos da classe como recursos web)  
 * Em outras palavras: faz com que essa classe fique escutando as requisições web que chegam a neste endereço localhost:8080  
 */

@Controller
public class ControlerIndex {
	
	/*  MAPEAMENTO RAIZ: será acionado sempre que apenas o endereço do servidor
	 *  for informado na url, ex: http://localhost:8080
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
				
	     return "index";  // responde ao browser com a view index.jsp (ver WebConfig)
	}

    
}
