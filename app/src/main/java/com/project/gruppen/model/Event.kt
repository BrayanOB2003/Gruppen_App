package com.project.gruppen.model

import com.project.gruppen.model.enumerations.Frequency
import java.util.Date

data class Event(
    var name: String,
    var description: String,
    var initialDate: Date,
    var finalDate:Date,
    var frequency: Frequency)