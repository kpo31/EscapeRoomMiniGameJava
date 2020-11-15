
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Action.java)
// Files: (EscapeRoom.java, Action.java, Thing.java, VisibleThing.java, ClickableThing.java,
//////////////////// DarggableThing.java, DragAndDroppableThing.java)
// Course: (CS 300 Spring 2019)
//
// Author: (Mihir Khatri)
// Email: (mkhatri@wisc.edu)
// Lecturer's Name: (Mouna Kacem)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.ArrayList;

public class Action {
  private Thing thing;
  private String message; // message printed by this action (or null to do nothing)

  /**
   * sets the message
   * 
   * @param message - the message
   */
  public Action(String message) {
    this.message = message;
  } // initialize this new action

  /**
   * set the thing
   * 
   * @param thing - the thing
   */
  public Action(Thing thing) {
    this.thing = thing;
  }

  /**
   * sets the message and string
   * 
   * @param message - the message
   * @param thing   - the thing
   */
  public Action(String message, Thing thing) {
    this.message = message;
    this.thing = thing;
  }

  /**
   * adds the thing and activate it
   * 
   * @param arrList - the array list
   */
  public void act(ArrayList<Thing> arrList) {
    if (message != null) {
      System.out.println(message);// if not null print the message
    }
    arrList.add(thing);
    thing.activate();
    thing = null;// activates it adds it and sets it to null

  } // when message is not null, message is printed to System.out
}
