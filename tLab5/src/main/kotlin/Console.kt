import product.*
import java.nio.file.Files
import java.nio.file.Paths
import java.util.regex.Pattern

class Console {
    private val commands= listOf("remove_all_by_manufacturer","add","remove_lower","execute_script","filter_less_than_part_number","remove_by_id","update","help","info","show","clear","save","exit","remove_last","sort","print_ascending")
    fun getArgs(command: String): String {
        val s=command.split(Pattern.compile("\\s"),limit=2)
        return s[1]
    }

    fun check(command:String):Boolean{
        val s=command.split(Pattern.compile("\\s"),limit=2)
        if (s[0] in commands)
            return true
        return false
            /*if(command in commandsNoArgs) return 0
            if (command in commandsWithArgs) return 1
            if (command =="remove_all_by_manufacturer") return 2
            if(getCommand(command)=="execute_script"){
                if (checkExecuteScript(getArgs(command)))
                    return 3
                return -3}
            if(getCommand(command)=="filter_less_than_part_number"){
                if (validPartNumber(getArgs(command)))
                return 3
                return -31}
            if(getCommand(command)=="remove_by_id"){
                if (checkId(getArgs(command))) {return 5}
                return -32}
            if(getCommand(command)=="update"){
                if (checkId(getArgs(command))) {return 4}
                return -32}
        return -1*/
    }
    fun getCommand(command:String):String{
        val s=command.split(Pattern.compile("\\s"),limit=2)
        return s[0]
    }
    fun getId(command:String):Long{
        val s=command.split(Pattern.compile("\\s"),limit=2)
        return s[1].toLong()
    }
    fun getElement(): Product {
        val name=getName()
        val coordinatesX=getX()
        val coordinatesY=getY()
        val price=getPrice()
        val partNumber=getPartNumber()
        val unitofMeasure=getUnitOfMeasure()
        val manufacturerName=getManufacturerName()
        val manufacturerAnnualTurnOver=getAnnualTurnOver()
        val manufacturerEmployeesCount=getEmployeesCount()
        val manufacturerType=getManufacturerType()
        val manufacturerFullName=getManufacturerFullName()
        /*val name="cake"
        val coordinatesX="10"
        val coordinatesY="10"
        val price="450"
        val partNumber="cakecakecakecakecake"
        val unitofMeasure="MILLIGRAMS"
        val manufacturerName="Condy"
        val manufacturerAnnualTurnOver="100"
        val manufacturerEmployeesCount="100"
        val manufacturerType="TRUST"
        val manufacturerFullName="Conditer"*/

        val element=Product(name,price,
            Coordinates(coordinatesX,coordinatesY),unitofMeasure, Organization(manufacturerName,manufacturerAnnualTurnOver,manufacturerEmployeesCount,manufacturerFullName,manufacturerType),partNumber)
        return element
    }
    fun getManufacturer():Organization{
        val manufacturerName=getManufacturerName()
        val manufacturerAnnualTurnOver=getAnnualTurnOver()
        val manufacturerEmployeesCount=getEmployeesCount()
        val manufacturerType=getManufacturerType()
        val manufacturerFullName=getManufacturerFullName()
        val manufacturer=Organization(manufacturerName,manufacturerAnnualTurnOver,manufacturerEmployeesCount,manufacturerFullName,manufacturerType)
        return manufacturer
    }
    fun getManufacturerFullName(): String? {
        var fullName:String?
        print("Введите полное название организации >>> ")
        fullName= readLine()
        if (fullName=="")
            fullName=null
        return fullName
    }
    fun getManufacturerType(): OrganisationType? {
        var type:String?
        val t:OrganisationType?
        while (true) {
            print("Введите тип организации (1 если COMMERCIAL, 2 если TRUST,3 если PRIVATE_LIMITED_COMPANY, пустую строку если типа нет) >>> ")
            type= readLine()
            if (validManufacturerType(type)) {
                t=when(type){
                    "1" -> OrganisationType.COMMERCIAL
                    "2" -> OrganisationType.TRUST
                    "3" -> OrganisationType.PRIVATE_LIMITED_COMPANY
                    else -> {null}
                }
                break
            }
            println("\nВведите 1, 2, 3 или пустую строку")
        }
        return t
    }
    fun validManufacturerType(type:String?): Boolean {
        if (type=="")
            return true
        try {
            if (!(type!!.toInt() in 1..3))
                return false
            return true
        } catch (e: NumberFormatException){
            return false
        }
    }
    fun getEmployeesCount(): Long {
        var employeesCount:String?
        val eC:Long
        while (true) {
            print("Введите количество сотрудников >>> ")
            employeesCount= readLine()
            if (validEmployeesCount(employeesCount)) {
                eC=employeesCount!!.toLong()
                break
            }
            println("\nКоличество сотрудников должно быть положительным числом")
        }
        return eC
    }
    fun validEmployeesCount(employeesCount:String?): Boolean {
        if (employeesCount==null)
            return false
        try {
            if (employeesCount.toLong()<1)
                return false
            return true
        } catch (e: NumberFormatException){
            return false
        }
    }
    fun getAnnualTurnOver(): Long {
        var annualTurnover:String?
        val aT:Long
        while (true) {
            print("Введите ежегодный оборот >>> ")
            annualTurnover= readLine()
            if (validAnnualTurnover(annualTurnover)) {
                aT = annualTurnover!!.toLong()
                break
            }
            println("\nЕжегодный оборот должен быть целым положительным числом")
        }
        return aT
    }
    fun validAnnualTurnover(y:String?): Boolean {
        if (y==null)
            return false
        try {
            if (y.toLong()<1)
                return false
            return true
        } catch (e: NumberFormatException){
            return false
        }
    }
    fun getManufacturerName(): String {
        var name:String?
        while (true) {
            print("Введите название организации >>> ")
            name= readLine()
            if (validManufacturerName(name))
                break
            println("\nНекорректное название организации")
        }
        return name!!
    }
    fun validManufacturerName(name:String?): Boolean {
        if (name==null || name=="")
            return false
        return true
    }
    fun getUnitOfMeasure(): UnitofMeasure {
        var unitofMeasure: String?
        val uOM: UnitofMeasure
        while (true) {
            print("Введите единицы измерения продукта(1 если PCS,2 если LITERS,3 если MILLIGRAMS) >>> ")
            unitofMeasure = readLine()
            if (validUnitOfMeasure(unitofMeasure)) {
                uOM = when (unitofMeasure) {
                    "1" -> UnitofMeasure.PCS
                    "2" -> UnitofMeasure.LITERS
                    else -> {
                        UnitofMeasure.MILLIGRAMS
                    }
                }
                break
            }
            println("\nВведите 1, 2 или 3")
        }
        return uOM
    }

