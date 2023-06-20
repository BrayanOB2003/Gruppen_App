package com.project.gruppen.model

import com.project.gruppen.model.enumerations.Roles
import com.project.gruppen.model.interfaces.HomeOperations

class HomeService : HomeOperations{

    override fun createGroup(id: String, name: String, description: String, user: User,
                             groups: MutableList<Group>) {
        val leader: Member = user as Member
        leader.role = Roles.LEADER
        val leaders: MutableList<Member> = ArrayList()
        leaders.add(leader)
        groups.add(Group(id, name, description, leaders))
    }

    override fun enterTheGroupRoom(group: Group): GroupRoom {
        return GroupRoom(group)
    }
}