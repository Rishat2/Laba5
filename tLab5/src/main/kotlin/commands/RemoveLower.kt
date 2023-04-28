package commands

import product.Product

class RemoveLower(val collection: MutableList<Product>,private val args:Array<Product>) :Command {
    override val name: String="remove_lower"
    override fun execute(): Information {
        return try {
            for (i in collection.indices.reversed()){
                if (collection[i].comparison(args[0])) {
                    collection[i].removeFrompN(collection[i].getPartNumber())
                    collection.remove(collection[i])
                }
            }
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }

    /*fun execute(varargelement: Product.Product, vararg manufacturer: RemoveAllByManufacturer):Information{
        return try {
            for (i in collection.indices.reversed()){
                if (collection[i].comparison(element)) {
                    collection[i].removeFrompN(collection[i].getPartNumber())
                    collection.remove(collection[i])
                }
            }
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }*/
    /*val UnitOfMeasure= mapOf("PCS" to UnitofMeasure.PCS,"LITERS" to UnitofMeasure.LITERS, "MILLIGRAMS" to UnitofMeasure.MILLIGRAMS)
    val Type= mapOf("COMMERCIAL" to OrganisationType.COMMERCIAL, "TRUST" to OrganisationType.TRUST, "PRIVATE_LIMITED_COMPANY" to OrganisationType.PRIVATE_LIMITED_COMPANY)
    override fun Execute(element: String?, collection: MutableList<Product>) {
        val s=element!!.split(Pattern.compile("\\s"))
        val name=s[0]
        val coordinatesX=s[1].toInt()
        val coordinatesY=s[2].toLong()
        val price=s[3].toLong()
        val partNumber=s[4]
        val unitOfMeasure=UnitOfMeasure.get(s[5])!!
        val manufacturerName=s[6]
        val manufacturerFullName=s[7]
        val manufacturerAnnualTurnover=s[8].toLong()
        val manufacturerEmployeesCount=s[9].toLong()
        val manufacturerType=Type.get(s[10])
        val obj =Product(name,price, Coordinates(coordinatesX,coordinatesY),unitOfMeasure,
            Organization(manufacturerName,manufacturerAnnualTurnover,manufacturerEmployeesCount,manufacturerFullName,manufacturerType),partNumber)
        for (i in collection.indices.reversed()){
            if (collection[i].comparison(obj)) {
                collection[i].removeFrompN(collection[i].getPartNumber())
                collection.remove(collection[i])
            }
        }
    }
    override fun Check(command: String): String {
        if (command == name) {
            return "-1"
        }
        return "Нет такой команды, возможно, вы имели в виду команду\"$name\""
    }*/
}