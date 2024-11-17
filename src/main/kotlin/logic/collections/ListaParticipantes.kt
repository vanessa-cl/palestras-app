package logic.collections

import logic.entities.Participante
import logic.structures.ListaEstatica

class ListaParticipantes {
    private var participantes = ListaEstatica<Participante>()

    fun inserirParticipante(participante: Participante) {
        participantes.anexar(participante)
    }

    fun removerParticipantePeloNome(nome: String): Participante? {
        var participante = buscarParticipantePeloNome(nome)
        if (participante != null) {
            participantes.apagar(participantes.buscarPosicao(participante))
            return participante
        }
        return null
    }

    fun buscarParticipantePeloNome(nome: String): Participante? {
        for (i in 0 until participantes.selecionarTodos().size) {
            val participante = participantes.selecionar(i)
            if (participante != null && participante.getNome() == nome) {
                return participante
            }
        }
        return null
    }

    fun buscarParticipantePeloId(id: Int): Participante? {
        for (i in 0 until participantes.selecionarTodos().size) {
            val participante = participantes.selecionar(i)
            if (participante != null && participante.getId() == id) {
                return participante
            }
        }
        return null
    }

    fun buscarTodosParticipantes() {
//        return participantes.selecionarTodos()
    }

    fun estaCheia(): Boolean {
        return participantes.estaCheia()
    }

    fun estaVazia(): Boolean {
        return participantes.estaVazia()
    }

}