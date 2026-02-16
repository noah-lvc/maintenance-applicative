package shape;


/**
 * Class Curve
 */
public class Curve extends Shape {

  //
  // Fields
  //

  private ArrayList<Point> points;
  private shape.Point new_attribute;
  
  //
  // Constructors
  //
  public Curve () { };
  
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

  /**
   * Set the value of new_attribute
   * @param newVar the new value of new_attribute
   */
  public void setNew_attribute (shape.Point newVar) {
    new_attribute = newVar;
  }

  /**
   * Get the value of new_attribute
   * @return the value of new_attribute
   */
  public shape.Point getNew_attribute () {
    return new_attribute;
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
