package com.freague

import com.freague.gorm.util.AbstractDomain

class Team extends AbstractDomain {

    String name
    Date dateCreated
    Date lastUpdated
    
    static constraints = {
        name size: 2..150, blank: false
    }
}
