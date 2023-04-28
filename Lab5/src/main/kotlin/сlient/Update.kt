package сlient

import commands.Information
import Console
import product.Product

class Update(private val args1:Array<Long>,private val args2:Array<Product>):Client {
    override val name: String="update"

    override fun check(command: String): Information {
        val console=Console()
        if (console.checkId(console.getArgs(command))){
            args1[0]=console.getArgs(command).toLong()
            args2[0]=console.getElement()
            return Information("Ok",0)
        }
        return Information("Id должно быть натуральным числом",1)
    }
}