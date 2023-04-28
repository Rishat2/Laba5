package сlient

import commands.Information
import Console
import product.Product

class RemoveLower(private val args:Array<Product>):Client {
    override val name: String="remove_lower"
    override fun check(command: String): Information {
        if (command==name){
            val console=Console()
            args[0]=console.getElement()
            return Information("Ok",0)
        }
        return Information("У этой команды нет примитивных аргументов. Возможно вы имели в виду \"$name\"",1)
    }

}