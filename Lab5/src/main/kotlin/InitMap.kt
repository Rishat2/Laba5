import commands.*
import product.Organization
import product.Product


class InitMap(product:Product) {
    private val id:Array<Long> = arrayOf(0)
    private val product:Array<Product> = arrayOf(product)
    private val manufacturer= arrayOf(Organization("",1,1,null,null))
    private val partNumber= arrayOf("")
    private val filename= arrayOf("")
    fun getId(): Array<Long> {
        return id
    }
    fun getProduct(): Array<Product> {
        return product
    }
    fun getManufacturer(): Array<Organization> {
        return manufacturer
    }
    fun createCommand(collection: MutableList<Product>): MutableList<Command> {
        val add = Add(collection,product)
        val clear = Clear(collection)
        val exit=Exit()
        val filterLessThanPartNumber=FilterLessThanPartNumber(collection,partNumber)
        val help=Help()
        val info=Info(collection)
        val printAscending=PrintAscending(collection)
        val removeAllByManufacturer=RemoveAllByManufacturer(collection,manufacturer)
        val removeById=RemoveById(collection,id)
        val removeLast=RemoveLast(collection)
        val removeLower=RemoveLower(collection,product)
        val save=Save(collection)
        val show=Show(collection)
        val sort=Sort(collection)
        val executeScript=ExecuteScript(filename,collection)
        val update=Update(collection,id,product)
        val list: MutableList<Command> = mutableListOf(add,executeScript, clear,exit,filterLessThanPartNumber,help,info,printAscending,removeAllByManufacturer,removeLast,removeLower,removeById,save,show,sort,update)
        return list
    }

    fun initialMap(collection: MutableList<Product>): MutableMap<String, Command> {
        val map: MutableMap<String, Command> = mutableMapOf()
        val list = createCommand(collection)
        for (i in 1..list.size) {
            map.put(list[i-1].name, list[i-1])
        }
        return map
    }
    fun createCommandClient(): MutableList<сlient.Client> {
        val add = сlient.Add(product)
        val clear = сlient.Clear()
        val executeScript=сlient.ExecuteScript(filename)
        val exit=сlient.Exit()
        val filterLessThanPartNumber=сlient.FilterLessThanPartNumber(partNumber)
        val help=сlient.Help()
        val info=сlient.Info()
        val printAscending=сlient.PrintAscending()
        val removeAllByManufacturer=сlient.RemoveAllByManufacturer(manufacturer)
        val removeById=сlient.RemoveById(id)
        val removeLast=сlient.RemoveLast()
        val removeLower=сlient.RemoveLower(product)
        val save=сlient.Save()
        val show=сlient.Show()
        val sort=сlient.Sort()
        val update=сlient.Update(id,product)
        val list: MutableList<сlient.Client> = mutableListOf(add, clear,executeScript,exit,filterLessThanPartNumber,help,info,printAscending,removeAllByManufacturer,removeLast,removeLower,removeById,save,show,sort,update)
        return list
    }

    fun initialMapClient(): MutableMap<String, сlient.Client> {
        val map: MutableMap<String, сlient.Client> = mutableMapOf()
        val list = createCommandClient()
        for (i in 1..list.size) {
            map.put(list[i-1].name, list[i-1])
        }
        return map
    }
}