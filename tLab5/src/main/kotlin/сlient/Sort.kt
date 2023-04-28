package сlient

import commands.Information

class Sort:Client {
    override val name: String="sort"

    override fun check(command: String): Information {
        if (command==name)
            return Information("Ok",0)
        return Information("У этой команды нет аргументов. Возможно вы имели в виду \"sort\"",1)
    }
}