package shape;

/**
 * Class Point
 *
 * Représente un point 2D dans l'espace cartésien.
 * Hérite de Shape pour permettre le traitement uniforme des éléments graphiques.
 *
 * Propriétés spécifiques :
 * - x : coordonnée horizontale
 * - y : coordonnée verticale
 */
public class Point extends Shape {
  /** La coordonnée X du point. */
  private int x;
  /** La coordonnée Y du point. */
  private int y;
  
  /**
   * Constructeur créant un point à partir de ses coordonnées.
   * @param x Position sur l'axe horizontal.
   * @param y Position sur l'axe vertical.
   */
  public Point(int x, int y) {
    super(IdCounter.getInstance().getNextId(), ShapeType.POINT);
    this.x = x;
    this.y = y;
  }


  /**
   * Demande à la zone de dessin d'afficher ce point unique.
   * @param area La zone de dessin (Area) où le point doit être rendu.
   */
  public void draw(Area area) {
      area.drawPoint(this);
  }

  /**
   * Définit la valeur de la coordonnée x.
   * @param newVar la nouvelle valeur de x.
   */
  public void setX (int newVar) {
    x = newVar;
  }

  /**
   * Récupère la valeur de la coordonnée x.
   * @return la valeur de x.
   */
  public int getX () {
    return x;
  }

  /**
   * Définit la valeur de la coordonnée y.
   * @param newVar la nouvelle valeur de y.
   */
  public void setY (int newVar) {
    y = newVar;
  }

  /**
   * Récupère la valeur de la coordonnée y.
   * @return la valeur de y.
   */
  public int getY () {
    return y;
  }

  /**
   * Retourne une représentation textuelle des coordonnées du point.
   * @return Une chaîne au format Point(x: val, y: val).
   */
  @Override
  public String print() {
    return "Point(x: " + x + ", y: " + y + ")";
  }
}