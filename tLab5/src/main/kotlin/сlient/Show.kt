package сlient

import commands.Information

class Show:Client {
    override val name: String="show"

    override fun check(command: String): Information {
        if (command==name)
            return Information("Ok",0)
        return Information("У этой команды нет аргументов. Возможно вы имели в виду \"show\"",1)
    }
}