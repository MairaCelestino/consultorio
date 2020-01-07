package web;

import java.io.IOException;
//import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AgendaConsulta;
import dao.AgendaException;
import dao.AgendaMedico;
import dao.AgendaPaciente;
import to.Consulta;
import to.Medico;
import to.Paciente;

public class AgendaConsultaServlet extends javax.servlet.http.HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {

		String nome = request.getParameter("nome_med");
		String cmd = request.getParameter("cmd");
		// String re_pac = request.getParameter("re_pac");

		System.out.println(cmd);

		if (cmd == null)
			cmd = "principal";

		AgendaConsulta dao;
		Consulta consulta = new Consulta();
		if (cmd != null || !cmd.equalsIgnoreCase("principal")) {
			System.out.println("registro : " + request.getParameter("tabMedico"));
			System.out.println("registro : " + request.getParameter("tabPaciente"));
			// cria as instancias que vao trazer nosso medico e paciente
			AgendaMedico agendaMedico = new AgendaMedico();
			AgendaPaciente agendaPaciente = new AgendaPaciente();

			consulta.setId_consulta(request.getParameter("id_consulta"));
			consulta.setData_consulta(request.getParameter("data_consulta"));
			consulta.setHorario_consulta(request.getParameter("horario_consulta"));

			// busca o medico e o paciente de acordo com o id(passado por parametro)
			try {
				consulta.setCrm_medico(
						agendaMedico.procuraMedicoId(Integer.parseInt(request.getParameter("tabMedico"))));
				consulta.setRe_paciente(
						agendaPaciente.procuraPacienteId(Integer.parseInt(request.getParameter("tabPaciente"))));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (AgendaException e) {
				e.printStackTrace();
			}

			System.out.println("ID consulta salvar : " + consulta.getId_consulta());
		}

		try {
			dao = new AgendaConsulta();
			RequestDispatcher rd = null;

			if (cmd.equalsIgnoreCase("listar")) {
				List<Consulta> consultaList = null;
				request.setAttribute("consultaList", consultaList);
				rd = request.getRequestDispatcher("/mostrarConsultasCads.jsp");
			}

			else if (cmd.equalsIgnoreCase("consulta")) {
				List<Consulta> consultaList;
				if (nome.equals("")) {
					consultaList = dao.todasConsultas();
				} else {
					consultaList = dao.procuraConsulta(nome);
				}

				request.setAttribute("consultaList", consultaList);
				rd = request.getRequestDispatcher("/mostrarConsultasCads.jsp");
				System.out.println("LISTA" + consultaList);
			}

			else if (cmd.equalsIgnoreCase("addconsul")) {
				dao.salvar(consulta);
				AgendaPaciente daopac = new AgendaPaciente();
				List<Paciente> pacienteList = daopac.procuraPaciente(nome);
				request.setAttribute("pacienteList", pacienteList);
				AgendaMedico daomedico = new AgendaMedico();
				List<Medico> medicoList = daomedico.procuraMedico(nome);
				request.setAttribute("medicoList", medicoList);
				rd = request.getRequestDispatcher("/cadConsultas.jsp");
				System.out.println("ID CONSULTA " + consulta.getId_consulta());
				System.out.println("Data consulta: " + consulta.getData_consulta());

			}

			else if (cmd.equalsIgnoreCase("exc")) {
				System.out.println("Registro : " + consulta.getId_consulta());
				dao.excluir(consulta);
				System.out.println("Registro : " + consulta.getId_consulta());
				rd = request.getRequestDispatcher("AgendaConsultaServlet?cmd=listar");
			}

			else if (cmd.equalsIgnoreCase("atu")) {
				System.out.println("ENTROU AQUI NO SERVELT!!");
				System.out.println("ID CONSULTA: " + consulta.getId_consulta());
				consulta = dao.procuraConsultaId(consulta.getId_consulta());
				HttpSession session = request.getSession(true);
				session.setAttribute("consulta", consulta);
				rd = request.getRequestDispatcher("/formAtuConsulta.jsp");
				System.out.println("SAIU DO SERVLET");
			}

			else if (cmd.equalsIgnoreCase("atualizar")) {
				System.out.println("CLIQUEI NO BOTÃO ATUALIZAR!!");
				dao.atualizar(consulta);
				rd = request.getRequestDispatcher("AgendaConsultaServlet?cmd=listar");
			}

			else if (cmd.equalsIgnoreCase("principal")) {
				rd = request.getRequestDispatcher("/index.jsp");
			}
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new ServletException(e);
			} catch (ServletException e1) {
				e1.printStackTrace();
			}
		}

	}
}
