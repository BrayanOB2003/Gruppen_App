package com.project.gruppen.model

import com.project.gruppen.model.enumerations.Frequency

open class Message (
    var title: String,
    var content: String,
    var dateAndHour: String,
    var frequency: Frequency
)