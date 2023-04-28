package commands

import product.Product

class FilterLessThanPartNumber(val collection:MutableList<Product>,private val args:Array<String>) :Command {
    override val name: String="filter_less_than_part_number"
    override fun execute(): Information {
        val status=0
        return try {
            for (o in collection){
                if (o.getPartNumber()< args[0])
                    println(o.toString())
            }
            Information("Команда выполнена успешно",status)
        }catch (e: Exception) {
            Information("Команду выполнить не удалось",1)
        }
    }

    /*fun execute(partNumber: String):Information{
        val status=0
        try {
            for (o in collection){
                if (o.getPartNumber()<partNumber)
                    println(o.toString())
            }
            return Information("Команда выполнена успешно",status)
        }catch (e: Exception) {
            return Information("Команду выполнить не удалось",1)
        }
    }*/
        /*override fun Execute(element: String?, collection: MutableList<Product>) {
        for (obj in collection)
            if(obj.getPartNumber()< partNumber)
                println(obj.toString())
    }
    override fun Check(command: String): String {
        val s=command.split(Pattern.compile("\\s"), limit = 2)
        if (s[1].length<13 || s[1].length>58){
            return "Номер части должен быть длиннее 12 и короче 59"
        }
        partNumber=s[1]
        return "0"
    }
    companion object{
        var partNumber:String=""
    }*/
}