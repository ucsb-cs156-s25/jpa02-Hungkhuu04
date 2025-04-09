package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }
    
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void getName_returns_correct_name() {
       assertTrue(team.getName().equals("test-team"));
    }
    //Case 1 Equals
   @Test
    public void testEquals_sameObject_returnsTrue() {
        Team team = new Team("s25-12");
        team.addMember("Hung K");
        assertTrue(team.equals(team), "A team should equal itself");
    }
    //Case 2 Equals
    @Test
    public void testEquals_differentClass_returnsFalse() {
        Team team = new Team("s25-12");
        team.addMember("Hung K");
        String notTeam = "String";
        assertFalse(team.equals(notTeam), "A team should not equal an object of a different type");
    }

    //Case 3 TT Equals
    @Test
    public void testEquals_equalNamesAndMembers_returnsTrue() {
        Team team1 = new Team("s25-12");
        Team team2 = new Team("s25-12");
        team1.addMember("Hung K");
        team2.addMember("Hung K");
        assertTrue(team1.equals(team2), "Teams with same name and members should be equal");
    }
    //Case 3 TF Equals
    @Test
    public void testEquals_equalNamesDifferentMembers_returnsFalse() {
        Team team1 = new Team("s25-12");
        Team team2 = new Team("s25-12");
        team1.addMember("Hung K");
        team2.addMember("Jay J");
        assertFalse(team1.equals(team2), "Teams with same name but different members should not be equal");
    }
    //Case 3 FT Equals
    @Test
    public void testEquals_differentNamesEqualMembers_returnsFalse() {
        Team team1 = new Team("s25-12");
        Team team2 = new Team("s25-99");
        team1.addMember("Hung K");
        team2.addMember("Hung K");
        assertFalse(team1.equals(team2), "Teams with different names but same members should not be equal");
    }
    
    //Case 3 FF Equals
    @Test
    public void testEquals_differentNamesDifferentMembers_returnsFalse() {
        Team team1 = new Team("s25-12");
        Team team2 = new Team("s25-99");
        team1.addMember("Hung K");
        team2.addMember("Jay J");
        assertFalse(team1.equals(team2), "Teams with different names and members should not be equal");
    }

    @Test
    public void hashCode_sameContent_Equal(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
    
    @Test
    public void hashCode_is_implementation_specific_and_expected() {
        Team t = new Team("abc");
        t.addMember("def");
        int result = t.hashCode();
        int expected = 130150;

        assertEquals(expected, result);
    }

}
