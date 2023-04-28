package commands

import product.Product

class Info(val collection:MutableList<Product>) :Command {
    override val name: String="info"
    override fun execute(): Information {
            return Information("Тип: Product.Product\n" +
                    "Дата инициализации: ${Product.Date}\n" +
                    "Количество элементов: ${collection.size}\n",0)
    }

    /*fun execute():Information{
        return try {
            print(  "Тип: Product.Product\n" +
                    "Дата инициализации: ${Product.Date}\n" +
                    "Количество элементов: ${collection.size}")
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }*/
    /*override fun Execute(element: String?, collection: MutableList<Product>) {
        print(  "Тип: Product.Product\n" +
                "Дата инициализации: ${Product.Date}\n" +
                "Количество элементов: ${collection.size}")
    }

    override fun Check(command: String): String {
        if (command == name) {
            return "0"
        }
        return "Нет такой команды, возможно, вы имели в виду команду\"$name\""
    }*/
}