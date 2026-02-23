package shape;

/**
 * Class Square
 *
 * Représente un carré défini par un point d'origine et la longueur de son côté.
 * Hérite de la classe Shape.
 *
 * Propriétés spécifiques :
 * - p1 : le point correspondant au coin supérieur gauche du carré
 * - length : la longueur du côté du carré
 *
 * Implémente draw() pour effectuer le rendu du carré sur une zone de pixels.
 */
public class Square extends Shape {

  /** Le coin supérieur gauche du carré. */
  private Point p1;
  /** La longueur des quatre côtés du carré. */
  private int length;
  
  /**
   * Constructeur du carré.
   * @param p1 Le coin supérieur gauche du carré.
   * @param length La longueur du côté.
   */
  public Square(Point p1, int length) {
    super(IdCounter.getInstance().getNextId(), ShapeType.SQUARE);
    this.p1 = p1;
    this.length = length;
  }

 /**
   * Demande à la zone de dessin de tracer les contours de ce carré.
   * @param area La zone de dessin (Area) où le carré doit être rendu.
   */
  public void draw(Area area) {
      area.drawSquare(p1, length);
  }

  /**
   * Définit le point d'origine du carré.
   * @param newVar Le nouveau point pour le coin supérieur gauche.
   */
  public void setP1 (Point newVar) {
    p1 = newVar;
  }

  /**
   * Récupère le point d'origine du carré.
   * @return Le point p1.
   */
  public Point getP1 () {
    return p1;
  }

  /**
   * Définit la longueur du côté du carré.
   * @param newVar La nouvelle longueur du côté.
   */
  public void setLength (int newVar) {
    length = newVar;
  }

  /**
   * Récupère la longueur du côté du carré.
   * @return La longueur actuelle du côté.
   */
  public int getLength () {
    return length;
  }

  /**
   * Retourne une représentation textuelle de la position et de la taille du carré.
   * @return Une chaîne de caractères décrivant le point p1 et la longueur du côté.
   */
  public String print()
  {
    return "p1 : " + p1.print() + "\nlength : " + length;
  }
}