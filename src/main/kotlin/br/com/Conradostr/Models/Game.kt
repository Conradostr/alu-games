package br.com.Conradostr.Models

class Game(
    val title: String,
    val cover: String

) {
    override fun toString(): String {
        return "Title: '$title',\n" +
                "Cover: '$cover', \n"

    }
}