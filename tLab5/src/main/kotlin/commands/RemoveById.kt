package commands

import product.Product

class RemoveById(val collection: MutableList<Product>,private val args:Array<Long>) :Command {
    override val name: String="remove_by_id"
    override fun execute(): Information {
        if (!(validator(args[0])))
            return Information("Нет элемента с таким Id",1)
        return try {
             collection.removeIf{ it.getId() == args[0] }
             Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }

    /*fun execute(id:Long):Information{
        if (validator(id))
            return Information("Элемент с таким значением id не найден",1)
        return try {
            for (obj in collection){
                if (obj.getId()==id){
                    obj.removeFrompN(obj.getPartNumber())
                    collection.remove(obj)
                }
            }
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }*/
    private fun validator(id:Long):Boolean{
        for (o in collection){
            if (o.getId()==id) {
                return true
            }
        }
        return false
    }
    /*override fun Execute(element: String?, collection: MutableList<Product>) {
        for (obj in collection){
            if (obj.getId()==id){
                obj.removeFrompN(obj.getPartNumber())
                collection.remove(obj)
                return
            }
        }
        println("ОбЪект с таким значением поля \"id\" не найден. Коллекция не была изменена")
    }
    override fun Check(command: String): String {
        val s=command.split(Pattern.compile("\\s"),limit=2)
        try {
            if (s[1].toLong() >0){
                id=s[1].toLong()
                return "0"
            }
            return "Id не может быть меньше 1"
        } catch (e: NumberFormatException){
            return "Id введен некорректно. Повторите ввод"
        }
    }
    companion object{
        var id:Long=1
    }*/
}