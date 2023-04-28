package сlient

import commands.Information

class Info:Client {
    override val name: String="info"

    override fun check(command: String): Information {
        if (command==name)
            return Information("Ok",0)
        return Information("У этой команды нет аргументов. Возможно вы имели в виду \"info\"",1)
    }
}