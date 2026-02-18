package shape;
import java.util.*;

/**
 * Class Circle
 *
 * Représente un cercle géométrique.
 * Hérite de Shape.
 *
 * Propriétés spécifiques :
 *  - radius : rayon du cercle
 *
 * Implémente la méthode draw() pour dessiner le cercle (ici simulation par print).
 */
public class Circle extends Shape {

  //
    // Fields
    //

    private Point center;
    private int radius;

    //
    // Constructors
    //

    public Circle(Point center, int radius) {
        super(IdCounter.getInstance().getNextId(), ShapeType.CIRCLE);
        this.center = center;
        this.radius = radius;
    }

    public Circle(int px, int py, int radius) {
        super(IdCounter.getInstance().getNextId(), ShapeType.CIRCLE);
        this.center = new Point(px, py);
        this.radius = radius;
    }

    //
    // Methods
    //

    @Override
    public String print() {
        return "Circle(center: " + center.print() + ", radius: " + radius + ")";
    }

    //
    // Accessor methods
    //

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

    public void draw(Area area) {
        area.drawCircle(center, radius);
    }

}