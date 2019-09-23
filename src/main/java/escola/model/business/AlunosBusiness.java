package escola.model.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import escola.model.dao.AlunoDao;
import escola.model.dao.ConexaoJDBC;
import escola.model.entidade.Aluno;

@Component
public class AlunosBusiness {

	
	/* @Autowired: Injeção de Dependencia: injeta uma instancia de ConexaoJDBC sem que seja necessário
	 *  instanciar o objeto explicitamente: 'new ConexaoJDBC()'
	*/
	@Autowired
	private ConexaoJDBC con;

	private List<Aluno> listAlunos = new ArrayList();


	public AlunosBusiness(ConexaoJDBC con) {
		super();

		this.con = con;
		
		try {
		    this.con.conecta();		    
		}
		catch (Exception e) {		
			System.out.println("Erro ao tentar conectar ao banco de dados !");			
		}
		
		
		try {		    
		    System.out.println("Aguarde, carregando alunos matriculados a partir do BD....");

			AlunoDao alunoDao = new AlunoDao(this.con);
			this.listAlunos = alunoDao.recupera();
		}
		catch (Exception e) {		
			System.out.println("Erro ao tentar carregar tabela de alunos !");			
		}

		
		System.out.println("Carga finalizada " + this.listAlunos.size() + " registros.");

	}


	// matricula de um novo aluno 
	public boolean matricular(Aluno a) {

		AlunoDao alunoDao = new AlunoDao(this.con);

		if (alunoDao.insert(a)) {    		
			listAlunos.add(a);    // adiciona aluno na lista
			return true;
		}

		return false;
	}


	public Aluno buscarAluno(String matricula) {

		AlunoDao alunoDao = new AlunoDao(this.con);
		
		return alunoDao.recupera(matricula);
	}
	

	// saida de um aluno da escola 
	public void removeAluno(Aluno a) {

		AlunoDao alunoDao = new AlunoDao(this.con);

		if (alunoDao.deleta(a))   
			this.listAlunos.remove(a);
	}


	public void salvaAluno(Aluno a) {

		AlunoDao alunoDao = new AlunoDao(this.con);

		if (alunoDao.update(a))   
			this.listAlunos = alunoDao.recupera();
//			this.listAlunos.add(a);
	}


	/* retorna a lista completa de Alunos
	 matriculados */
	public List<Aluno> getListAlunos() {
		return listAlunos;
	}

	public ConexaoJDBC getConexaoJdbc() {
		
		return this.con;
	}




}
