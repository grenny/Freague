package com.freague.team



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(TeamMember)
class TeamMemberTests {

    
    protected Team setUpTeam() {
        mockDomain( Team )
        Team team = new Team()
        team.save()
        return team
    }
    
    protected Person setUpPerson() {
        mockDomain( Person )
        Person person = new Person()
        person.save() 
        return person
    }
    
    void testCreateTeamMember() {       
        TeamMember teamMember = new TeamMember()
        teamMember.member = this.setUpPerson()
        teamMember.team = this.setUpTeam()
        teamMember.save()
        assert !teamMember.hasErrors()
        assert TeamMember.count() == 1
    }
    
    void testCannotCreateTeamMemberBecauseOfMissingPerson() {
        TeamMember teamMember = new TeamMember()
        teamMember.team = this.setUpTeam()
        teamMember.save()
        assert teamMember.hasErrors()
        assert "nullable" == teamMember.errors["member"].code
    }
    
    void testCannotCreateTeamMemberBecauseOfMissingTeam() {
        TeamMember teamMember = new TeamMember()
        teamMember.member = this.setUpPerson()
        teamMember.save()
        assert teamMember.hasErrors()
        assert "nullable" == teamMember.errors["team"].code
    }
    
    void testCannotCreateTeamMember() {
        TeamMember teamMember = new TeamMember()
        teamMember.save()
        assert teamMember.hasErrors()
        assert "nullable" == teamMember.errors["team"].code
        assert "nullable" == teamMember.errors["member"].code
    }
}
