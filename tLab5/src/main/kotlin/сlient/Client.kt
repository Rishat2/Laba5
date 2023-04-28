package сlient

import commands.Information

interface Client{
    val name:String
    fun check(command:String):Information
}