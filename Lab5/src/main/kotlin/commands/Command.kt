package commands

interface Command {
    val name: String
    fun execute(): Information {
        return Information("", -1)
    }
}

/*interface Validator{
    fun validate()
}

class MyCommand{

    private object MyCommandValidator : Validator {
        override fun validate() {
            TODO("Not yet implemented")
        }

    }

}*/
