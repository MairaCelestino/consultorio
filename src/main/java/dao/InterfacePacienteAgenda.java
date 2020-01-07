package dao;

import java.util.List;

import to.Paciente;

public interface InterfacePacienteAgenda {

	void atualizar(Paciente paciente) throws AgendaException;

	void excluir(Paciente paciente) throws AgendaException;

	void salvar(Paciente paciente) throws AgendaException;

	List<Paciente> todosPacientes() throws AgendaException;

	List<Paciente> procuraPaciente(String nome) throws AgendaException;

	Paciente procuraPacienteId(int re_pac) throws AgendaException;
}
