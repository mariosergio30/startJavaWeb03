package escola.model.entidade;

public final class Disciplina {

	private int id = 0;
    private String titulo = "";
    private String area = "";
    
  
    public Disciplina() {
    	
	}
    
    
    public Disciplina(int id, String titulo, String area) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.area = area;
	}

	public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    
}
