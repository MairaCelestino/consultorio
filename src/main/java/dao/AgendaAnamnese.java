package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import to.Anamnese;
import to.Paciente;
import util.ConnectionAgendaFactory;

public class AgendaAnamnese {

	public void salvar(Anamnese anamnese) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;

		System.out.println("Entrou!!");
		if (anamnese == null)
			throw new AgendaException("O valor passado não pode ser nulo!!");
		try {
			conn = ConnectionAgendaFactory.getConnection();
			String SQL = "INSERT INTO anamnese (re_paci,nome_pac,datanasc_pac,idade,filho,estado_civil,"
					+ "religiao,internacao,patologia,cirurgia,medicacao,"
					+ "alergia,vicio,vacina,infarto,cancer,avc,diabete,has,anotacao)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(SQL);
			ps.setInt(1, anamnese.getPaciente().getRe_pac());
			ps.setString(2, anamnese.getPaciente().getNome_pac());
			ps.setString(3, anamnese.getPaciente().getDataNasc_pac());
			ps.setInt(4, anamnese.getIdade());
			ps.setString(5, anamnese.getFilho());
			ps.setString(6, anamnese.getEstado_civil());
			ps.setString(7, anamnese.getReligiao());
			ps.setString(8, anamnese.getInternacao());
			ps.setString(9, anamnese.getPatologia());
			ps.setString(10, anamnese.getCirurgia());
			ps.setString(11, anamnese.getMedicacao());
			ps.setString(12, anamnese.getAlergia());
			ps.setString(13, anamnese.getVicio());
			ps.setString(14, anamnese.getVacina());
			ps.setString(15, anamnese.getInfarto());
			ps.setString(16, anamnese.getCancer());
			ps.setString(17, anamnese.getAvc());
			ps.setString(18, anamnese.getDiabete());
			ps.setString(19, anamnese.getHas());
			ps.setString(20, anamnese.getAnotacao());

			ps.executeUpdate();
			System.out.println("Ok!!");

		} catch (SQLException sqle) {
			throw new AgendaException("Erro ao inserir dados" + sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps);
		}

	}

	public void atualizar(Anamnese anamnese) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;

		System.out.println("Entrou!!");
		if (anamnese == null)
			throw new AgendaException("O Valor não pode ser nulo");
		try {
			conn = ConnectionAgendaFactory.getConnection();
			String SQL = "UPDATE anamnese SET re_paci=?," + "nome_pac=?," + "datanasc_pac=?," + "idade=?," + "filho=?,"
					+ "estado_civil=?," + "religiao=?," + "internacao=?," + "patologia=?," + "cirurgia=?,"
					+ "medicacao=?," + "alergia=?," + "vicio=,?" + "vacina=?," + "infarto=?," + "cancer=?," + "avc=?,"
					+ "diabete=?," + "has=?," + "anotacao=?" + "where id_anamnese=?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, anamnese.getPaciente().getRe_pac());
			ps.setString(2, anamnese.getPaciente().getNome_pac());
			ps.setString(3, anamnese.getPaciente().getDataNasc_pac());
			ps.setInt(4, anamnese.getIdade());
			ps.setString(5, anamnese.getFilho());
			ps.setString(6, anamnese.getEstado_civil());
			ps.setString(7, anamnese.getReligiao());
			ps.setString(8, anamnese.getInternacao());
			ps.setString(9, anamnese.getPatologia());
			ps.setString(10, anamnese.getCirurgia());
			ps.setString(11, anamnese.getMedicacao());
			ps.setString(12, anamnese.getAlergia());
			ps.setString(13, anamnese.getVicio());
			ps.setString(14, anamnese.getVacina());
			ps.setString(15, anamnese.getInfarto());
			ps.setString(16, anamnese.getCancer());
			ps.setString(17, anamnese.getAvc());
			ps.setString(18, anamnese.getDiabete());
			ps.setString(19, anamnese.getHas());
			ps.setString(20, anamnese.getAnotacao());
			ps.setInt(21, anamnese.getId_anamnese());

			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new AgendaException("Erro ao atualizar dados: " + sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps);
		}
	}

	public void excluir(Anamnese anamnese) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		System.out.println("Entrou Excluir");

		if (anamnese == null)
			throw new AgendaException("O valor não pode ser nulo");
		try {
			conn = ConnectionAgendaFactory.getConnection();
			ps = conn.prepareStatement("delete from anamnese where id_anamnese=?");
			ps.setInt(1, anamnese.getId_anamnese());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new AgendaException("Erro ao excluir dados: " + sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps);
		}

	}

	public List<Anamnese> todosAnamnese() throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();
			ps = conn.prepareStatement("select * from anamnese");
			rs = ps.executeQuery();
			List<Anamnese> list = new ArrayList<Anamnese>();
			while (rs.next()) {
				int id_anamnese = 0;
				int idade = 0;
				int re_paci = 0;

				id_anamnese = rs.getInt(1);
				re_paci = rs.getInt(3);
				idade = rs.getInt(5);
				String filho = rs.getString(6);
				String estado_civil = rs.getString(7);
				String religiao = rs.getString(8);
				String internacao = rs.getString(9);
				String patologia = rs.getString(10);
				String cirurgia = rs.getString(11);
				String medicacao = rs.getString(12);
				String alergia = rs.getString(13);
				String vicio = rs.getString(14);
				String vacina = rs.getString(15);
				String infarto = rs.getString(16);
				String cancer = rs.getString(17);
				String avc = rs.getString(18);
				String diabete = rs.getString(19);
				String has = rs.getString(20);
				String anotacao = rs.getString(21);

				Paciente paciente = new Paciente();
				AgendaPaciente agendaPaciente = new AgendaPaciente();
				paciente = agendaPaciente.procuraPacienteId(re_paci);

				list.add(new Anamnese(id_anamnese, paciente, idade, filho, estado_civil, religiao, internacao,
						patologia, cirurgia, medicacao, alergia, vicio, vacina, infarto, cancer, avc, diabete, has,
						anotacao));
			}
			return list;
		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);
		}
	}

	public Anamnese procuraAnamneseId(int re_paci) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();
			ps = conn.prepareStatement("select * from anamnese where anamnese=?");
			ps.setInt(1, re_paci);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new AgendaException("Não foi encontrado nenhum " + "registro com o Registro: " + re_paci);
			}
			int id_anamnese = 0;
			int idade = 0;

			re_paci = rs.getInt(3);
			idade = rs.getInt(5);
			String filho = rs.getString(6);
			String estado_civil = rs.getString(7);
			String religiao = rs.getString(8);
			String internacao = rs.getString(9);
			String patologia = rs.getString(10);
			String cirurgia = rs.getString(11);
			String medicacao = rs.getString(12);
			String alergia = rs.getString(13);
			String vicio = rs.getString(14);
			String vacina = rs.getString(15);
			String infarto = rs.getString(16);
			String cancer = rs.getString(17);
			String avc = rs.getString(18);
			String diabete = rs.getString(19);
			String has = rs.getString(20);
			String anotacao = rs.getString(21);

			Paciente paciente = new Paciente();
			AgendaPaciente agendaPaciente = new AgendaPaciente();
			paciente = agendaPaciente.procuraPacienteId(re_paci);

			return new Anamnese(id_anamnese, paciente, idade, filho, estado_civil, religiao, internacao, patologia,
					cirurgia, medicacao, alergia, vicio, vacina, infarto, cancer, avc, diabete, has, anotacao);

		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);

		}
	}

	public List<Anamnese> procuraAnamnese(String nome) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();

			// if ((nome.equalsIgnoreCase("")) || (nome.isEmpty()))
			if ((nome == null) || (nome == ""))
				ps = conn.prepareStatement("select * from anamnese");
			else
				ps = conn.prepareStatement("select * from anamnese where nome_pac='" + nome + "'");
			rs = ps.executeQuery();
			List<Anamnese> list = new ArrayList<Anamnese>();
			while (rs.next()) {

				int id_anamnese = 0;
				int idade = 0;
				int re_paci = 0;

				id_anamnese = rs.getInt(1);
				re_paci = rs.getInt(2);
				idade = rs.getInt(5);
				String filho = rs.getString(6);
				String estado_civil = rs.getString(7);
				String religiao = rs.getString(8);
				String internacao = rs.getString(9);
				String patologia = rs.getString(10);
				String cirurgia = rs.getString(11);
				String medicacao = rs.getString(12);
				String alergia = rs.getString(13);
				String vicio = rs.getString(14);
				String vacina = rs.getString(15);
				String infarto = rs.getString(16);
				String cancer = rs.getString(17);
				String avc = rs.getString(18);
				String diabete = rs.getString(19);
				String has = rs.getString(20);
				String anotacao = rs.getString(21);

				Paciente paciente = new Paciente();
				AgendaPaciente agendaPaciente = new AgendaPaciente();
				paciente = agendaPaciente.procuraPacienteId(re_paci);

				list.add(new Anamnese(id_anamnese, paciente, idade, filho, estado_civil, religiao, internacao,
						patologia, cirurgia, medicacao, alergia, vicio, vacina, infarto, cancer, avc, diabete, has,
						anotacao));
			}
			return list;
		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);
		}
	}
}