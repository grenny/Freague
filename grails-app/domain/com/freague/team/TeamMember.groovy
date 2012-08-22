package com.freague.team

import com.freague.gorm.util.AbstractDomain

class TeamMember extends AbstractDomain {

    Team team
    Person member
    
    static constraints = {
    }
}
