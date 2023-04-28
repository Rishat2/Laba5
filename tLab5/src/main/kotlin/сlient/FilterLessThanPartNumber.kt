package сlient

import commands.Information
import Console

class FilterLessThanPartNumber(private val args:Array<String>):Client {
    override val name: String="filter_less_than_part_number"
    override fun check(command: String): Information {
        val console=Console()
        if(console.validPartNumber(console.getArgs(command))) {
            args[0]=console.getArgs(command)
            return Information("Ok", 0)
        }
        return Information("В номере части должно не меньше 13 и не больше 58 символов",1)
    }
}