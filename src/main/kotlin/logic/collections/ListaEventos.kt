package logic.collections

import logic.entities.Evento
import logic.structures.ListaEstatica

class ListaEventos {
    private var eventos = ListaEstatica<Evento>()

    fun inserirEvento(evento: Evento) {
        eventos.anexar(evento)

    }

    fun removerEventoPeloNome(nome: String): Evento? {
        var evento = buscarEventoPeloNome(nome)
        if (evento != null) {
            eventos.apagar(eventos.buscarPosicao(evento))
            return evento
        }
        return null
    }

    fun buscarEventoPeloNome(nome: String): Evento? {
        for (i in 0 until eventos.selecionarTodos().size) {
            val evento = eventos.selecionar(i)
            if (evento != null && evento.getNome() == nome) {
                return evento
            }
        }
        return null
    }

    fun buscarEventoPeloId(id: Int): Evento? {
        for (i in 0 until eventos.selecionarTodos().size) {
            val evento = eventos.selecionar(i)
            if (evento != null && evento.getId() == id) {
                return evento
            }
        }
        return null
    }

    fun buscarTodosEventos(): Array<Evento?> {
        return eventos.selecionarTodos()
    }

}