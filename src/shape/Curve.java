package shape;

/**
 * Classe Curve
 *
 * Représente une courbe de Bézier cubique définie par quatre points de contrôle.
 * Hérite de Shape.
 *
 * Propriétés spécifiques :
 * - p1, p2, p3, p4 : les quatre points de contrôle de la courbe.
 */
public class Curve extends Shape {

 /** Premier point d'ancrage (départ). */
 private Point p1;
 /** Premier point de contrôle. */
 private Point p2;
 /** Deuxième point de contrôle. */
 private Point p3;
 /** Deuxième point d'ancrage (arrivée). */
 private Point p4;

 /**
   * Constructeur de la courbe avec quatre points de contrôle.
   * @param p1 Point de départ.
   * @param p2 Premier point de contrôle.
   * @param p3 Deuxième point de contrôle.
   * @param p4 Point d'arrivée.
   */
  public Curve(Point p1, Point p2, Point p3, Point p4) {
    super(IdCounter.getInstance().getNextId(), ShapeType.CURVE);
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    this.p4 = p4;
  }
  
  /**
   * Demande à la zone de dessin de tracer la courbe de Bézier.
   * @param area La zone de dessin où la courbe sera rendue.
   */
  public void draw(Area area) {
        area.drawCurve(p1, p2, p3, p4);
    }

  /**
   * Définit la valeur de p1.
   * @param newVar La nouvelle valeur pour p1.
   */
  public void setP1 (Point newVar) {
    p1 = newVar;
  }

  /**
   * Récupère la valeur de p1.
   * @return La valeur de p1.
   */
  public Point getP1 () {
    return p1;
  }

  /**
   * Définit la valeur de p2.
   * @param newVar La nouvelle valeur pour p2.
   */
  public void setP2 (Point newVar) {
    p2 = newVar;
  }

  /**
   * Récupère la valeur de p2.
   * @return La valeur de p2.
   */
  public Point getP2 () {
    return p2;
  }

  /**
   * Définit la valeur de p3.
   * @param newVar La nouvelle valeur pour p3.
   */
  public void setP3 (Point newVar) {
    p3 = newVar;
  }

  /**
   * Récupère la valeur de p3.
   * @return La valeur de p3.
   */
  public Point getP3 () {
    return p3;
  }

  /**
   * Définit la valeur de p4.
   * @param newVar La nouvelle valeur pour p4.
   */
  public void setP4 (Point newVar) {
    p4 = newVar;
  }

  /**
   * Récupère la valeur de p4.
   * @return La valeur de p4.
   */
  public Point getP4 () {
    return p4;
  }

  /**
   * Retourne une représentation textuelle des points de la courbe.
   * @return Une chaîne de caractères listant les coordonnées des points p1 à p4.
   */
  public String print()
  {
    return "points :\np1 : " + p1.print() + "\np2 : " + p2.print() + "\np3 : " + p3.print() + "\np4 : " + p4.print();
  }

}