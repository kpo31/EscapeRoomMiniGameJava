
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (ClickableThing.java)
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

public class ClickableThing extends VisibleThing {
  private Action action; // action returned from update when this object is clicked
  private boolean mouseWasPressed; // tracks whether the mouse was pressed during the last update()

  /**
   * constructor for the clickable thing
   * 
   * @param name   - the name of the thing
   * @param x      - the x coordinate
   * @param y      - the y coordinate
   * @param action - the action to be done
   */
  public ClickableThing(String name, int x, int y, Action action) {
    super(name, x, y);// initializes everything with the supers constructors help
    this.action = action;
    mouseWasPressed = false;
  } // initializes this new object

  @Override
  /**
   * updates the pos
   */
  public Action update() {
    Action retValue = super.update();
    boolean isOver = super.isOver(Thing.getProcessing().mouseX, Thing.getProcessing().mouseY);

    if (!(mouseWasPressed) && getProcessing().mousePressed && isOver) {// checks if the mouse is
                                                                       // pressed and over the thing
      mouseWasPressed = true;
      retValue = action;
    } else if (mouseWasPressed) {// if the mouse is pressed
      mouseWasPressed = getProcessing().mousePressed;
      return retValue;
    } else if (!(getProcessing().mousePressed)) {// if the mouse is not pressed
      mouseWasPressed = false;
    }

    return retValue;
  } // calls VisibleThing update, then returns action only when mouse is first
    // clicked

}
