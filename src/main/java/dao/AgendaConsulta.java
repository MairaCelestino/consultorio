package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import to.Consulta;
import util.ConnectionAgendaFactory;

public class AgendaConsulta {

	public void salvar(Consulta consulta) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;

		System.out.println("Entrou!!");
		if (consulta == null)
			throw new AgendaException("O valor passado não pode ser nulo!!");
		try {
			conn = ConnectionAgendaFactory.getConnection();
			String SQL = "INSERT INTO consulta(crm_medic,re_pacient,data_consulta,horario_consulta)"
					+ "VALUES(?, ?, ?, ?)";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, consulta.getCrm_medico().getCrm_med());
			ps.setInt(2, consulta.getRe_paciente().getRe_pac());
			ps.setString(3, consulta.getData_consulta());
			ps.setString(4, consulta.getHorario_consulta());

			ps.executeUpdate();
			System.out.println("Ok!!");
			System.out.println("Saiu!!!!!");

		} catch (SQLException sqle) {
			throw new AgendaException("Erro ao inserir dados" + sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps);
		}

	}

	public void atualizar(Consulta consulta) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;

		System.out.println("Entrou Atualizar!!");
		if (consulta == null)
			throw new AgendaException("O Valor não pode ser nulo");
		try {
			conn = ConnectionAgendaFactory.getConnection();
			String SQL = "UPDATE consulta SET crm_medic=?," + "re_pacient=?," + "data_consulta=?,"
					+ "horario_consulta=?" + "where id_consulta=?";
			System.out.println("ENTROU DENDO DO METODO ATUALIZAR!!!");
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, consulta.getCrm_medico().getCrm_med());
			ps.setInt(2, consulta.getRe_paciente().getRe_pac());
			ps.setString(3, consulta.getData_consulta());
			ps.setString(4, consulta.getHorario_consulta());
			ps.setInt(5, consulta.getId_consulta());
			ps.executeUpdate();

			System.out.println("Saiu Atualizar!!");

		} catch (SQLException sqle) {
			throw new AgendaException("Erro ao atualizar dados: " + sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps);
		}
	}

	public void excluir(Consulta consulta) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		System.out.println("Entrou Excluir");

		if (consulta == null)
			throw new AgendaException("O valor não pode ser nulo");
		try {
			conn = ConnectionAgendaFactory.getConnection();
			ps = conn.prepareStatement("delete from consulta where id_consulta=?");
			ps.setInt(1, consulta.getId_consulta());
			ps.executeUpdate();
			System.out.println("Registro" + consulta.getId_consulta());
		} catch (SQLException sqle) {
			throw new AgendaException("Erro ao excluir dados: " + sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps);
		}

	}

	public List<Consulta> todasConsultas() throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();
			ps = conn.prepareStatement(
					"select id_consulta, crm_medic, re_pacient, data_consulta, horario_consulta from consulta");

			// ps = conn.prepareStatement("select p.nome_pac, m.nome_med, c.data_consulta,
			// c.horario_consulta" +
			// "from consulta c inner join medico m on m.crm_med=c.crm_medico inner join
			// paciente p on p.re_pac=c.re_paciente");
			rs = ps.executeQuery();
			List<Consulta> list = new ArrayList<Consulta>();

			while (rs.next()) {
				int id_consulta = rs.getInt(1);
				String data_consulta = rs.getString(4);
				String horario_consulta = rs.getString(5);

				AgendaMedico agendaMedico = new AgendaMedico();
				AgendaPaciente agendaPaciente = new AgendaPaciente();

				list.add(new Consulta(id_consulta, agendaMedico.procuraMedicoId(rs.getInt(2)),
						agendaPaciente.procuraPacienteId(rs.getInt(3)), data_consulta, horario_consulta));
			}
			return list;
		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);
		}
	}

	public Consulta procuraConsultaId(int id_consulta) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();
			ps = conn.prepareStatement("select * from consulta where id_consulta=?");
			ps.setInt(1, id_consulta);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new AgendaException("Não foi encontrado nenhum " + "registro com o Registro: " + id_consulta);
			}

			String data_consulta = rs.getString(4);
			String horario_consulta = rs.getString(5);

			AgendaMedico agendaMedico = new AgendaMedico();
			AgendaPaciente agendaPaciente = new AgendaPaciente();

			return new Consulta(id_consulta, agendaMedico.procuraMedicoId(rs.getInt(2)),
					agendaPaciente.procuraPacienteId(rs.getInt(3)), data_consulta, horario_consulta);

		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);

		}
	}

	public List<Consulta> procuraConsulta(String nome) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();

			if ((nome == null) || (nome == ""))
				ps = conn.prepareStatement("select * from consulta");
			else
				ps = conn.prepareStatement(
						"select * from consulta c inner join medico m where m.nome_med=?" + nome + "'");
			rs = ps.executeQuery();
			List<Consulta> list = new ArrayList<Consulta>();
			while (rs.next()) {
				// int crm_medico = 0;
				// int re_paciente = 0;
				// int id_consulta = 0;

				int id_consulta = rs.getInt(1);
				String data_consulta = rs.getString(4);
				String horario_consulta = rs.getString(5);

				AgendaMedico agendaMedico = new AgendaMedico();
				AgendaPaciente agendaPaciente = new AgendaPaciente();

				list.add(new Consulta(id_consulta, agendaMedico.procuraMedicoId(rs.getInt(1)),
						agendaPaciente.procuraPacienteId(rs.getInt(2)), data_consulta, horario_consulta));
			}
			return list;
		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);
		}
	}
}