    fun validUnitOfMeasure(unitOfMeasure:String?): Boolean {
        if (unitOfMeasure==null)
            return false
        try {
            if(!(unitOfMeasure.toInt() in 1..3))
                return false
            return true
        } catch (e: NumberFormatException){
            return false
        }
    }
    fun getPartNumber(): String {
        var partNumber:String?
        while (true) {
            print("Введите номер части >>> ")
            partNumber= readLine()
            if (validPartNumber(partNumber))
                break
            println("\nНомер части должен быть уникальным, больше 12 и меньше 59")
        }
        return partNumber!!
    }
    fun validPartNumber(partNumber:String?): Boolean {
        if (partNumber==null)
            return false
        else if (partNumber.length<13 || partNumber.length>58 || partNumber in Product.getPartNumber()){
            return false
        }
        return true
    }
    fun getPrice(): Long {
        var price:String?
        val p:Long
        while (true) {
            print("Введите цену продукта >>> ")
            price= readLine()
            if (validPrice(price)) {
                p=price!!.toLong()
                break
            }
            println("Цена продукта должна быть целым числом большим нуля")
        }
        return p
    }
    fun validPrice(price:String?): Boolean {
        if (price==null)
            return false
        try {
            if (price.toLong()<1)
                return false
            return true
        } catch (e: NumberFormatException){
            return false
        }
    }
    fun getY(): Long {
        var coordinatesY:String?
        val cY:Long
        while (true) {
            print("Введите координату y продукта >>> ")
            coordinatesY= readLine()
            if (validY(coordinatesY)) {
                cY = coordinatesY!!.toLong()
                break
            }
            println("\nКоордината y должна быть целым числом")
        }
        return cY
    }
    fun validY(y:String?): Boolean {
        if (y==null)
            return false
        try {
            y.toLong()
            return true
        } catch (e: NumberFormatException){
            return false
        }
    }
    fun getX(): Int {
        var coordinatesX:String?
        val cX:Int
        while (true) {
            print("Введите координату x продукта >>> ")
            coordinatesX= readLine()
            if (validX(coordinatesX)) {
                cX = coordinatesX!!.toInt()
                break
            }
            println("\nКоордината x должна быть целым числом меньшим 937")
        }
        return cX
    }
    fun validX(x:String?): Boolean {
        if (x==null)
            return false
        try {
            if (x.toInt()>936)
                return false
            return true
        } catch (e: NumberFormatException){
            return false
        }
    }
    fun getName(): String {
        var name:String?
        while (true) {
            print("Введите название продукта >>> ")
            name= readLine()
            if (validName(name))
                break
            println("\nНеккоректное название продукта")
        }
        return name!!
    }
    fun validName(name:String?):Boolean{
        if (name==null || name=="")
            return false
        return true
    }

    fun checkExecuteScript(s: String): Boolean {
        val path=Paths.get(s)
        return Files.notExists(path)
    }

    fun checkId(s: String): Boolean {
        return try {
            if (s.toInt()>0)
                return true
            false
        } catch (e: NumberFormatException){
            false
        }
    }
}