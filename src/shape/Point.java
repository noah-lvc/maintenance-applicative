package shape;

/**
 * Class Point
 *
 * Représente un point 2D dans l'espace.
 * Hérite de Shape pour unifier le polymorphisme avec les autres formes.
 *
 * Propriétés spécifiques :
 *  - pos_x : coordonnée x
 *  - pos_y : coordonnée y
 *
 * Implémente draw() pour dessiner le point (affiche coordonnées).
 */
public class Point extends Shape {

  //
  // Fields
  //

  private int x;
  private int y;
  
  //
  // Constructors
  //
  public Point(int x, int y) {
    super(IdCounter.getInstance().getNextId(), ShapeType.POINT);
    this.x = x;
    this.y = y;
  }


  //
  // Methods
  //


  //
  // Accessor methods
  //
  public void draw(Area area) {
      area.drawPoint(this);
  }

  /**
   * Set the value of x
   * @param newVar the new value of x
   */
  public void setX (int newVar) {
    x = newVar;
  }

  /**
   * Get the value of x
   * @return the value of x
   */
  public int getX () {
    return x;
  }

  /**
   * Set the value of y
   * @param newVar the new value of y
   */
  public void setY (int newVar) {
    y = newVar;
  }

  /**
   * Get the value of y
   * @return the value of y
   */
  public int getY () {
    return y;
  }

  //
  // Other methods
  //

  @Override
  public String print() {
    return "Point(x: " + x + ", y: " + y + ")";
  }
}