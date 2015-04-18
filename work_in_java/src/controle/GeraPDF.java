package controle;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class GeraPDF {
	public String lingua;

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
	
	public void mostraPagamentoPDF() {
		System.out.println("Gera PDF do pagamento na lingua: " + this.getLingua());
	}
}
