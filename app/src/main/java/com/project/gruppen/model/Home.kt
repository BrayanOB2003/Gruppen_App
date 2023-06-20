package com.project.gruppen.model

class Home(private val currentUser: User) {

    private val groups: MutableList<Group> = ArrayList()
    private val homeService = HomeService()
    private lateinit var groupRoom: GroupRoom

    fun createGroup(id:String, name: String, description: String){
        homeService.createGroup(id, name, description, currentUser, groups)
    }

    fun enterTheGroupRoom(group: Group) {
        groupRoom = homeService.enterTheGroupRoom(group)
    }
}