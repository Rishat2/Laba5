package сlient

import commands.Information
import Console

class ExecuteScript(private val args:Array<String>):Client {
    override val name: String="execute_script"

    override fun check(command: String): Information {
        val console=Console()
        if (console.checkExecuteScript(console.getCommand(command))) {
            args[0]=console.getArgs(command)
            return Information("Ok", 0)
        }
        return Information("Такого файла не существует, повторите ввод",1)
    }
}