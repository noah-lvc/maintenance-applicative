package shape;

import java.util.ArrayList;

/**
 * Classe Polygon
 * * Représente une forme géométrique fermée composée de plusieurs sommets (points).
 * Hérite de la classe Shape.
 */
public class Polygon extends Shape {

    /** Nombre de sommets du polygone. */
    private int n;

    /** Liste des points (sommets) constituant le polygone. */
    private ArrayList<Point> points;

    /**
     * Construit un polygone à partir d'une liste de points existante.
     * @param pointsList La liste des points à utiliser comme sommets.
     */
    public Polygon(ArrayList<Point> pointsList) {
        super(IdCounter.getInstance().getNextId(), ShapeType.POLYGON);
        points = pointsList;
    }

    /**
     * Construit un polygone vide avec une capacité initiale de n points.
     * @param n Capacité initiale de la liste de points.
     */
    public Polygon(int n) {
        super(IdCounter.getInstance().getNextId(), ShapeType.POLYGON);
        points = new ArrayList<Point>(n);
    }

    /**
     * Construit un polygone à partir d'un nombre de points et d'un tableau de coordonnées.
     * @param n Nombre de points.
     * @param xandy Tableau contenant les coordonnées x et y à la suite (x1, y1, x2, y2...).
     */
    public Polygon(int n, int[] xandy) {
        super(IdCounter.getInstance().getNextId(), ShapeType.POLYGON);
        points = new ArrayList<Point>(n);
        try {
            for (int i = 0; i < n * 2; i += 2) { // n*2 parce que x et y sont stockés dans le même tableau
                System.out.println();
                points.add(new Point(xandy[i], xandy[i + 1]));
            }
            this.n = n;
        } catch (Exception e) {
            System.out.println("Taille du tableau et cordonnées des points incohérentes : " + e);
        }
    }



    /**
     * Ajoute un nouveau sommet au polygone.
     * @param p Le point à ajouter.
     */
    public void addPoint(Point p) {
        points.add(p);
    }

    /**
     * Demande à la zone de dessin de tracer le polygone en reliant ses sommets.
     * @param area La zone de dessin (Area) où le polygone doit être rendu.
     */
    public void draw(Area area) {
        area.drawPolygon(points);
    }

    /**
     * Définit le nombre de sommets n.
     * @param newVar La nouvelle valeur de n.
     */
    public void setN (int newVar) {
        n = newVar;
    }

    /**
     * Récupère le nombre de sommets n.
     * @return La valeur de n.
     */
    public int getN () {
        return n;
    }

    /**
     * Définit la liste des points du polygone.
     * @param newVar La nouvelle liste de points.
     */
    public void setPoints (ArrayList<Point> newVar) {
        points = newVar;
    }

    /**
     * Récupère la liste des points du polygone.
     * @return La liste des sommets (ArrayList).
     */
    public ArrayList<Point> getPoints () {
        return points;
    }

    /**
     * Retourne une représentation textuelle du polygone et de ses points.
     * @return Une chaîne de caractères listant tous les sommets et la valeur n.
     */
    public String print()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("points :\n");
        for (Point point : points) {
            sb.append(point.print()).append("\n");
        }
        sb.append("n : ").append(n);
        return sb.toString();
    }
}