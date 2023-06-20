package com.project.gruppen.model

import com.project.gruppen.model.enumerations.Frequency

class Reminder(title: String, content: String, dateAndHour: String) :
    Message(title, content, dateAndHour, Frequency.INSTANT)