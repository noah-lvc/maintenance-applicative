package shape;

/**
 * Classe Circle
 *
 * Représente un cercle géométrique défini par un point central et un rayon.
 * Cette classe hérite de la classe abstraite Shape.
 */
public class Circle extends Shape {

    /** Le point central du cercle. */
    private Point center;
    
    /** Le rayon du cercle. */
    private int radius;

    /**
     * Constructeur créant un cercle à partir d'un objet Point.
     * @param center Le point central du cercle.
     * @param radius Le rayon du cercle.
     */
    public Circle(Point center, int radius) {
        super(IdCounter.getInstance().getNextId(), ShapeType.CIRCLE);
        this.center = center;
        this.radius = radius;
    }

    /**
     * Constructeur créant un cercle à partir de coordonnées cartésiennes.
     * @param px Coordonnée X du centre.
     * @param py Coordonnée Y du centre.
     * @param radius Le rayon du cercle.
     */
    public Circle(int px, int py, int radius) {
        super(IdCounter.getInstance().getNextId(), ShapeType.CIRCLE);
        this.center = new Point(px, py);
        this.radius = radius;
    }

    /**
     * Retourne une représentation textuelle des caractéristiques du cercle.
     * @return Une chaîne de caractères décrivant le centre et le rayon.
     */
    @Override
    public String print() {
        return "Circle(center: " + center.print() + ", radius: " + radius + ")";
    }

    /**
     * Set the value of center
     * @param newVar the new value of center
     */
    public void setCenter(Point newVar) {
        center = newVar;
    }

    /**
     * Get the value of center
     * @return the value of center
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Set the value of radius
     * @param newVar the new value of radius
     */
    public void setRadius(int newVar) {
        radius = newVar;
    }

    /**
     * Get the value of radius
     * @return the value of radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Demande à la zone de dessin de tracer ce cercle.
     * @param area La zone de dessin (Area) où le cercle doit être rendu.
     */
    public void draw(Area area) {
        area.drawCircle(center, radius);
    }

}