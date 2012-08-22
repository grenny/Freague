package com.freague

import grails.converters.JSON
import com.freague.team.Team
import com.freague.team.Person
import com.freague.team.TeamMember

class TeamController {

    def show() { 
        Team team = new Team( name: "${new Date()}").save()
        TeamMember teamMember = new TeamMember()
        Person person = new Person( name: "Grenville" ).save()
        teamMember.team = team
        teamMember.member = person
        teamMember.save()
        render team as JSON
    }
}
