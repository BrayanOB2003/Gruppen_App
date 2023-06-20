package com.project.gruppen.model

data class Group(
    val id:String,
    var name: String,
    var description: String,
    var leaders: MutableList<Member>
    )