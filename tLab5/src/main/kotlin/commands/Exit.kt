package commands

class Exit() :Command {
    override val name: String="exit"
    override fun execute(): Information {
        return Information("Команда успешно выполнена",-1)
    }

    /*fun execute():Information{
        return Information("Команда успешно выполнена",-1)
    }*/
    /*override fun Execute(element: String?, collection: MutableList<Product>) {
    }

    override fun Check(command: String): String {
        if (command==name) {
            return "break"
        }
        return "Нет такой команды, возможно, вы имели в виду \"exit\""
    }*/
}