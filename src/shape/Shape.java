package shape;

/**
 * Class Shape
 *
 * <<abstract>>
 * 
 * Classe de base abstraite pour toutes les formes géométriques.
 * Définit les propriétés communes :
 *  - id : identifiant unique
 *  - fill : si la forme est remplie
 *  - thickness : épaisseur du contour
 *  - rotation : angle de rotation
 * 
 * Fournit une méthode abstraite draw() que toutes les sous-classes doivent implémenter.
 * Fournit également un toString() générique.
 */

import shape.ShapeType;

import java.util.*;
abstract public class Shape  {

   private int id;
    private ShapeType type;
    private String color;
    private float thickness;
    private float rotation;
    private boolean fill;

    public Shape(int id, ShapeType type) {
        this.id = id;
        this.type = type;
        this.color = "BLACK";
        this.thickness = 1.0f;
        this.rotation = 0.0f;
        this.fill = false;
    }

    public abstract void draw(Area area);


    public abstract String print();

    /**
     * Set the value of id
     * @param newVar the new value of id
     */
    public void setId(int newVar) {
        id = newVar;
    }

    /**
     * Get the value of id
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of fill
     * @param newVar the new value of fill
     */
    public void setFill(boolean newVar) {
        fill = newVar;
    }

    /**
     * Get the value of fill
     * @return the value of fill
     */
    public boolean getFill() {
        return fill;
    }

    /**
     * Set the value of color
     * @param newVar the new value of color
     */
    public void setColor(String newVar) {
        color = newVar;
    }

    /**
     * Get the value of color
     * @return the value of color
     */
    public String getColor() {
        return color;
    }

  //
  // Other methods
  //

  /**
   * @return String
   */
  public String toString(){

    return "Unknown shape";
  }
}