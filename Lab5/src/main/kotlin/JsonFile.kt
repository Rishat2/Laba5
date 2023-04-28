import product.Product
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import java.io.BufferedOutputStream
import java.io.FileInputStream
import java.io.FileOutputStream

class JsonFile() {
    fun encodeAndWrite(deque:MutableList<Product>, NameFile:String):String{
        val j: String= Json.encodeToString(deque)
        val path=System.getenv(NameFile)
        val oS= FileOutputStream(path)
        val bfS= BufferedOutputStream(oS)
        bfS.write(j.toByteArray())
        bfS.close()
        return j
    }
    fun decodeAndRead(NameFile:String):MutableList<Product>{
        val path=System.getenv(NameFile)
        val iS= FileInputStream(path)
        val deque1  =Json.decodeFromStream<MutableList<Product>>(iS)
        return deque1
    }
    fun sort(list: MutableList<Product>): MutableList<Product> {
        return list.sortedBy { it.getprice() } as MutableList<Product>
    }
}
