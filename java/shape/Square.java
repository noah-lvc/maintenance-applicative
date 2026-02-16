package shape;

import java.util.*;


/**
 * Class Square
 */
public class Square extends Shape {

  //
  // Fields
  //

  private int length;
  private shape.Point points;
  
  //
  // Constructors
  //
  public Square () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of length
   * @param newVar the new value of length
   */
  public void setLength (int newVar) {
    length = newVar;
  }

  /**
   * Get the value of length
   * @return the value of length
   */
  public int getLength () {
    return length;
  }

  /**
   * Set the value of points
   * @param newVar the new value of points
   */
  public void setPoints (shape.Point newVar) {
    points = newVar;
  }

  /**
   * Get the value of points
   * @return the value of points
   */
  public shape.Point getPoints () {
    return points;
  }

  //
  // Other methods
  //

  /**
   * @return       String
   */
  public String toString()
  {
  }


}
