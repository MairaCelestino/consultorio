package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import to.Medico;
import util.ConnectionAgendaFactory;

public class AgendaMedico {

	public void salvar(Medico medico) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;

		System.out.println("Entrou!!");
		if (medico == null)
			throw new AgendaException("O valor passado não pode ser nulo!!");
		try {
			conn = ConnectionAgendaFactory.getConnection();
			String SQL = "INSERT INTO medico (crm_med,nome_med,especialidade)" + "values(?, ?, ?)";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, medico.getCrm_med());
			ps.setString(2, medico.getNome_med());
			ps.setString(3, medico.getEspecialidade());

			ps.executeUpdate();
			System.out.println("Ok!!");

		} catch (SQLException sqle) {
			throw new AgendaException("Erro ao inserir dados" + sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps);
		}

	}

	public void atualizar(Medico medico) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;

		System.out.println("Entrou!!");
		if (medico == null)
			throw new AgendaException("O Valor não pode ser nulo");
		try {
			conn = ConnectionAgendaFactory.getConnection();
			String SQL = "UPDATE medico SET nome_med=?, " + "especialidade=?" + "where crm_med=?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, medico.getNome_med());
			ps.setString(2, medico.getEspecialidade());
			ps.setInt(3, medico.getCrm_med());
			ps.executeUpdate();

		} catch (SQLException sqle) {
			throw new AgendaException("Erro ao atualizar dados: " + sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps);
		}
	}

	public void excluir(Medico medico) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		System.out.println("Entrou Excluir");

		if (medico == null)
			throw new AgendaException("O valor não pode ser nulo");
		try {
			conn = ConnectionAgendaFactory.getConnection();
			ps = conn.prepareStatement("delete from medico where crm_med=?");
			ps.setInt(1, medico.getCrm_med());
			ps.executeUpdate();
			System.out.println("Registro" + medico.getCrm_med());
		} catch (SQLException sqle) {
			throw new AgendaException("Erro ao excluir dados: " + sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps);
		}

	}

	public List<Medico> todosMedicos() throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();
			ps = conn.prepareStatement("select * from medico");
			rs = ps.executeQuery();
			List<Medico> list = new ArrayList<Medico>();
			while (rs.next()) {
				int crm_med = 0;

				crm_med = rs.getInt(1);// Integer.toString(rs.getInt(0));
				String nome_med = rs.getString(2);
				String especialidade = rs.getString(3);

				list.add(new Medico(crm_med, nome_med, especialidade));
			}
			return list;
		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);
		}
	}

	public Medico procuraMedicoId(int crm_med) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();
			ps = conn.prepareStatement("select * from medico where crm_med=?");
			ps.setInt(1, crm_med);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new AgendaException("Não foi encontrado nenhum " + "registro com o Registro: " + crm_med);
			}

			String nome_med = rs.getString(2);
			String especialidade = rs.getString(3);

			return new Medico(crm_med, nome_med, especialidade);

		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);

		}
	}

	public List<Medico> procuraMedico(String nome) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();

			if ((nome == null) || (nome == ""))
				ps = conn.prepareStatement("select * from medico");
			else
				ps = conn.prepareStatement("select * from medico where nome_med='" + nome + "'");
			rs = ps.executeQuery();
			List<Medico> list = new ArrayList<Medico>();
			while (rs.next()) {
				int crm_med = 0;

				crm_med = rs.getInt(1); // Integer.toString(rs.getInt(0));
				String nome_med = rs.getString(2);
				String especialidade = rs.getString(3);

				list.add(new Medico(crm_med, nome_med, especialidade));
			}
			return list;
		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);
		}
	}
}
