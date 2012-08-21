package com.freague

import grails.converters.JSON

class TeamController {

    def show() { 
        Team team = new Team( name: "${new Date()}")
        render team as JSON
    }
}
