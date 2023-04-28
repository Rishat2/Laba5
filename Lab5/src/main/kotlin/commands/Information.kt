package commands

class Information(private val message:String,private val status:Int) {
    fun getStatus():Int{
        return status
    }
    fun getMessage():String{
        return message
    }
}