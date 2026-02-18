package shape;

import shape.IdCounter;
import shape.ShapeType;

import java.awt.*;
import java.util.*;


/**
 * Class Square
 *
 * Représente un carré (spécialisation d'un rectangle).
 * Hérite de Shape.
 *
 * Propriétés spécifiques :
 *  - length : longueur du côté
 *
 * Implémente draw() pour dessiner le carré (affiche longueur du côté).
 */
public class Square extends Shape {

  //
  // Fields
  //

  private Point p1;
  private int length;
  
  //
  // Constructors
  //
  public Square(Point p1, int length) {
    super(IdCounter.getInstance().getNextId(), ShapeType.SQUARE);
    this.p1 = p1;
    this.length = length;
  }

  
  //
  // Methods
  //


  //
  // Accessor methods
  //
  public void draw(Area area) {
      area.drawSquare(p1, length);
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

  //
  // Other methods
  //

  /**
   * @return
   */
  public String print()
  {
    return "p1 : " + p1.print() + "\nlength : " + length;
  }
}