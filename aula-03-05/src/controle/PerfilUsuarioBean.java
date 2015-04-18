package controle;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PerfilUsuarioBean {
	
	private String sexo;
	private Boolean receberNovidades;
	private String[] linguagensFavoritas;
	
	public String[] getLinguagensFavoritas() {
		return linguagensFavoritas;
	}

	public void setLinguagensFavoritas(String[] linguagensFavoritas) {
		this.linguagensFavoritas = linguagensFavoritas;
	}

	public String enviar() {
		return "Confimacao";
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Boolean getReceberNovidades() {
		return receberNovidades;
	}

	public void setReceberNovidades(Boolean receberNovidades) {
		this.receberNovidades = receberNovidades;
	}
}
