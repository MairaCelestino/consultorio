package dao;

import java.util.List;

import to.Exame;
import to.TipoExame;

public class InterfaceExameAgenda {

	void salvar(Exame exame) throws AgendaException {
	}

	List<TipoExame> todosExames() throws AgendaException {
		return null;

	}

	List<Exame> procuraExame(String nome) throws AgendaException {
		return null;
	}

	Exame procuraTipoExameId(int id_tipoexame) throws AgendaException {
		return null;
	}

}
