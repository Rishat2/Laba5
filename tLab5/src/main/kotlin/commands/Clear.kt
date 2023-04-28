package commands

import product.Product

class Clear(val collection: MutableList<Product>) : Command {
    override val name: String="clear"
    override fun execute(): Information {
        var status = 0
        try {
            collection.clear()
            return Information("Команда выполнена успешно", status)
        } catch (e: Exception) {
            status = 1
            return Information("Команду выполнить не удалось", status)
        }
    }


    /*fun execute(): Information {
        var status=0
        try {
            collection.clear()
            return Information("Команда выполнена успешно",status)
        }catch (e: Exception) {
            status = 1
            return Information("Команду выполнить не удалось", status)
        }
    }*/

    /*override fun Execute(element: String?, collection: MutableList<Product>) {
        collection.clear()
        Product.clear()
    }
    override fun Check(command: String): String {
        if (command==name) {
            return "0"
        }
        return "Нет такой команды, возможно, вы имели в виду команду\"clear\""
    }*/
}
