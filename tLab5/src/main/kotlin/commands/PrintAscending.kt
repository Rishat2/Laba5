package commands

import product.Product

class PrintAscending(val collection: MutableList<Product>) :Command {
    override val name: String="print_ascending"
    override fun execute(): Information {
        return try {
            if (collection.isEmpty())
                Information("Коллекция пустая",0)
            val coll=collection.sortedBy { it.getprice() } as MutableList<Product>
            var reply=""
            for (obj in coll){
                reply+=obj.toString()
            }
            Information(reply,0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }

    /*fun execute():Information{
        return try {
            val coll=collection.sortedBy { it.getprice() } as MutableList<Product>
            for (obj in coll){
                print(obj.toString())
            }
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }*/
    /*override fun Execute(element: String?, collection: MutableList<Product>) {
        val coll=collection.sortedBy { it.getprice() } as MutableList<Product>
        for (obj in coll){
            print(obj.toString())
        }
    }
    override fun Check(command: String): String {
        if (command == name) {
            return "0"
        }
        return "Нет такой команды, возможно, вы имели в виду команду\"$name\""
    }*/
}