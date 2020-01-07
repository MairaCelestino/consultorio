package to;

public class Anamnese {

	private int id_anamnese;
	private Paciente paciente;
	private int idade;
	private String filho;
	private String estado_civil;
	private String religiao;
	private String internacao;
	private String patologia;
	private String cirurgia;
	private String medicacao;
	private String alergia;
	private String vicio;
	private String vacina;
	private String infarto;
	private String cancer;
	private String avc;
	private String diabete;
	private String has;
	private String anotacao;

	public Anamnese() {

	}

	public Anamnese(int id_anamnese, Paciente paciente, int idade, String filho, String estado_civil, String religiao,
			String internacao, String patologia, String cirurgia, String medicacao, String alergia, String vicio,
			String vacina, String infarto, String cancer, String avc, String diabete, String has, String anotacao) {
		super();
		this.id_anamnese = id_anamnese;
		this.paciente = paciente;
		this.idade = idade;
		this.filho = filho;
		this.estado_civil = estado_civil;
		this.religiao = religiao;
		this.internacao = internacao;
		this.patologia = patologia;
		this.cirurgia = cirurgia;
		this.medicacao = medicacao;
		this.alergia = alergia;
		this.vicio = vicio;
		this.vacina = vacina;
		this.infarto = infarto;
		this.cancer = cancer;
		this.avc = avc;
		this.diabete = diabete;
		this.has = has;
		this.anotacao = anotacao;
	}

	public int getId_anamnese() {
		return id_anamnese;
	}

	public void setId_anamnese(int id_anamnese) {
		this.id_anamnese = id_anamnese;
		// = (Integer.parseInt(id_anamnese));
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getFilho() {
		return filho;
	}

	public void setFilho(String filho) {
		this.filho = filho;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getReligiao() {
		return religiao;
	}

	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}

	public String getInternacao() {
		return internacao;
	}

	public void setInternacao(String internacao) {
		this.internacao = internacao;
	}

	public String getPatologia() {
		return patologia;
	}

	public void setPatologia(String patologia) {
		this.patologia = patologia;
	}

	public String getCirurgia() {
		return cirurgia;
	}

	public void setCirurgia(String cirurgia) {
		this.cirurgia = cirurgia;
	}

	public String getMedicacao() {
		return medicacao;
	}

	public void setMedicacao(String medicacao) {
		this.medicacao = medicacao;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getVicio() {
		return vicio;
	}

	public void setVicio(String vicio) {
		this.vicio = vicio;
	}

	public String getVacina() {
		return vacina;
	}

	public void setVacina(String vacina) {
		this.vacina = vacina;
	}

	public String getInfarto() {
		return infarto;
	}

	public void setInfarto(String infarto) {
		this.infarto = infarto;
	}

	public String getCancer() {
		return cancer;
	}

	public void setCancer(String cancer) {
		this.cancer = cancer;
	}

	public String getAvc() {
		return avc;
	}

	public void setAvc(String avc) {
		this.avc = avc;
	}

	public String getDiabete() {
		return diabete;
	}

	public void setDiabete(String diabete) {
		this.diabete = diabete;
	}

	public String getHas() {
		return has;
	}

	public void setHas(String has) {
		this.has = has;
	}

	public String getAnotacao() {
		return anotacao;
	}

	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}

}
