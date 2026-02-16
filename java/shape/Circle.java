package shape;

import java.util.*;


/**
 * Class Circle
 */
public class Circle extends Shape {

  //
  // Fields
  //

  private int radius;
  private shape.Point points;
  
  //
  // Constructors
  //
  public Circle () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of radius
   * @param newVar the new value of radius
   */
  public void setRadius (int newVar) {
    radius = newVar;
  }

  /**
   * Get the value of radius
   * @return the value of radius
   */
  public int getRadius () {
    return radius;
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
