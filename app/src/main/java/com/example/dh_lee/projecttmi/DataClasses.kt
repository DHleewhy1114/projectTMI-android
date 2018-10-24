package com.example.dh_lee.projecttmi

//http통신시 데이터 파싱을 위한 인터페이스

interface HTTPResponseData{
    val id:String//각 통신시 기본적으로 필요한 id

}


data class TimelineResponseData(
        override val id:String, val author:String,val contents:String,val created:String):HTTPResponseData

data class MatchingResponseData(
        override val id:String, val user_id:String):HTTPResponseData



