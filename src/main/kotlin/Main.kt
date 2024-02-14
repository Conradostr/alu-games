import br.com.Conradostr.Models.Game
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers


fun main() {
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=158"))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()

    println(json)

    val batman = Game("Batman: Arkham Asylum Game of the Year Edition",
        "https:\\/\\/cdn.cloudflare.steamstatic.com\\/steam\\/apps\\/35140\\/capsule_sm_120.jpg?t=1702934705",
        "Jogo do Batman mucho bueno my friend")
    println(batman)
}