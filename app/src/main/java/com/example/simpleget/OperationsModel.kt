package com.example.simpleget

data class OperationsModel (var name:String, var email:String)
{
    fun getname(): String {
        return name
    }
    fun getemail(): String {
        return email
    }
    fun setname(name: String) {
        this.name=name
    }
    fun setemail(email: String) {
        this.email=email
    }


}





