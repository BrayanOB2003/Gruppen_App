package com.project.gruppen.model.interfaces

import com.project.gruppen.model.Group
import com.project.gruppen.model.GroupRoom
import com.project.gruppen.model.User

interface HomeOperations {
    fun createGroup(id: String, name: String, description: String, leader: User,
                    groups: MutableList<Group>)

    fun enterTheGroupRoom(group: Group): GroupRoom
}