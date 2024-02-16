import br.com.Conradostr.Models.Game
import br.com.Conradostr.Models.InfoGame
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner


fun main() {
    val reading = Scanner(System.`in`)

    println("Por favor informe o ID do jogo: ")
    val id = reading.nextLine()

    val address = "https://www.cheapshark.com/api/1.0/games?id=$id"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(address))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
    val gson = Gson()




    val result = runCatching {

        val newInfoGame = gson.fromJson(json, InfoGame::class.java)

        val newGame = Game(
            newInfoGame.info.title,
            newInfoGame.info.thumb
        )
    }

    result.onFailure {
        println("Id nao encontrado")
    }





}