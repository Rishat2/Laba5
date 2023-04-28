package commands

import Console
import InitMap
import product.*
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class ExecuteScript (private val args:Array<String>,private val collection:MutableList<Product>):Command {
    private var coll= collection.toMutableList()
    override val name: String = "execute_script"
    private val simpleCommand= arrayOf("help","info","print_ascending","show")
    private val noArgsCommand= arrayOf("clear","save","remove_last","sort")
    private val primitiveArgsCommand= arrayOf("filter_less_than_part_number","remove_by_id")
    private val commandsWithElement= arrayOf("add","remove_lower")
    private val comands= arrayOf("filter_less_than_part_number","exit","remove_by_id","execute_script","add","remove_lower","clear","save","remove_last","sort","help","info","print_ascending","show","update","remove_all_by_manufacturer")
    private val scripts=ArrayList<String>()
    override fun execute(): Information {
        val fileName = args[0]
        if (fileName in scripts)
            return Information("Обнаружено зацикливание",1)
        scripts.add(fileName)
        try {
            val sc = Scanner(File(fileName))
            val obj=InitMap(collection[0])
            val commands = obj.initialMap(coll)
            val client=obj.initialMapClient()
            var reply=""
            val console=Console()
            while (sc.hasNextLine()) {
                val line = sc.nextLine()
                if (!(console.getCommand(line) in comands)){
                    scripts.clear()
                    return Information("Не корректно введена одна из команд",1)
                }
                if (line in simpleCommand){
                    reply+=commands.get(line)!!.execute().getMessage()
                    continue
                }
                else if ( line in noArgsCommand){
                    commands.get(line)!!.execute()
                    continue
                }
                else if (console.getCommand(line) in primitiveArgsCommand){
                    if (!(client.get(console.getCommand(line))!!.check(line).getStatus()==0)) {
                        scripts.clear()
                        return Information("Некорекктно введен аргумент одной из команд", 1)
                    }
                    commands.get(console.getCommand(line))!!.execute()
                    continue
                }
                else if (console.getCommand(line)=="execute_script"){
                    if (!(client.get(console.getCommand(line))!!.check(line).getStatus()==0)) {
                        scripts.clear()
                        return Information("Некорекктно введен аргумент одной из команд", 1)
                    }
                    reply=commands.get(console.getCommand(line))!!.execute().getMessage()
                    continue
                }
                else if (line in commandsWithElement){
                    val elem= arrayListOf<String>()
                    for (i in 1 ..11){
                        if (sc.hasNextLine())
                            elem.add(sc.nextLine())
                    }
                    if (elem.size!=11) {
                        scripts.clear()
                        return Information("Полей элемента меньше, чем должно быть", 1)
                    }
                    if (!validElement(elem)) {
                        scripts.clear()
                        return Information("Не корректно введено одно из полей", 1)
                    }
                    obj.getProduct()[0]=getElement(elem)
                    commands.get(line)!!.execute()
                    continue
                }
                else if (line=="remove_all_by_manufacturer"){
                    val elem= arrayListOf<String>()
                    for (i in 1 ..5){
                        if (sc.hasNextLine())
                            elem.add(sc.nextLine())
                    }
                    if (elem.size!=5) {
                        scripts.clear()
                        return Information("Полей элемента меньше, чем должно быть", 1)
                    }
                    if (!validOrganisation(elem)) {
                        scripts.clear()
                        return Information("Не корректно введено одно из полей", 1)
                    }
                    obj.getManufacturer()[0]=getOrganisation(elem)
                    commands.get(line)!!.execute()
                    continue
                }
                else if (console.getCommand(line)=="update"){
                    if (!(client.get(console.getCommand(line))!!.check(line).getStatus()==0)) {
                        scripts.clear()
                        return Information("Некорректно введен аргумент одной из команд", 1)
                    }
                    val elem= arrayListOf<String>()
                    for (i in 1 ..5){
                        if (sc.hasNextLine())
                            elem.add(sc.nextLine())
                    }
                    if (elem.size!=11) {
                        scripts.clear()
                        return Information("Полей элемента меньше, чем должно быть", 1)
                    }
                    if (!validElement(elem)) {
                        scripts.clear()
                        return Information("Не корректно введено одно из полей", 1)
                    }
                    obj.getProduct()[0]=getElement(elem)
                    commands.get(line)!!.execute()
                    continue
                }
                else if (line=="exit"){
                    assignment(coll)
                    if (reply!="") {
                        scripts.clear()
                        return Information(reply, -1)
                    }
                    scripts.clear()
                    return Information("Команда выполнена успешно",-1)
                }
            }
            scripts.removeAt(scripts.size-1)
            assignment(coll)
            //if (reply!="")
                return Information(reply,0)
            //return Information("Команда выполнена успешно",0)
        } catch (e: IOException) {
            return Information("Что-то пошло не так",1)
        }
        catch(e: FileNotFoundException){
            return Information("Файл найти не удалось",1)
        }
    }
    fun assignment(coll:MutableList<Product>){
        collection.clear()
        for(o in coll){
            collection.add(o)
        }
    }
    fun validElement(elem:ArrayList<String>): Boolean {
        val console=Console()
        if (console.validName(elem[0]) && console.validX(elem[1]) && console.validY(elem[2]) && console.validPrice(elem[4]) && console.validPartNumber(elem[3]) && console.validUnitOfMeasure(elem[5]) && console.validManufacturerName(elem[6]) && console.validAnnualTurnover(elem[7]) && console.validEmployeesCount(elem[8]) && console.validManufacturerType(elem[10]))
            return true
        return false
    }
    fun validOrganisation(elem:ArrayList<String>): Boolean {
        val console=Console()
        if (console.validManufacturerName(elem[0]) && console.validAnnualTurnover(elem[1]) && console.validEmployeesCount(elem[2]) && console.validManufacturerType(elem[3]))
            return true
        return false
    }
    fun getElement(elem:ArrayList<String>):Product{
        val product=Product(elem[0],elem[4].toLong(), Coordinates(elem[1].toInt(),elem[2].toLong()),getUnitOfMeasure(elem[5]),
            Organization(elem[6],elem[7].toLong(),elem[8].toLong(),elem[10],getOrganizationType(elem[9])),elem[3])
        return product
    }
    fun getOrganisation(elem:ArrayList<String>):Organization {
        val org=Organization(elem[0],elem[1].toLong(),elem[2].toLong(),elem[4],getOrganizationType(elem[3]))
        return org
    }
    fun getUnitOfMeasure(unitOfMeasure:String):UnitofMeasure{
       return when (unitOfMeasure){
            "1" -> UnitofMeasure.PCS
            "2" -> UnitofMeasure.LITERS
           else -> UnitofMeasure.MILLIGRAMS
        }
    }
    fun getOrganizationType(organizationType:String):OrganisationType{
        return when (organizationType){
            "1" -> OrganisationType.COMMERCIAL
            "2" ->  OrganisationType.TRUST
            else ->  OrganisationType.PRIVATE_LIMITED_COMPANY
        }
    }
}