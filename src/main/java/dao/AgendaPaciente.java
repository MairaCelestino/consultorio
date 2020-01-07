package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import to.Paciente;
import util.ConnectionAgendaFactory;

//import pacote.util.ConverterDate;

public class AgendaPaciente implements InterfacePacienteAgenda {

	public void salvar(Paciente paciente) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;

		System.out.println("Entrou!!");
		if (paciente == null)
			throw new AgendaException("O valor passado nao pode ser nulo!!");
		try {
			conn = ConnectionAgendaFactory.getConnection();
			String SQL = "INSERT INTO paciente(nome_pac,sexo_pac,dataNasc_pac)" + "values(?, ?, ?)";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, paciente.getNome_pac());
			ps.setString(2, paciente.getSexo_pac());
			ps.setString(3, paciente.getDataNasc_pac());

			ps.executeUpdate();
			System.out.println("Ok!!");

		} catch (SQLException sqle) {
			throw new AgendaException("Erro ao inserir dados" + sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps);
		}

	}

	public void atualizar(Paciente paciente) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;

		System.out.println("Entrou!!");
		if (paciente == null)
			throw new AgendaException("O Valor n�o pode ser nulo");
		try {
			conn = ConnectionAgendaFactory.getConnection();
			String SQL = "UPDATE paciente SET nome_pac=?, " + "sexo_pac=?," + "dataNasc_pac=?" + "where re_pac=?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, paciente.getNome_pac());
			ps.setString(2, paciente.getSexo_pac());
			ps.setString(3, paciente.getDataNasc_pac());
			ps.setInt(4, paciente.getRe_pac());
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new AgendaException("Erro ao atualizar dados: " + sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps);
		}
	}

	public void excluir(Paciente paciente) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		System.out.println("Entrou Excluir");

		if (paciente == null)
			throw new AgendaException("O valor n�o pode ser nulo");
		try {
			conn = ConnectionAgendaFactory.getConnection();
			ps = conn.prepareStatement("delete from paciente where re_pac=?");
			ps.setInt(1, paciente.getRe_pac());
			ps.executeUpdate();
			System.out.println("Registro" + paciente.getRe_pac());
		} catch (SQLException sqle) {
			throw new AgendaException("Erro ao excluir dados: " + sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps);
		}

	}

	public List<Paciente> todosPacientes() throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();
			ps = conn.prepareStatement("select * from paciente");
			rs = ps.executeQuery();
			List<Paciente> list = new ArrayList<Paciente>();
			while (rs.next()) {
				int re_pac = 0;

				re_pac = rs.getInt(1);// Integer.toString(rs.getInt(0));
				String nome_pac = rs.getString(2);
				String sexo_pac = rs.getString(3);
				String dataNasc_pac = rs.getString(4);

				list.add(new Paciente(re_pac, nome_pac, sexo_pac, dataNasc_pac));
			}
			return list;
		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);
		}
	}

	public Paciente procuraPacienteId(int re_pac) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();
			ps = conn.prepareStatement("select * from paciente where re_pac=?");
			ps.setInt(1, re_pac);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new AgendaException("N�o foi encontrado nenhum " + "registro com o Registro: " + re_pac);
			}

			String nome_pac = rs.getString(2);
			String sexo_pac = rs.getString(3);
			String dataNasc_pac = rs.getString(4);

			return new Paciente(re_pac, nome_pac, sexo_pac, dataNasc_pac);

		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);

		}
	}

	public List<Paciente> procuraPaciente(String nome) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();

			if ((nome == null) || (nome == ""))
				ps = conn.prepareStatement("select * from paciente");
			else
				ps = conn.prepareStatement("select * from paciente where nome_pac like '%?''" + nome + "'");
			rs = ps.executeQuery();
			List<Paciente> list = new ArrayList<Paciente>();
			while (rs.next()) {
				int re_pac = 0;

				re_pac = rs.getInt(1); // Integer.toString(rs.getInt(0));
				String nome_pac = rs.getString(2);
				String sexo_pac = rs.getString(3);
				String dataNasc_pac = rs.getString(4);

				list.add(new Paciente(re_pac, nome_pac, sexo_pac, dataNasc_pac));
			}
			return list;
		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);
		}
	}
}