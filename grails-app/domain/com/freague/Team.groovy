package com.freague

class Team {

    String name
    Date dateCreated
    Date lastUpdated
    
    static constraints = {
        name size: 2..150, blank: false
    }
}
