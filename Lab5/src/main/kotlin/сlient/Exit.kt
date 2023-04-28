package сlient

import commands.Information

class Exit:Client {
    override val name: String="exit"

    override fun check(command: String): Information {
        if (command==name)
            return Information("Ok",0)
        return Information("У этой команды нет аргументов. Возможно вы имели в виду \"exit\"",1)
    }
}