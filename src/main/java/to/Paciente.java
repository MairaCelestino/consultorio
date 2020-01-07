package to;

public class Paciente implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int re_pac;
	private String nome_pac;
	private String sexo_pac;
	private String dataNasc_pac;

	public Paciente() {
	}

	public Paciente(int re_pac, String nome_pac, String sexo_pac, String dataNasc_pac) {
		this.re_pac = re_pac;
		this.nome_pac = nome_pac;
		this.dataNasc_pac = dataNasc_pac;
		this.sexo_pac = sexo_pac;
	}

	public int getRe_pac() {
		return re_pac;
	}

	public void setRe_pac(String re_pac) {
		try {
			this.re_pac = (Integer.parseInt(re_pac));
		} catch (Exception e) {
			// TODO: handle exception

		}

	}

	public String getNome_pac() {
		return nome_pac;
	}

	public void setNome_pac(String nome_pac) {
		this.nome_pac = nome_pac;
	}

	public String getSexo_pac() {
		return sexo_pac;
	}

	public void setSexo_pac(String sexo_pac) {
		this.sexo_pac = sexo_pac;
	}

	public String getDataNasc_pac() {
		return dataNasc_pac;
	}

	public void setDataNasc_pac(String dataNasc_pac) {
		this.dataNasc_pac = dataNasc_pac;
	}

}
