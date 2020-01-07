package to;

public class TipoExame {

	private int id_tipoexame;
	private String nome_exame;

	public TipoExame() {

	}

	public TipoExame(int id_tipoexame, String nome_exame) {
		this.id_tipoexame = id_tipoexame;
		this.nome_exame = nome_exame;

	}

	public int getId_tipoexame() {
		return id_tipoexame;
	}

	public void setId_tipoexame(int id_tipoexame) {
		this.id_tipoexame = id_tipoexame;
	}

	public String getNome_exame() {
		return nome_exame;
	}

	public void setNome_exame(String nome_exame) {
		this.nome_exame = nome_exame;
	}

}
