package br.com.Conradostr.AluGames.Models

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


}
