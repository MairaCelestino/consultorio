package to;

public class Consulta {

	private int id_consulta;
	private String horario_consulta;
	private String data_consulta;
	private Paciente re_paciente;
	private Medico crm_medico;

	public Consulta() {

	}

	public Consulta(int id_consulta, Medico crm_medico, Paciente re_paciente, String data_consulta,
			String horario_consulta) {
		this.id_consulta = id_consulta;
		this.crm_medico = crm_medico;
		this.re_paciente = re_paciente;
		this.data_consulta = data_consulta;
		this.horario_consulta = horario_consulta;

	}

	public int getId_consulta() {
		return id_consulta;
	}

	public void setId_consulta(String id_consulta) {
		try {
			this.id_consulta = (Integer.parseInt(id_consulta));
		} catch (Exception e) {

		}
	}

	public Medico getCrm_medico() {
		return crm_medico;
	}

	public void setCrm_medico(Medico crm_medico) {
		this.crm_medico = crm_medico;
	}

	public Paciente getRe_paciente() {
		return re_paciente;
	}

	public void setRe_paciente(Paciente re_paciente) {
		this.re_paciente = re_paciente;
	}

	public String getHorario_consulta() {
		return horario_consulta;
	}

	public void setHorario_consulta(String horario_consulta) {
		this.horario_consulta = horario_consulta;
	}

	public String getData_consulta() {
		return data_consulta;
	}

	public void setData_consulta(String data_consulta) {
		this.data_consulta = data_consulta;
	}

	/*
	 * public int getRe_paciente() { return re_paciente; }
	 * 
	 * public void setRe_paciente(String re_paciente) { try { this.re_paciente =
	 * (Integer.parseInt(re_paciente)); } catch (Exception e) {
	 * 
	 * } }
	 * 
	 * public int getCrm_medico() { return crm_medico; }
	 * 
	 * public void setCrm_medico(String crm_medico) { try { this.crm_medico =
	 * (Integer.parseInt(crm_medico)); } catch (Exception e) {
	 * 
	 * } }
	 */
}
