package beans;

public class Series {
	
	private Long id;
	private String nome;
	private String datainicial;
	private String datafinal;
	
	//Se colocar-mos o objeto Projeto aqui a recursividade ir� gerar um looping infinito
	private Long projeto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDatainicial() {
		return datainicial;
	}

	public void setDatainicial(String datainicial) {
		this.datainicial = datainicial;
	}

	public String getDatafinal() {
		return datafinal;
	}

	public void setDatafinal(String datafinal) {
		this.datafinal = datafinal;
	}

	public Long getProjeto() {
		return projeto;
	}

	public void setProjeto(Long projeto) {
		this.projeto = projeto;
	}
	
	

}
