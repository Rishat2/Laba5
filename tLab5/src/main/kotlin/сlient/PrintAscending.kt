package сlient

import commands.Information

class PrintAscending:Client {
    override val name: String="print_ascending"

    override fun check(command: String): Information {
        if (command==name)
            return Information("Ok",0)
        return Information("У этой команды нет аргументов. Возможно вы имели в виду \"print_ascending\"",1)
    }
}