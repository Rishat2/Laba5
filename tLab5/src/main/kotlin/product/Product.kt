package product

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import java.time.ZonedDateTime

@Serializable
class Product(){
    constructor(name: String, price: Long, _coordinates: Coordinates, _unitofMeasure: UnitofMeasure, _manufacturer: Organization, _partNumber: String):this(){
        this.name=name
        this.price=price
        creationDate= ZonedDateTime.now()
        coordinates=_coordinates
        unitofMeasure=_unitofMeasure
        manufacturer=_manufacturer
        initPartNumber(_partNumber)
    }
    @Transient private var id: Long =c++

     private var name: String="undefined"
       set(value) {
            if(value!="")
                field=value
        }
    private lateinit var  coordinates: Coordinates
    @Transient private lateinit var creationDate: ZonedDateTime
    private var price: Long=1 //internal
        set(value) {
            if(value>0)
                field=value
        }
        get() {return field}
    private lateinit var partNumber: String
    private lateinit var unitofMeasure: UnitofMeasure
    private lateinit var manufacturer: Organization
    companion object{
        val Date:ZonedDateTime= ZonedDateTime.now()
        private var c: Long=0
        private var pN : ArrayList<String> = arrayListOf()
        fun clear(){
            pN.clear()
        }
        fun getPartNumber(): ArrayList<String> {
            return pN
        }
    }
    fun initPartNumber(_partNumber:String):Unit{
        if(_partNumber.length>=13&&_partNumber.length<=58&&_partNumber !in pN){
            partNumber=_partNumber
            pN.add(_partNumber)
        }
    }
    fun getPartNumber():String{
        return partNumber
    }


    fun getprice(): Long {
        return price
    }
    fun getId(): Long {
        return id
    }
    fun getManufacturer(): Organization {
        return manufacturer
    }
    fun EqualsByManufacturer(manufacturer: Organization):Boolean{
        if (manufacturer.getName()==getManufacturer().getName() && (manufacturer.getFullname()==getManufacturer().getFullname() || (manufacturer.getFullname()==null && getManufacturer().getFullname()==null)) && (manufacturer.getType()==getManufacturer().getType() || (manufacturer.getType()==null && getManufacturer().getType()==null)) && manufacturer.getEmployeesCount()==getManufacturer().getEmployeesCount() && manufacturer.getAnnualTurnOver()==getManufacturer().getAnnualTurnOver()){
            return true
        }
        return false
    }
    fun removeFrompN(partNumber: String){
        pN.remove(partNumber)
    }
    fun comparison(obj:Product):Boolean{
        if (getprice()<obj.getprice()){
            return true
        }
        return false
    }

    override fun toString(): String {
        return "id: ${id}\n" +
                "name: $name\n" +
                "coordinates: \n" +
                "x: ${coordinates.getX()}\n" +
                "y: ${coordinates.getY()}\n" +
                "price: $price\n" +
                "partNumber: $partNumber\n" +
                "unitOfMeasure: $unitofMeasure\n" +
                "manufacturer:\n" +
                "name: ${manufacturer.getName()}\n" +
                "fullname: ${manufacturer.getFullname()}\n" +
                "annualTurnOver: ${manufacturer.getAnnualTurnOver()}\n" +
                "EmployeesCount: ${manufacturer.getEmployeesCount()}\n" +
                "Type: ${manufacturer.getType()}\n"

    }
}