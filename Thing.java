
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Thing.java)
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
import processing.core.PApplet;

public class Thing {
  private final String NAME; // the constant name identifying this object
  private boolean isActive; // active means thing is visible and can be interacted with
  private static PApplet processing = null;

  /**
   * constructor
   * 
   * @param name - the name of the thing
   */
  public Thing(String name) {
    NAME = name;
    isActive = true;
  } // initialize name, and set isActive to true

  /**
   * checks the name
   * 
   * @param name - the name to be checked with
   * @return
   */
  public boolean hasName(String name) {
    if (NAME.equals(name)) {
      return true;
    }
    return false;
  } // returns true only when contents of name equal NAME

  /**
   * checks if the thing is active
   * 
   * @return true if active false if not
   */
  public boolean isActive() {
    if (isActive == true) {
      return true;
    }
    return false;
  } // returns true only when isActive is true

  /**
   * activate the thing
   */
  public void activate() {
    isActive = true;
  } // changes isActive to true

  /**
   * deactivate the thing
   */
  public void deactivate() {
    isActive = false;
  } // changes isActive to false

  /**
   * overridden in the subclasses.
   * 
   * @return - action
   */
  public Action update() {
    return null;
  } // this method returns null
  // subclass types will override this update() method to do more interesting
  // things


  /**
   * sets the processing
   * 
   * @param processing - used to set the processing
   */
  public static void setProcessing(PApplet processing) {
    Thing.processing = processing;
  } // initializes processing field

  /**
   * gets the processing
   * 
   * @return - processing
   */
  protected static PApplet getProcessing() {
    return processing;
  } // accessor method to retrieve this static field
}
