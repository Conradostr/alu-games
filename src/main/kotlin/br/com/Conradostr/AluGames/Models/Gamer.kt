package br.com.Conradostr.AluGames.Models

import java.util.Scanner
import kotlin.random.Random

data class Gamer(
    var name:String,
    var email:String
    ){
    var dateOfBirth:String? = null
    var userName:String? = null
        set(value) {
            field = value
            if (userName.isNullOrBlank()){
                createIdInternal()
            }
        }
    var favoriteGames = mutableListOf<Game?>()
    var idInternal:String? = null
        private set
    constructor(
        name: String,
        email: String,
        dateOfBirth: String,
        userName:String,
        ): this(name, email){
            this.dateOfBirth = dateOfBirth
            this.userName = userName
            createIdInternal()
        }

    init {
        if (name.isNullOrBlank()){
            throw IllegalArgumentException("Nome em branco")
        }

        this.email = validateEmail()
    }

    override fun toString(): String {
        return "Gamer(name='$name',\n" +
                " email='$email',\n" +
                " dateOfBirth=$dateOfBirth,\n" +
                " userName=$userName,\n" +
                " idInternal=$idInternal)"
    }

    fun createIdInternal(){
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)
        idInternal = "$userName#$tag"
    }

    fun validateEmail(): String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)){
            return email
        }else{
            throw IllegalArgumentException("Email invalid")
        }

    }

    companion object {
        fun createGamer(reading: Scanner): Gamer{
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val name = reading.nextLine()
            println("Digite seu e-mail:")
            val email = reading.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val option = reading.nextLine()

            if(option.equals("s", true)){
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val birth = reading.nextLine()
                println("Digite seu nome de usuário:")
                val user = reading.nextLine()
                return Gamer(name, email, birth, user)

            }
            return Gamer(name, email)
        }
    }


}
