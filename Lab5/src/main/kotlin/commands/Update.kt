package commands

import product.Product

class Update(val collection:MutableList<Product>,private val args1:Array<Long>,private val args2:Array<Product>) :Command {
    override val name: String="update"
    override fun execute(): Information {
        if (!validator(args1[0]))
            return Information("Элемент с таким значением id не найден",1)
        return try {
            var c=-1
            for (o in collection){
                c++
                if (o.getId()== args1[0]){
                    o.removeFrompN(o.getPartNumber())
                    collection.remove(o)
                    collection.add(c, args2[0])
                }
            }
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }

    /*fun execute(id:Long, element:Product):Information{
        if (validator(id))
            return Information("Элемент с таким значением id не найден",1)
        return try {
            var c=-1
            for (o in collection){
                c++
                if (o.getId()== id){
                    o.removeFrompN(o.getPartNumber())
                    collection.remove(o)
                    collection.add(c,element)
                }
            }
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }*/
    private fun validator(id:Long):Boolean{
        for (o in collection){
            if (o.getId()==id)
                return true
        }
        return false
    }
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
        val obj:Product=Product(name,price, Coordinates(coordinatesX,coordinatesY),unitOfMeasure,
            Organization(manufacturerName,manufacturerAnnualTurnover,manufacturerEmployeesCount,manufacturerFullName,manufacturerType),partNumber)
        for (o in collection){
            c++
            if (o.getId()== id){
                o.removeFrompN(o.getPartNumber())
                collection.remove(o)
                collection.add(c,obj)
                return
            }
        }
        println("В коллекции нет элемента с таким индексом")
    }
    override fun Check(command: String): String {
        val s=command.split(Pattern.compile("\\s"), limit = 2)
        try {
            if (s[1].toLong()>0) {
                id = s[1].toLong()
                return "-1"
            }
            return "Id не может быть меньше одного"
        } catch (e: NumberFormatException) {
            return "Id должно быть целым числом. Повторите ввод"
        }
    }
    companion object {
        private var id:Long=1
        private var c:Int=-1
    }*/
}