import commands.Information
import product.*

fun ex(m:Array<Any>):Information{
    return Information("",-1)
}
fun main(args: Array<String>) {
    val obje= Product("1",1, Coordinates(1,1), UnitofMeasure.PCS, Organization("1",1,1,"1", OrganisationType.TRUST),"sdfghjmnbvcdfgdeececv")
    val obj = InitMap(obje)
    //val deque = mutableListOf(
    //Product("bread",30,Coordinates(1,2),UnitofMeasure.MILLIGRAMS,Organization("Karlaman",350,200,null,OrganisationType.TRUST),"aaaaaaaaaaaaaa"),Product("milk",70,Coordinates(2,3),UnitofMeasure.LITERS,Organization("Ufa",700,400,"full",null),"bbbbbbbbbbbbbb"))
    val json = JsonFile()
    //json.EncodeAndWrite(deque,"JSON")
    val deque1: MutableList<Product> = json.decodeAndRead("JSON")
    //deque1=json.sort(deque1)
    //deque1.add(obje)
    val commands = obj.initialMap(deque1)
    val console = Console()
    val client = obj.initialMapClient()
    while (true) {
        print(">>> ")
        val input = readLine()
        if (!(console.check(input!!))) {
            println("Нет такой команды, чтобы узнать какие команды есть введите help")
            continue
        }
        var information = client.get(console.getCommand(input))!!.check(input)
        if (information.getStatus() == 1) {
            println(information.getMessage())
            continue
        }
        information = commands.get(
            console.getCommand(input))!!.execute()
        if (information.getMessage()=="")
            println("Команда выполнена успешно")
        println(information.getMessage())
        if (information.getStatus() == -1) {
            break
        }
        /*val inf: Information = when (console.Check(input)) {
            0 -> commands.get(input)!!.execute()
            1 -> commands.get(input)!!.execute(console.getElement())
            2 -> commands.get(input)!!.execute(console.getManufacturer())
            3 -> commands.get(console.getCommand(input))!!.execute(console.getArgs(input))
            5 -> commands.get(console.getCommand(input))!!.execute(console.getId(input))
            -31 -> Information("Номер части должен быть не меньше 13 и не больше 58", 1)
            -32 -> Information("Id должен быть целым положительным числом", 1)
            4 -> commands.get(input)!!.execute(console.getId(input), console.getElement())
            else -> {
                Information("Нет такой команды повторите ввод", 1)
            }
        }
        if (inf.status == -1) {
            println(inf.message)
            break
        }
        println(inf.message)*/

        /*when (commands.get(console.getCommand(input!!))!!.Check(input)){
        "0" -> commands.get(console.getCommand(input!!))!!.Execute(null,deque1)
        "-1" -> commands.get(console.getCommand(input!!))!!.Execute(console.getElement(),deque1)
        "-2" -> commands.get(console.getCommand(input!!))!!.Execute(console.getManufacturer(),deque1)
        "break" -> break
        else -> println(commands.get(console.getCommand(input!!))!!.Check(input))
    }
    print("\n")
    }*/
        /*val input2="sort"
    if(!console.Check(input)){
        println("Нет такой команды. Повторите ввод")
        //continue
    }
    when (commands.get(console.getCommand(input2!!))!!.Check(input2)){
        "0" -> commands.get(console.getCommand(input2!!))!!.Execute(null,deque1)
        "-1" -> commands.get(console.getCommand(input2!!))!!.Execute(console.getElement(),deque1)
        "-2" -> commands.get(console.getCommand(input2!!))!!.Execute(console.getManufacturer(),deque1)
        //"break" -> break
        else -> println(commands.get(console.getCommand(input2!!))!!.Check(input2))
    }
    print(deque1)
    // }*/
    }
}



