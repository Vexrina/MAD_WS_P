package com.example.shushufood.common

fun isEmailValid(Value: String): Boolean{
    if(Value.isEmpty())
        return false
    if(Value.contains('@')){
        val s1 = Value.substringAfterLast('@')
        val s2 = s1.substringBefore('.')
        val s3 = s1.substringAfter('.')
        if(s3.count()<3 && isLowerCase(s2) && isLowerCase(s3))
            return true
    }
    return false
}
fun isLowerCase(Value: String): Boolean{
    val str = Value.lowercase()
    return str==Value

}