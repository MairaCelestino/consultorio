package to;

public class Exame {

	private int id_exame;
	private Paciente re_paciente;
	private TipoExame id_tipoexame;
	private int ano_exame;
	private int resul_exame;

	public Exame() {

	}

	public Exame(int id_exame, TipoExame id_tipoexame, Paciente re_paciente, int ano_exame, int resul_exame) {
		this.id_exame = id_exame;
		this.re_paciente = re_paciente;
		this.id_tipoexame = id_tipoexame;
		this.ano_exame = ano_exame;
		this.resul_exame = resul_exame;

	}

	public int getId_exame() {
		return id_exame;
	}

	public void setId_exame(String id_exame) {
		try {
			this.id_exame = (Integer.parseInt(id_exame));
		} catch (Exception e) {
		}
	}

	public Paciente getRe_paciente() {
		return re_paciente;
	}

	public void setRe_paciente(Paciente re_paciente) {
		this.re_paciente = re_paciente;
	}

	public TipoExame getId_tipoexame() {
		return id_tipoexame;
	}

	public void setId_tipoexame(TipoExame id_tipoexame) {
		this.id_tipoexame = id_tipoexame;
	}

	public int getAno_exame() {
		return ano_exame;
	}

	public void setAno_exame(String ano_exame) {
		try {
			this.ano_exame = (Integer.parseInt(ano_exame));
		} catch (Exception e) {
		}
	}

	public int getResul_exame() {
		return resul_exame;
	}

	public void setResul_exame(String resul_exame) {
		try {
			this.resul_exame = (Integer.parseInt(resul_exame));
		} catch (Exception e) {
		}
	}

}
