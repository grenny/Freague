package com.freague



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Team)
class TeamTests {

    void testConstraints() {
        def existingTeam = new Team( name: "Team Name")
        mockForConstraintsTests( Team, [existingTeam] )
        
        // validation should fail if name is null
        def team = new Team()
        assert !team.validate()
        assert "nullable" == team.errors["name"]
        
        // validation should fail if name is blank
        team = new Team( name: "" )
        assert !team.validate()
        assert "blank" == team.errors["name"]
        
        // validation should fail if name is < 2 characters
        team = new Team( name: "1")
        assert !team.validate()
        assert "size" == team.errors["name"]
        
        // validation should fail if name is > 150 characters
        String longName = (0..150).flatten().toString()
        team = new Team( name: longName[0..150] )
        assert !team.validate()
        assert "size" == team.errors["name"]
        
        // validation should pass if name is > 1 & < 151
        team = new Team( name: "12" )
        assert team.validate()
       
        team = new Team( name: longName[0..149] )
        assert team.validate()
    }
}
