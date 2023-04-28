package сlient

import commands.Information
import Console

class RemoveById(private val args:Array<Long>):Client {
    override val name: String="remove_by_id"

    override fun check(command: String): Information {
        val console=Console()
        if (console.checkId(console.getArgs(command))){
            args[0]=console.getArgs(command).toLong()
            return Information("Ok",0)
        }
        return Information("Id должно быть натуральным числом",1)
    }
}