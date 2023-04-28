package сlient

import commands.Information

class Help:Client {
    override val name: String="help"

    override fun check(command: String): Information {
        if (command==name)
            return Information("Ok",0)
        return Information("У этой команды нет аргументов. Возможно вы имели в виду \"help\"",1)
    }
}