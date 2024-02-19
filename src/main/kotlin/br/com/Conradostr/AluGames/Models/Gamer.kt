package br.com.Conradostr.AluGames.Models

data class Gamer(
    var name:String,
    var email:String
    ){
    var dateOfBirth:String? = null
    var userName:String? = null
    var idInternal:String? = null

    constructor(
        name: String,
        email: String,
        dateOfBirth: String,
        userName:String,
        ): this(name, email){
            this.dateOfBirth = dateOfBirth
            this.userName = userName
        }

    override fun toString(): String {
        return "Gamer(name='$name',\n" +
                " email='$email',\n" +
                " dateOfBirth=$dateOfBirth,\n" +
                " userName=$userName,\n" +
                " idInternal=$idInternal)"
    }


}
