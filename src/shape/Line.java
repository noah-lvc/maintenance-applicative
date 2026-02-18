package shape;

import java.util.*;

/**
 * Class Line
 *
 * Représente une ligne composée d'une suite de points.
 * Hérite de Shape.
 *
 * Propriétés spécifiques :
 *  - points : liste de Point composant la ligne
 *
 * Implémente draw() pour dessiner la ligne (affiche nombre de points pour simulation).
 */
public class Line extends Shape {

  //
  // Fields
  //

  private Point p1;
  private Point p2;
  
  //
  // Constructors
  //
  public Line(Point p1, Point p2) {
    super(IdCounter.getInstance().getNextId(), ShapeType.LINE);
    this.p1 = p1;
    this.p2 = p2;
  }
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

    public void draw(Area area) {
        area.drawLine(p1, p2);
    }

  /**
   * Set the value of p1
   * @param newVar the new value of p1
   */
  public void setP1 (Point newVar) {
    p1 = newVar;
  }

  /**
   * Get the value of p1
   * @return the value of p1
   */
  public Point getP1 () {
    return p1;
  }

  /**
   * Set the value of p2
   * @param newVar the new value of p2
   */
  public void setP2 (Point newVar) {
    p2 = newVar;
  }

  /**
   * Get the value of p2
   * @return the value of p2
   */
  public Point getP2 () {
    return p2;
  }

  //
  // Other methods
  //

  /**
   * @return
   */
  public String print()
  {
    return "points :\np1 : " + p1.print() + "\np2 : " + p2.print();
  }


}