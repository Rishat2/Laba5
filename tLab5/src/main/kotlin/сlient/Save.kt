package сlient

import commands.Information

class Save:Client {
    override val name: String="save"

    override fun check(command: String): Information {
        if (command==name)
            return Information("Ok",0)
        return Information("У этой команды нет аргументов. Возможно вы имели в виду \"save\"",1)
    }
}