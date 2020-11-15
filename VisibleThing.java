
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (VisibleThing.java)
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
import processing.core.PImage;
import java.io.File;

public class VisibleThing extends Thing {
  private PImage image; // the graphical representation of this thing
  private int x; // the horizontal position (in pixels of this thing's left side)
  private int y; // the vertical position (in pixels of this thing's top side)

  /**
   * the constructor
   * 
   * @param name - the name
   * @param x    - the x coordinate
   * @param y    - the y coordinate
   */
  public VisibleThing(String name, int x, int y) {
    super(name);
    this.image = getProcessing().loadImage("images" + File.separator + name + ".png");
    this.x = x;
    this.y = y;
  } // initialize this new thing
  // the image for this visible thing should be loaded from :
  // "images"+File.separator+ name +".png"

  @Override
  public Action update() {
    Thing.getProcessing().image(image, x, y);
    return null;

  } // draws image at its position before returning null

  /**
   * moves the thing
   * 
   * @param dx - the distance to be moved by in x
   * @param dy - the distance to be moved by in y
   */
  public void move(int dx, int dy) {
    x += dx;
    y += dy;
  } // changes x by adding dx to it (and y by dy)

  /**
   * checks if the thing is over
   * 
   * @param x - the pos to check with in x
   * @param y - the pos to check with in y
   * @return - true if yes false if not.
   */
  public boolean isOver(int x, int y) {
    if (this.x + image.width < x || x < this.x) {// checks the width
      return false;
    }
    if (this.y + image.height < y || y < this.y) {// checks the height
      return false;
    }
    return true;
  } // return true only when point x,y is over image

  /**
   * checks if the thing is on another thing
   * 
   * @param other - the thing to check with
   * @return - true if is over false if not
   */
  public boolean isOver(VisibleThing other) {

    return other.isOver(x, y);
  } // return true only when other's image overlaps this one's

}
