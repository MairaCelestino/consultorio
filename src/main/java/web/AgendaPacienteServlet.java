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

import dao.AgendaPaciente;
import dao.InterfacePacienteAgenda;
import to.Paciente;

public class AgendaPacienteServlet extends javax.servlet.http.HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {

		// PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome_pac");
		String cmd = request.getParameter("cmd");
		// String re_pac = request.getParameter("re_pac");

		System.out.println(cmd);

		if (cmd == null)
			cmd = "principal";

		InterfacePacienteAgenda dao;
		Paciente paciente = new Paciente();
		if (cmd != null || !cmd.equalsIgnoreCase("principal")) {

			paciente.setRe_pac(request.getParameter("re_pac"));
			paciente.setNome_pac(request.getParameter("nome_pac"));
			paciente.setSexo_pac(request.getParameter("sexo_pac"));
			paciente.setDataNasc_pac(request.getParameter("dataNasc_pac"));

		}

		try {
			dao = new AgendaPaciente();
			RequestDispatcher rd = null;

			if (cmd.equalsIgnoreCase("listar")) {

				List<Paciente> pacienteList = null;
				request.setAttribute("pacienteList", pacienteList);
				rd = request.getRequestDispatcher("/mostrarPacientesCads.jsp");
				System.out.println("Lista: " + pacienteList);
			}

			else if (cmd.equalsIgnoreCase("paciente")) {
				System.out.println(" Nome: " + nome);
				List<Paciente> pacienteList = dao.procuraPaciente(nome);
				request.setAttribute("pacienteList", pacienteList);
				rd = request.getRequestDispatcher("/mostrarPacientesCads.jsp");
				System.out.println(pacienteList);
			}

			else if (cmd.equalsIgnoreCase("addpac")) {
				dao.salvar(paciente);
				rd = request.getRequestDispatcher("/cadPaciente.html");
				System.out.println("Registro: " + paciente.getRe_pac());
				System.out.println("Sexo: " + paciente.getSexo_pac());
				rd = request.getRequestDispatcher("AgendaPacienteServlet?cmd=listar");
			}

			else if (cmd.equalsIgnoreCase("exc")) {
				System.out.println("Registro : " + paciente.getRe_pac());
				dao.excluir(paciente);
				System.out.println("Registro : " + paciente.getRe_pac());
				rd = request.getRequestDispatcher("AgendaServlet?cmd=listar");
			}

			else if (cmd.equalsIgnoreCase("atu")) {
				// System.out.println("Entrou aqui.");
				System.out.println("Registro aqui: " + paciente.getRe_pac());

				paciente = dao.procuraPacienteId(paciente.getRe_pac());
				System.out.println("Antes de atualza Sexo: " + paciente.getSexo_pac());
				// paciente = dao.procuraPaciente(Integer.parseInt());
				HttpSession session = request.getSession(true);
				session.setAttribute("paciente", paciente);
				rd = request.getRequestDispatcher("/formAtuPaciente.jsp");
				System.out.println("Saiu atualizar");
				System.out.println("Sexo: " + paciente.getSexo_pac());
			}

			else if (cmd.equalsIgnoreCase("atualizar")) {
				System.out.println("Atualizar Sexo: " + paciente.getSexo_pac());
				dao.atualizar(paciente);
				// rd =
				// request.getRequestDispatcher("/AgendaConsulta/AgendaServlet?nome_pac=&cmd=paciente&Pesquisar=Pesquisar");
				// rd = request.getRequestDispatcher("AgendaServlet?cmd=listar");
				response.sendRedirect("/AgendaConsulta/AgendaServlet?nome_pac=&cmd=paciente&Pesquisar=Pesquisar");
				System.out.println("Antes de atualza Sexo: " + paciente.getSexo_pac());
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
