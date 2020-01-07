package web;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AgendaExame;
import dao.AgendaException;
import dao.AgendaPaciente;
import to.Exame;

public class AgendaExameServlet extends javax.servlet.http.HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {

		String cmd = request.getParameter("cmd");
		String nome = request.getParameter("nome");

		System.out.println(cmd);

		if (cmd == null)
			cmd = "principal";

		AgendaExame dao;
		Exame exame = new Exame();
		if (cmd != null || !cmd.equalsIgnoreCase("principal")) {

			AgendaPaciente agendaPaciente = new AgendaPaciente();
			// AgendaExame agendaExame = new AgendaExame();

			exame.setId_exame(request.getParameter("id_exame"));

			try {
				exame.setRe_paciente(
						agendaPaciente.procuraPacienteId(Integer.parseInt(request.getParameter("tabPaciente"))));

			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (AgendaException e) {
				e.printStackTrace();
			}

		}

		try {
			dao = new AgendaExame();
			RequestDispatcher rd = null;
			if (cmd.equalsIgnoreCase("listar")) {

				List<Exame> exameList = null;
				request.setAttribute("exameList", exameList);
				rd = request.getRequestDispatcher("/mostrarExamesCads.jsp");

			} else if (cmd.equalsIgnoreCase("exame")) {
				List<Exame> exameList = dao.procuraExame(nome);
				request.setAttribute("exameList", exameList);
				rd = request.getRequestDispatcher("/mostrarExamesCads.jsp");
			}

			else if (cmd.equalsIgnoreCase("exame")) {
				rd = request.getRequestDispatcher("/mostrarExamesCads.jsp");
			}

			else if (cmd.equalsIgnoreCase("addexa")) {
				System.out.println("Entra no adicionar!!");
				System.out.println("ID EXAME: " + exame.getId_exame());
				System.out.println("ID TIPO EXAME: " + exame.getId_tipoexame());
				System.out.println("PACIENTE:" + exame.getRe_paciente().getNome_pac());
				System.out.println("RESULTADO:" + exame.getResul_exame());
				System.out.println("ANO EXAME: " + exame.getId_exame());
				AgendaExame agendaExame = new AgendaExame();
				int i = 0;
				while (request.getParameter("id_tipoexame" + i) != null) {
					try {
						exame.setId_tipoexame(agendaExame
								.procuraTipoExameId(Integer.parseInt(request.getParameter("id_tipoexame" + i))));
						exame.setAno_exame(request.getParameter("ano_exame"));
						exame.setResul_exame(request.getParameter("resultado" + i));
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("Exame: " + exame.getResul_exame());
					dao.salvar(exame);
					i++;
				}

				rd = request.getRequestDispatcher("/cadExame.jsp");

			} else if (cmd.equalsIgnoreCase("principal")) {
				rd = request.getRequestDispatcher("/index.jsp");
			}
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new ServletException(e);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
