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

import dao.AgendaMedico;
import to.Medico;

public class AgendaMedicoServlet extends javax.servlet.http.HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {

		// PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome_med");
		String cmd = request.getParameter("cmd");
		// String re_pac = request.getParameter("re_pac");

		System.out.println(cmd);

		if (cmd == null)
			cmd = "principal";

		AgendaMedico dao;
		Medico medico = new Medico();
		if (cmd != null || !cmd.equalsIgnoreCase("principal")) {

			medico.setCrm_med(request.getParameter("crm_med"));
			medico.setNome_med(request.getParameter("nome_med"));
			medico.setEspecialidade(request.getParameter("especialidade"));

			try {
				dao = new AgendaMedico();
				RequestDispatcher rd = null;
				if (cmd.equalsIgnoreCase("listar")) {

					List<Medico> medicoList = null;
					request.setAttribute("medicoList", medicoList);
					rd = request.getRequestDispatcher("/mostrarMedicosCads.jsp");
					System.out.println("Lista: " + medicoList);
				}

				else if (cmd.equalsIgnoreCase("medico")) {
					System.out.println(" Nome: " + nome);
					List<Medico> medicoList = dao.procuraMedico(nome);
					request.setAttribute("medicoList", medicoList);
					rd = request.getRequestDispatcher("/mostrarMedicosCads.jsp");
					System.out.println(medicoList);
				}

				else if (cmd.equalsIgnoreCase("addmed")) {
					dao.salvar(medico);
					rd = request.getRequestDispatcher("/cadMedico.html");
					System.out.println("Registro: " + medico.getCrm_med());
					// System.out.println("Sexo: " + medico.getSexo_pac());
				}

				else if (cmd.equalsIgnoreCase("exib")) {

					medico = dao.procuraMedicoId(medico.getCrm_med());
					request.setAttribute("medico", medico);
					System.out.println(" teste: " + medico.getEspecialidade());

					rd = request.getRequestDispatcher("/exibirMedico.jsp");

				} else if (cmd.equalsIgnoreCase("exc")) {
					System.out.println("Registro : " + medico.getCrm_med());
					dao.excluir(medico);
					System.out.println("Registro : " + medico.getCrm_med());
					rd = request.getRequestDispatcher("AgendaMedicoServlet?cmd=listar");
				}

				else if (cmd.equalsIgnoreCase("atu")) {
					// System.out.println("Entrou aqui.");
					System.out.println("Registro aqui: " + medico.getCrm_med());

					medico = dao.procuraMedicoId(medico.getCrm_med());
					System.out.println("Antes de atualza Especialidades: " + medico.getEspecialidade());
					// medico = dao.procuraPaciente(Integer.parseInt());
					HttpSession session = request.getSession(true);
					session.setAttribute("medico", medico);
					rd = request.getRequestDispatcher("/formAtuMedico.jsp");
					System.out.println("Saiu atualizar");
					System.out.println("Especialidade: " + medico.getEspecialidade());
				}

				else if (cmd.equalsIgnoreCase("atualizar")) {
					System.out.println("Atualizar Sexo: " + medico.getEspecialidade());
					dao.atualizar(medico);
					rd = request.getRequestDispatcher("AgendaMedicoServlet?nome_med=&cmd=medico&Pesquisar=Pesquisar");
					System.out.println("Antes de atualza Sexo: " + medico.getEspecialidade());
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
}
