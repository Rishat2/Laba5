package сlient

import commands.Information
import Console
import product.Organization

class RemoveAllByManufacturer(private val args:Array<Organization>):Client {
    override val name: String="remove_all_by_manufacturer"

    override fun check(command: String): Information {
        if (command==name){
            val console=Console()
            args[0]=console.getManufacturer()
            return Information("Ok",0)
        }
        return Information("У этой команды нет примитивных аргументов. Возможно, вы имели в виду \"remove_all_by_manufacturer\"",1)
    }
}