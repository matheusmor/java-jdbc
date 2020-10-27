package modelo;

public class Aluno {
	private String nome;
	private String matricula;
	private String email;
	private String telefone;
	
	public Aluno(String nome,String matricula, String email, String telefone) {
		this.nome=nome;
		this.matricula=matricula;
		this.email=email;
		this.telefone=telefone;
	}
	
	
	


	@Override
	public String toString() {
		return  nome + ", matricula=" + matricula + ", email=" + email + ", telefone=" + telefone + "]";
	}





	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
