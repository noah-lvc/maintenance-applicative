package shape;

import java.util.*;


/**
 * Class Line
 */
public class Line extends Shape {

  //
  // Fields
  //

  private ArrayList<Point> points;
  
  //
  // Constructors
  //
  public Line () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of points
   * @param newVar the new value of points
   */
  public void setPoints (ArrayList<Point> newVar) {
    points = newVar;
  }

  /**
   * Get the value of points
   * @return the value of points
   */
  public ArrayList<Point> getPoints () {
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


  /**
   * @param        p1
   * @param        p2
   */
  public void Line(shape.Point p1, shape.Point p2)
  {
  }


}
