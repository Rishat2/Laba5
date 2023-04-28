package commands

import product.Organization
import product.Product

class RemoveAllByManufacturer(val collection:MutableList<Product>,private val args:Array<Organization>) :Command {
    override val name: String="remove_all_by_manufacturer"
    override fun execute(): Information {
        return try {
            for (i in collection.indices.reversed()){
                if (collection[i].EqualsByManufacturer(args[0])){
                    collection[i].removeFrompN(collection[i].getPartNumber())
                    collection.remove(collection[i])
                }
            }
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }

    /*fun execute(manufacturer:Organization):Information{
        return try {
            for (i in collection.indices.reversed()){
                if (collection[i].EqualsByManufacturer(manufacturer)){
                    collection[i].removeFrompN(collection[i].getPartNumber())
                    collection.remove(collection[i])
                }
            }
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }*/
    /*val Type= mapOf("COMMERCIAL" to OrganisationType.COMMERCIAL, "TRUST" to OrganisationType.TRUST, "PRIVATE_LIMITED_COMPANY" to OrganisationType.PRIVATE_LIMITED_COMPANY)
    override fun Execute(element: String?, collection: MutableList<Product>) {
        val s=element!!.split(Pattern.compile("\\s"))
        val manufacturerName=s[0]
        val manufacturerFullName: String? =s[1]
        val manufacturerAnnualTurnover=s[2].toLong()
        val manufacturerEmployeesCount=s[3].toLong()
        val manufacturerType=Type.get(s[4])
        val man=Organization(manufacturerName,manufacturerAnnualTurnover,manufacturerEmployeesCount,manufacturerFullName,manufacturerType)
        for (i in collection.indices.reversed()){
            if (collection[i].EqualsByManufacturer(man)){
                collection[i].removeFrompN(collection[i].getPartNumber())
                collection.remove(collection[i])
            }
        }
    }
    override fun Check(command: String): String {
        if (command == name) {
            return "-2"
        }
        return "Нет такой команды, возможно, вы имели в виду команду\"$name\""
    }*/
}