package to;

public class Medico implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int crm_med;
	private String nome_med;
	private String especialidade;

	public Medico() {

	}

	public Medico(int crm_med, String nome_med, String especialidade) {
		this.crm_med = crm_med;
		this.nome_med = nome_med;
		this.especialidade = especialidade;

	}

	public int getCrm_med() {
		return crm_med;
	}

	/*
	 * public void setRe_pac(String re_pac) { try { this.re_pac =
	 * (Integer.parseInt(re_pac)); } catch (Exception e) { // TODO: handle
	 * exception
	 * 
	 * }
	 * 
	 * }
	 */

	public void setCrm_med(String crm_med) {
		try {
			this.crm_med = (Integer.parseInt(crm_med));
		} catch (Exception e) {

		}
	}

	public String getNome_med() {
		return nome_med;
	}

	public void setNome_med(String nome_med) {
		this.nome_med = nome_med;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

}
