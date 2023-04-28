package commands

import product.Product

class Show (var collection:MutableList<Product>):Command {
    override val name: String="show"
    override fun execute(): Information {
        return try {
            if (collection.isEmpty())
                return Information("Коллекция пустая",0)
            var reply=""
            for (obj in collection) {
                reply+=obj
            }
            Information(reply, 0)

        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }

    /*fun execute():Information{
        return try {
            for (obj in collection){
                println(obj.toString())
            }
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }*/
    /*override fun Execute(element: String?, collection: MutableList<Product>) {
        for (obj in collection){
            println(obj.toString())
        }
    }

    override fun Check(command: String): String {
        if (command == name) {
            return "0"
        }
        return "Нет такой команды, возможно, вы имели в виду команду\"$name\""
    }*/
 }
