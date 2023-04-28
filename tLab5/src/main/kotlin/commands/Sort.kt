package commands

import product.Product

class Sort(var collection: MutableList<Product>) :Command {
    override val name: String="sort"
    override fun execute(): Information {
        return try {
            val list:ArrayList<Long> = arrayListOf()
            for(o in collection){
                list.add(o.getprice())
            }
            list.sort()
            var c=-1
            val coll= mutableListOf<Product>()
            for(i in list){
                ++c
                for(o in collection){
                    if (o.getprice()==i){
                        coll.add(o)
                        collection.remove(o)
                        break
                    }
                }
            }
            collection.clear()
            for (o in coll){
                collection.add(o)
            }
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }

    /*fun execute():Information{
        return try {
            collection=collection.sortedBy { it.getprice() } as MutableList<Product>
            Information("Команда выполнена успешно",0)
        }catch (e: Exception){
            Information("Команду выполнить не удалось",1)
        }
    }*/
    /*override fun Execute(element: String?, collection: MutableList<Product>) {
        val json=JsonFile()

    }
    override fun Check(command: String): String {
        if (command == name) {
            return "0"
        }
        return "Нет такой команды, возможно, вы имели в виду команду\"$name\""
    }*/
}