package shape;

/**
 * Class Rectangle
 *
 * Représente un rectangle défini par un point d'origine, une largeur et une hauteur.
 * Hérite de la classe Shape.
 *
 * Propriétés spécifiques :
 * - p1 : le point correspondant au coin supérieur gauche du rectangle
 * - width : la largeur du rectangle
 * - height : la hauteur du rectangle
 *
 * Implémente draw() pour effectuer le rendu du rectangle sur une zone de pixels.
 */
public class Rectangle extends Shape {

/** Le coin supérieur gauche du rectangle. */
private Point p1;

/** La largeur du rectangle (axe X). */
private int width;

/** La hauteur du rectangle (axe Y). */
private int height;
 
  /**
   * Constructeur du rectangle.
   * @param p1 Le coin supérieur gauche.
   * @param width La largeur.
   * @param height La hauteur.
   */
  public Rectangle(Point p1, int width, int height) {
    super(IdCounter.getInstance().getNextId(), ShapeType.RECTANGLE);
    this.p1 = p1;
    this.width = width;
    this.height = height;
  };
  
  /**
   * Demande à la zone de dessin de tracer les contours de ce rectangle.
   * @param area La zone de dessin (Area) où le rectangle doit être rendu.
   */
    public void draw(Area area) {
        area.drawRectangle(p1, width, height);
    }

  /**
   * Définit le point d'origine du rectangle.
   * @param newVar le nouveau coin supérieur gauche.
   */
  public void setP1 (Point newVar) {
    p1 = newVar;
  }

  /**
   * Récupère le point d'origine du rectangle.
   * @return le point p1.
   */
  public Point getP1 () {
    return p1;
  }

  /**
   * Définit la largeur du rectangle.
   * @param newVar la nouvelle largeur.
   */
  public void setWidth (int newVar) {
    width = newVar;
  }

  /**
   * Récupère la largeur du rectangle.
   * @return la largeur en pixels.
   */
  public int getWidth () {
    return width;
  }

  /**
   * Définit la hauteur du rectangle.
   * @param newVar la nouvelle hauteur.
   */
  public void setHeight (int newVar) {
    height = newVar;
  }

  /**
   * Récupère la hauteur du rectangle.
   * @return la hauteur en pixels.
   */
  public int getHeight () {
    return height;
  }

  /**
   * Retourne une représentation textuelle des dimensions et de la position du rectangle.
   * @return Une chaîne de caractères listant p1, la largeur et la hauteur.
   */
  public String print()
  {
    return "p1 : " + p1.print() + "\nwidth : " + width + "\nheight : " + height;
  }
}