package web;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AgendaAnamnese;
import dao.AgendaException;
import dao.AgendaPaciente;
import to.Anamnese;
import to.Paciente;

public class AgendaAnamneseServlet extends javax.servlet.http.HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {

		String nome = request.getParameter("nome_pac");
		String cmd = request.getParameter("cmd");

		System.out.println(cmd);

		if (cmd == null)
			cmd = "principal";

		AgendaAnamnese dao;
		Anamnese anamnese = new Anamnese();
		if (cmd != null || !cmd.equalsIgnoreCase("principal")) {

			AgendaPaciente agendaPaciente = new AgendaPaciente();

			Paciente paciente = new Paciente();

			try {
				System.out.println(request.getParameter("tabPaciente"));

				paciente = agendaPaciente.procuraPacienteId(Integer.parseInt(request.getParameter("tabPaciente")));
				System.out.println("TESTANDO: " + paciente);

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AgendaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// anamnese.setId_anamnese(Integer.parseInt(request.getParameter("id_anamnese")));
			anamnese.setPaciente(paciente);
			anamnese.setIdade(Integer.parseInt(request.getParameter("idade")));
			anamnese.setEstado_civil(request.getParameter("estado_civil"));
			anamnese.setFilho(request.getParameter("filho"));
			anamnese.setReligiao(request.getParameter("religiao"));
			anamnese.setInternacao(request.getParameter("internacao"));
			anamnese.setPatologia(request.getParameter("patologia"));
			anamnese.setCirurgia(request.getParameter("cirurgia"));
			anamnese.setMedicacao(request.getParameter("medicacao"));
			anamnese.setAlergia(request.getParameter("alergia"));
			anamnese.setVicio(request.getParameter("vicio"));
			anamnese.setVacina(request.getParameter("vacina"));
			anamnese.setInfarto(request.getParameter("infarto"));
			anamnese.setCancer(request.getParameter("cancer"));
			anamnese.setAvc(request.getParameter("avc"));
			anamnese.setDiabete(request.getParameter("diabete"));
			anamnese.setHas(request.getParameter("has"));
			anamnese.setAnotacao(request.getParameter("anotacao"));
		}

		try {
			dao = new AgendaAnamnese();
			RequestDispatcher rd = null;

			if (cmd.equalsIgnoreCase("listar")) {
				List<Anamnese> anamneseList = null;
				request.setAttribute("anamneseList", anamneseList);
				rd = request.getRequestDispatcher("/mostrarAnamneseCads.jsp");
				// System.out.println("Lista: " + anamneseList);
			} else if (cmd.equalsIgnoreCase("anamnese")) {
				System.out.println(" Nome: " + nome);
				List<Anamnese> anamneseList = dao.procuraAnamnese(nome);
				request.setAttribute("anamneseList", anamneseList);
				rd = request.getRequestDispatcher("/mostrarAnamneseCads.jsp");
				// System.out.println("TESTE: " + anamneseList);
			} else if (cmd.equalsIgnoreCase("anamnese")) {
				rd = request.getRequestDispatcher("/mostrarAnamneseCads.jsp");
			}

			else if (cmd.equalsIgnoreCase("addanam")) {
				dao.salvar(anamnese);
				rd = request.getRequestDispatcher("/cadaAnamnese.jsp");
				// System.out.println("Registro: " + anamnese.getPaciente().getRe_pac());
			}

			else if (cmd.equalsIgnoreCase("exc")) {
				// System.out.println("Registro : " + anamnese.getPaciente().getRe_pac());
				dao.excluir(anamnese);
				// System.out.println("Registro : " + anamnese.getPaciente().getRe_pac());
				rd = request.getRequestDispatcher("AgendaAnamneseServlet?cmd=listar");
			}

			else if (cmd.equalsIgnoreCase("atu")) {
				// System.out.println("Registro aqui: " + anamnese.getPaciente().getRe_pac());

				anamnese = dao.procuraAnamneseId(anamnese.getPaciente().getRe_pac());
				HttpSession session = request.getSession(true);
				session.setAttribute("anamnese", anamnese);
				rd = request.getRequestDispatcher("/formAtuAnamnese.jsp");
				// System.out.println("Saiu atualizar");
			}

			else if (cmd.equalsIgnoreCase("atualizar")) {
				dao.atualizar(anamnese);
				// rd =
				// request.getRequestDispatcher("/AgendaConsulta/AgendaServlet?nome_pac=&cmd=paciente&Pesquisar=Pesquisar");
				rd = request.getRequestDispatcher("AgendaAnamneseServlet?cmd=listar");
				// response.sendRedirect("/AgendaConsulta/AgendaServlet?nome_pac=&cmd=paciente&Pesquisar=Pesquisar");

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
