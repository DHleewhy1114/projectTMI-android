package com.example.dh_lee.projecttmi

//http통신시 데이터 파싱을 위한 인터페이스

interface HTTPResponseData{
    val id:String//각 통신시 기본적으로 필요한 id

}

data class TimelineResponseData(
        override val id:String, val author:String,val contents:String,val created:String,val islikeit:String):HTTPResponseData

data class MatchingResponseData(
        override val id:String,val title:String, val participant_number:String,val total_participant:String,val place:String,val date:String):HTTPResponseData

data class WriteTimelineResponseData(
        override val id: String,val author:String,val profile_image:String,val create:String)
:HTTPResponseData