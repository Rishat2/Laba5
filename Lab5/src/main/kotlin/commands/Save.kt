package commands

import JsonFile
import product.Product

class Save(val collection: MutableList<Product>) :Command {
    override val name: String="save"
    override fun execute(): Information {
        return try {
            val json=JsonFile()
            json.encodeAndWrite(collection,"JSON")
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }

    /*fun execute():Information{
        return try {
            val json=JsonFile()
            json.EncodeAndWrite(collection,"JSON")
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }*/
    /*override fun Execute(element: String?, collection: MutableList<Product>) {
        val json=JsonFile()
        json.EncodeAndWrite(collection,"JSON")
    }
    override fun Check(command: String): String {
        if (command == name) {
            return "0"
        }
        return "Нет такой команды, возможно, вы имели в виду команду\"$name\""
    }*/
}