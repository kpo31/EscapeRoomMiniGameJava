
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (DraggableThing.java)
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
public class DraggableThing extends VisibleThing {

  private boolean mouseWasPressed; // similar to use in ClickableThing
  private boolean isDragging; // true when this object is being dragged by the user
  private int oldMouseX; // horizontal position of mouse during last update
  private int oldMouseY; // vertical position of mouse during last update

  /**
   * the constructor for the draggable thing
   * 
   * @param name - name of the thing
   * @param x    - the x coordinate
   * @param y    - the y coordinate
   */
  public DraggableThing(String name, int x, int y) {
    super(name, x, y);//// uses the constructor to make the object
    isDragging = false;
    mouseWasPressed = false;

  } // initialize new thing

  @Override
  /**
   * update the thing
   */
  public Action update() {
    Action retValue = super.update();

    if (!(mouseWasPressed) && isOver(Thing.getProcessing().mouseX, Thing.getProcessing().mouseY)
        && Thing.getProcessing().mousePressed) {// checks the position over the target
      mouseWasPressed = true;
      isDragging = true;
      oldMouseX = getProcessing().mouseX;// initialize the old pos y
      oldMouseY = getProcessing().mouseY;// initialize the old pos y


    } else if (!getProcessing().mousePressed) {// if the mouse is not pressed sets the fields and
                                               // calls drop
      mouseWasPressed = false;
      isDragging = false;
      retValue = drop();
    }

    if (mouseWasPressed && isDragging) {// if thing is selected and dragged
      super.move(Thing.getProcessing().mouseX - oldMouseX,
          Thing.getProcessing().mouseY - oldMouseY);// moves the thing and then update the old pos
      oldMouseX = getProcessing().mouseX;
      oldMouseY = getProcessing().mouseY;
    }

    return retValue;

  } // calls VisibleThing update(), then moves according to mouse drag
  // each time isDragging changes from true to false, the drop() method below will be called once
  // and any action objects returned from that method should then be returned from update()

  protected Action drop() {
    return null;
  } // this method returns null
  // subclass types will override this drop() method to do more interesting things


}
