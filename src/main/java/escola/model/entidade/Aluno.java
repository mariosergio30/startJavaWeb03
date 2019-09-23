package escola.model.entidade;


public final class Aluno extends Pessoa {
	
	public enum Escolaridade {		
		FUNDAMENTAL, MEDIO, SUPERIOR		
	}
	
	private String matricula;
	
	private double media;
	private String status;
	private String trabalho;
	private int qtdFaltas;
	private Escolaridade escolaridade;

	public double getMedia() {
		return media;
	}
	
	public void setMedia(double media) {
		this.media = media;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}


	public String getTrabalho() {
		return trabalho;
	}
	
	public void setTrabalho() {
		this.trabalho = trabalho;
	}
	
	public int getQtdFaltas() {
		return qtdFaltas;
	}
	
	public void setQtdFaltas(int qtdFaltas) {
		this.qtdFaltas = qtdFaltas;
	}
	
	
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}
	
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}
	
	
	public void setEscolaridade(String c) {
		
		if (c == null)
			return;
		
		switch (c) {
		case "FUNDAMENTAL" : 
			this.escolaridade = Escolaridade.FUNDAMENTAL;
			return;
		case "MEDIO" : 
			this.escolaridade = Escolaridade.MEDIO;;
			return;
		case "SUPERIOR" : 
			this.escolaridade = Escolaridade.SUPERIOR;
			return;		
		case "1" : 
			this.escolaridade = Escolaridade.FUNDAMENTAL;
			return;
		case "2" : 
			this.escolaridade = Escolaridade.MEDIO;;
			return;
		case "3" : 
			this.escolaridade = Escolaridade.SUPERIOR;
			return;
		}
		
	}

	
	public void imprimeCartaodeAniversario() {
		// TODO Auto-generated method stub
		
		System.out.println("Caro Aluno " + this.getNome() + " do ensino " + this.escolaridade +  " PARAB�NS pelo seu anivers�rio !");
		
		
	}





}