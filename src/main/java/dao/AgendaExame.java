package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import to.Exame;
import to.TipoExame;
import util.ConnectionAgendaFactory;

public class AgendaExame {
	public void salvar(Exame exame) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;

		System.out.println("Entrou!!");
		if (exame == null)
			throw new AgendaException("O valor passado não pode ser nulo!!");
		try {
			conn = ConnectionAgendaFactory.getConnection();
			String SQL = "INSERT INTO exames(id_tipoexame,id_paci,resultado,ano)" + "values(?, ?, ?, ?)";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, exame.getId_tipoexame().getId_tipoexame());
			ps.setInt(2, exame.getRe_paciente().getRe_pac());
			ps.setInt(3, exame.getResul_exame());
			ps.setInt(4, exame.getAno_exame());

			ps.executeUpdate();
			System.out.println("Saiuu!!");

		} catch (SQLException sqle) {
			throw new AgendaException("Erro ao inserir dados" + sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps);
		}
	}

	public List<TipoExame> todosExames() throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();
			ps = conn.prepareStatement("select * from tipo_exame");
			rs = ps.executeQuery();
			List<TipoExame> list = new ArrayList<TipoExame>();
			while (rs.next()) {
				int id_tipoexame = 0;

				id_tipoexame = rs.getInt(1);// Integer.toString(rs.getInt(0));
				String nome_exame = rs.getString(2);

				list.add(new TipoExame(id_tipoexame, nome_exame));
			}
			return list;
		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);
		}
	}

	public TipoExame procuraTipoExameId(int id_tipoexame) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();
			ps = conn.prepareStatement("select * from tipo_exame where id_tipoexame=?");
			ps.setInt(1, id_tipoexame);
			rs = ps.executeQuery();
			if (!rs.next()) {
				throw new AgendaException("Não foi encontrado nenhum " + "registro com o Registro: " + id_tipoexame);
			}

			String nome_exame = rs.getString(2);

			return new TipoExame(id_tipoexame, nome_exame);

		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);

		}
	}

	public List<Exame> procuraExame(String nome) throws AgendaException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = ConnectionAgendaFactory.getConnection();

			if ((nome == null) || (nome == ""))
				ps = conn.prepareStatement("select distinct id_paci from exames");
			// ps = conn.prepareStatement("select * from exames group by id_paci");
			else
				ps = conn.prepareStatement("select * from paciente where nome_pac like '%?''" + nome + "'");
			rs = ps.executeQuery();
			List<Exame> list = new ArrayList<Exame>();
			while (rs.next()) {
				int ano_exame = 0;
				int resul_exame = 0;
				int id_exame = 0;

				id_exame = rs.getInt(1);
				resul_exame = rs.getInt(4);
				ano_exame = rs.getInt(5);

				AgendaPaciente agendaPaciente = new AgendaPaciente();
				AgendaExame agendaExame = new AgendaExame();

				list.add(new Exame(id_exame, agendaExame.procuraTipoExameId(rs.getInt(2)),
						agendaPaciente.procuraPacienteId(rs.getInt(3)), resul_exame, ano_exame));
			}
			return list;
		} catch (SQLException sqle) {
			throw new AgendaException(sqle);
		} finally {
			ConnectionAgendaFactory.closeConnection(conn, ps, rs);
		}
	}

}
