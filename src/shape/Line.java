package shape;

/**
 * Classe Line
 *
 * Représente une ligne droite (segment) définie par deux points.
 * Hérite de la classe Shape.
 *
 * Propriétés spécifiques :
 * - p1 : point de départ du segment
 * - p2 : point d'arrivée du segment
 *
 * Implémente draw() pour dessiner la ligne sur une zone de pixels.
 */
public class Line extends Shape {

/** Premier point (origine) de la ligne. */
private Point p1;

/** Deuxième point (destination) de la ligne. */
private Point p2;
  
  /**
   * Constructeur d'une ligne à partir de deux objets Point.
   * @param p1 Le point de départ.
   * @param p2 Le point d'arrivée.
   */
  public Line(Point p1, Point p2) {
    super(IdCounter.getInstance().getNextId(), ShapeType.LINE);
    this.p1 = p1;
    this.p2 = p2;
  }
  /**
   * Demande à la zone de dessin de tracer le segment entre p1 et p2.
   * @param area La zone de dessin (Area) où la ligne doit être rendue.
   */
    public void draw(Area area) {
        area.drawLine(p1, p2);
    }

  /**
   * Définit le premier point de la ligne.
   * @param newVar Le nouveau point p1.
   */
  public void setP1 (Point newVar) {
    p1 = newVar;
  }

  /**
   * Récupère le premier point de la ligne.
   * @return Le point p1.
   */
  public Point getP1 () {
    return p1;
  }

  /**
   * Définit le second point de la ligne.
   * @param newVar Le nouveau point p2.
   */
  public void setP2 (Point newVar) {
    p2 = newVar;
  }

  /**
   * Récupère le second point de la ligne.
   * @return Le point p2.
   */
  public Point getP2 () {
    return p2;
  }

  /**
   * Retourne une représentation textuelle des points de la ligne.
   * @return Une chaîne de caractères décrivant p1 et p2.
   */
  public String print()
  {
    return "points :\np1 : " + p1.print() + "\np2 : " + p2.print();
  }
}

