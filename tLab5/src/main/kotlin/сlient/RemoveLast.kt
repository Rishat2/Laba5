package сlient

import commands.Information

class RemoveLast:Client {
    override val name: String="remove_last"

    override fun check(command: String): Information {
        if (command==name)
            return Information("Ok",0)
        return Information("У этой команды нет аргументов. Возможно вы имели в виду \"remove_last\"",1)
    }
}