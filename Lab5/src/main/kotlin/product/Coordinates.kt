package product

import kotlinx.serialization.Serializable

@Serializable
public class Coordinates() {
    constructor(_x:Int,_y:Long):this(){
        x=_x
        y=_y
    }
    private var x:Int=0
        set(value) {
            if(value<=936){
                field=value
            }
        }
    private var y: Long=0
    fun getX(): Int {
        return x
    }
    fun getY(): Long {
        return y
    }
}