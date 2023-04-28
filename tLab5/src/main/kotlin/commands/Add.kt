package commands
import product.*

open class Add(private var collection: MutableList<Product>, private val args:Array<Product>) : Command {
    override val name:String="add"
    override fun execute(): Information {
        var status=0
        //val obj=Product("1",1, Coordinates(1,1),UnitofMeasure.PCS, Organization("1",1,1,"1",OrganisationType.TRUST),"sdfghjmnbvcdfgdeececv")
        try {
            collection.add(args[0])
            return Information("Команда была успешно выполнена",status)
        }catch (e: Exception){
            status=1
            return Information("Команду выполнить не удалось",status)
        }
    }

    /*fun execute(vararg element: Product, manufacturer: RemoveAllByManufacturer): Information {
        var status=0
        try {
            collection.add(element[0])
            return Information("Команда была успешно выполнена",status)
        }catch (e: Exception){
            status=1
            return Information("Команду выполнить не удалось",status)
        }
    }*/


    /*val UnitOfMeasure= mapOf("PCS" to UnitofMeasure.PCS,"LITERS" to UnitofMeasure.LITERS, "MILLIGRAMS" to UnitofMeasure.MILLIGRAMS)
    val Type= mapOf("COMMERCIAL" to OrganisationType.COMMERCIAL, "TRUST" to OrganisationType.TRUST, "PRIVATE_LIMITED_COMPANY" to OrganisationType.PRIVATE_LIMITED_COMPANY)
    final override fun execute(element:String?,collection: MutableList<Product>) {
       val s=element!!.split(Pattern.compile("\\s"))
       val name=s[0]
       val coordinatesX=s[1].toInt()
       val coordinatesY=s[2].toLong()
       val price=s[3].toLong()
       val partNumber=s[4]
       val unitOfMeasure=UnitOfMeasure.get(s[5])!!
       val manufacturerName=s[6]
       val manufacturerFullName: String? =s[7]
       val manufacturerAnnualTurnover=s[8].toLong()
       val manufacturerEmployeesCount=s[9].toLong()
       val manufacturerType=Type.get(s[10])
        val obj:Product=Product(name,price, Coordinates(coordinatesX,coordinatesY),unitOfMeasure,Organization(manufacturerName,manufacturerAnnualTurnover,manufacturerEmployeesCount,manufacturerFullName,manufacturerType),partNumber)
     collection.add(obj)
    }

    override fun Check(command: String): String {
        if (command==name) {
            return "-1"
        }
        return "Нет такой команды, возможно, вы имели в виду команду\"add\""
    }*/
}