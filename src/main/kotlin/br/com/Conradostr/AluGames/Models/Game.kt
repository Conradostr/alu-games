package br.com.Conradostr.AluGames.Models

class Game(
    val title: String,
    val cover: String

) {
    var description:String? = null
    override fun toString(): String {
        return "Title: '$title',\n" +
                "Cover: '$cover', \n" +
                "Description: $description"

    }
}