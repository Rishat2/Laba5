package commands

import product.Product

class RemoveLast(val collection: MutableList<Product>) :Command {
    override val name: String="remove_last"
    override fun execute(): Information {
        if (!validator())
            return Information("Коллекция пустая. Команду выполнить не удалось",1)
        return try {
            collection.get(collection.size-1).removeFrompN(collection.get(collection.size-1).getPartNumber())
            collection.removeAt(collection.size - 1)
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }

    /*fun execute():Information{
        if (validator())
            return Information("Коллекция пустая. Команду выполнить не удалось",1)
        return try {
            collection.get(collection.size-1).removeFrompN(collection.get(collection.size-1).getPartNumber())
            collection.removeAt(collection.size - 1)
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }*/
    fun validator():Boolean{
        if (collection.isNotEmpty())
            return true
        return false
    }
    /*override fun Execute(element: String?, collection: MutableList<Product>) {
        if (collection.isNotEmpty()) {
            collection.get(collection.size-1).removeFrompN(collection.get(collection.size-1).getPartNumber())
            collection.removeAt(collection.size - 1)
            return
        }
        println("Коллекция пустая")
    }
    override fun Check(command: String): String {
        if (command == name) {
            return "0"
        }
        return "Нет такой команды, возможно, вы имели в виду команду\"$name\""
    }*/
}