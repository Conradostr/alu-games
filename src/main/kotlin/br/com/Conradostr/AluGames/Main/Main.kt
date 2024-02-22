package br.com.Conradostr.AluGames.Main

import br.com.Conradostr.AluGames.Models.Game
import br.com.Conradostr.AluGames.Models.Gamer
import br.com.Conradostr.AluGames.Services.ConsumptionApi
import java.util.*


fun main() {
    val reading = Scanner(System.`in`)
    val gamer = Gamer.createGamer(reading)
    do{
        println("Por favor informe o ID do jogo: ")
        val id = reading.nextLine()

        val search = ConsumptionApi()
        val informationGame = search.SearchApi(id)

        var newGame: Game? = null

        val result = runCatching {


            newGame = Game(
                informationGame.info.title,
                informationGame.info.thumb
            )
        }

        result.onFailure {
            println("Id nao encontrado")
        }

        result.onSuccess {
            println("Deseja incluir descrição personalizada?? S/N")
            val option = reading.nextLine()

            if (option.equals("s", true)){
                println("Informe a descricao que deseja: ")
                val descriptionPersonalized = reading.nextLine()
                newGame?.description = descriptionPersonalized
            } else {
                newGame?.description = newGame?.title
            }
        }

        gamer.favoriteGames.add(newGame)

        println("Deseja realizar uma nova busca?? S/n")
        val op = reading.nextLine()

    }while (op.equals("s", true))

    println("*** Lista de Jogos favoritados ***")
    println(gamer.favoriteGames)
    println("*** Busca realizada com sucesso ***")


}