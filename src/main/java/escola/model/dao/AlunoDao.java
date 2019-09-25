package escola.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import escola.model.entidade.Aluno;

public class AlunoDao implements InterfaceCrudDAO<Aluno> {
		
	private ConexaoJDBC conexaoJDBC;
			
	
	public AlunoDao(ConexaoJDBC conexaoJDBC) {
		super();
		this.conexaoJDBC = conexaoJDBC;
	}
	


	public boolean insert(Aluno obj) {
		
		String sql = "";
		sql = "insert into ALUNO (nome,cpf,matricula,idade,sexo,escolaridade)";
		sql += " values (?,?,?,?,?,?)";						
	
		PreparedStatement declaracaoPrep = this.conexaoJDBC.preparaDeclaracao(sql);		
	
		try {
			declaracaoPrep.setString(1, obj.getNome());
			declaracaoPrep.setString(2, obj.getCpf());
			declaracaoPrep.setString(3, obj.getMatricula());
			declaracaoPrep.setInt(4, obj.getIdade());
			declaracaoPrep.setString(5, obj.getSexo());
			declaracaoPrep.setString(6, obj.getEscolaridade().toString());
			
			declaracaoPrep.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
		
		return true;
	}



	public boolean update(Aluno obj) {
		String sql = "";
		sql = "update ALUNO set nome = ?, cpf = ?, idade = ?, sexo = ?, escolaridade = ?";
		sql += " where matricula = ?";					
	
		PreparedStatement declaracaoPrep = this.conexaoJDBC.preparaDeclaracao(sql);		
	
		try {
			declaracaoPrep.setString(1, obj.getNome());
			declaracaoPrep.setString(2, obj.getCpf());
			declaracaoPrep.setInt(3, obj.getIdade());			
			declaracaoPrep.setString(4, obj.getSexo());
			declaracaoPrep.setString(5, obj.getEscolaridade().toString());
			
			declaracaoPrep.setString(6, obj.getMatricula());
			
			declaracaoPrep.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
		
		return true;
	}


	public boolean deleta(Aluno obj) {
		String sql = "";
		
		sql = "delete from ALUNO";
		sql += " where matricula = ?";		
				
		
		PreparedStatement declaracaoPrep = this.conexaoJDBC.preparaDeclaracao(sql);

		try {
			
			declaracaoPrep.setString(1,  obj.getMatricula());
			
			declaracaoPrep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}


	
	public List<Aluno> recupera() {


		ResultSet dados = this.query(null);

		// se a consulta contiver erros 
		if (dados == null) 
			return null;


		try {

			if (!dados.first()) 
				return null;
			
			
			List<Aluno> list = new ArrayList<Aluno>();

			// inclui todos os registros provenientes do banco de dados
			//   na lista
			do  
			{
				Aluno a = new Aluno();
				a.setCpf(dados.getString("cpf"));
				a.setMatricula(dados.getString("matricula"));
				a.setNome(dados.getString("nome"));
				a.setIdade(dados.getInt("idade"));
				a.setSexo(dados.getString("sexo"));
				a.setEscolaridade(dados.getString("escolaridade"));
				list.add(a);

			} while (dados.next());
			
			dados.close();
			
			return list;


		} catch (SQLException e) {
			System.out.println(e.getMessage().toString());
			return null;			
		}

		
	}


	public Aluno recupera(String matricula) {
		// TODO Auto-generated method stub
		
		ResultSet dados = this.query(" matricula = " + "'" + matricula + "'");

		Aluno a = null;
		
		if (dados == null) {
			return a;
		}
		
		try {
			if (dados.first()) { 
				a = new Aluno();
				a.setCpf(dados.getString("cpf"));
				a.setMatricula(dados.getString("matricula"));
				a.setNome(dados.getString("nome"));
				a.setIdade(dados.getInt("idade"));	
				a.setSexo(dados.getString("sexo"));
				a.setEscolaridade(dados.getString("escolaridade"));
			}	
			dados.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block			
			System.out.println(e.getMessage().toString());
			return null;
		}
		
		return a;
	}

	
	
	private ResultSet query(String filtro) {
	
		String sql = "Select * from ALUNO";
		
		if (filtro != null)
			sql += " where " + filtro;	
			
		sql += " order by nome";

		return this.conexaoJDBC.consulta(sql);		
	}
	
			
	

}
