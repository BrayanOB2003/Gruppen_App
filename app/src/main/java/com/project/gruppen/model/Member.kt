package com.project.gruppen.model

import com.project.gruppen.model.enumerations.Roles

class Member(id: String, name: String, email: String) : User(id, name, email) {
    var role: Roles = Roles.MEMBER
}