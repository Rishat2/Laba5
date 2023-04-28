package product

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
 class Organization() {
    constructor(_name:String, _annualTurnover:Long, _employeesCount:Long, _fullname: String?, _type: OrganisationType?):this(){
        name=_name
        annualTurnover=_annualTurnover
        employeesCount=_employeesCount
        fullname=_fullname
        type=_type
        id= c++.toLong()
    }
    @Transient private var id: Long=1
    private var name: String="undefined"
        set(value) {
            if(value!="")
                field=value
        }
    private  var fullname: String? =null
    private var annualTurnover: Long=1
        set(value) {
            if (value > 0)
                field = value
        }
    private var employeesCount:Long=1
        set(value) {
            if(value>0)
                field=value
        }
    private var type: OrganisationType?=null
    companion object{
        private var c:Int=1
    }
    fun getName(): String {
        return name
    }
    fun getAnnualTurnOver(): Long {
        return annualTurnover
    }
    fun getEmployeesCount(): Long {
        return employeesCount
    }
    fun getType(): OrganisationType? {
        return type
    }
    fun getFullname(): String? {
        return fullname
    }
}