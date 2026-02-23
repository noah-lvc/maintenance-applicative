package shape;
import java.util.ArrayList;

/**
 * Représente la zone de dessin (canevas) composée de pixels (caractères).
 * Cette classe gère le rendu des différentes formes géométriques sur une grille 2D.
 */
public class Area {
    /** Largeur de la zone de dessin. */
    private int width;
    /** Hauteur de la zone de dessin. */
    private int height;
    /** Identifiant unique de la zone. */
    private int id;
    /** Nom de la zone. */
    private String name;
    /** Matrice de caractères représentant la grille de pixels. */
    private char[][] area;
    /** Liste des calques contenus dans cette zone. */
    private ArrayList<Layer> layers;
    /** Caractère utilisé pour représenter un pixel vide. */
    private char emptyChar;
    /** Caractère utilisé pour représenter un pixel rempli. */
    private char fullChar;

    /**
     * Constructeur de la classe Area.
     * @param width Largeur de la grille.
     * @param height Hauteur de la grille.
     * @param id Identifiant de la zone.
     * @param name Nom de la zone.
     */
    public Area(int width, int height, int id, String name) {
        this.width = width;
        this.height = height;
        this.id = id;
        this.name = name;
        this.layers = new ArrayList<>();
        this.emptyChar = '.';
        this.fullChar = '@';
        this.area = new char[height][width];
        clearArea();
    }

    /**
     * Réinitialise la grille en remplissant chaque pixel avec le caractère vide.
     */
    public void clearArea() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                area[i][j] = emptyChar; // Use the updated emptyChar value
            }
        }
    }

    /**
     * Ajoute un calque à la zone de dessin.
     * @param layer Le calque à ajouter.
     */
    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    /**
     * Ajoute un calque à la zone de dessin.
     * @param layer Le calque à ajouter.
     */
    public void draw() {
        clearArea();

        for (Layer layer : layers) {
            if (!layer.isVisible()) continue;

            for (Shape shape : layer.getShapes()) {
                shape.draw(this);
            }
        }

        // affichage
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(area[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Dessine une ligne entre deux points en utilisant l'algorithme de Bresenham.
     * @param p1 Point de départ.
     * @param p2 Point d'arrivée.
     */
    public void drawLine(Point p1, Point p2) {
        int x1 = p1.getX(), y1 = p1.getY();
        int x2 = p2.getX(), y2 = p2.getY();
        // Simple Bresenham's line algorithm
        int dx = Math.abs(x2 - x1), dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1, sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            if (x1 >= 0 && x1 < width && y1 >= 0 && y1 < height) {
                area[y1][x1] = fullChar;
            }
            if (x1 == x2 && y1 == y2) break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

    /**
     * Dessine les contours d'un carré.
     * @param p1 Coin supérieur gauche.
     * @param length Longueur du côté.
     */
    public void drawSquare(Point p1, int length) {
        int x = p1.getX(), y = p1.getY();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int px = x + i, py = y + j;
                // Dessiner uniquement les côtés du carré
                if ((i == 0 || i == length - 1 || j == 0 || j == length - 1) &&
                        px >= 0 && px < width && py >= 0 && py < height) {
                    area[py][px] = fullChar;
                }
            }
        }
    }

    /**
     * Dessine les contours d'un rectangle.
     * @param p1 Coin supérieur gauche.
     * @param width Largeur du rectangle.
     * @param height Hauteur du rectangle.
     */
    public void drawRectangle(Point p1, int width, int height) {
        int x = p1.getX(), y = p1.getY();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int px = x + j, py = y + i;
                // Draw only the edges of the rectangle
                if ((i == 0 || i == height - 1 || j == 0 || j == width - 1) &&
                        px >= 0 && px < this.width && py >= 0 && py < this.height) {
                    area[py][px] = fullChar;
                }
            }
        }
    }

    /**
     * Dessine un cercle en utilisant l'algorithme de tracé de cercle d'Andres (Midpoint).
     * @param center Point central du cercle.
     * @param radius Rayon du cercle.
     */
    public void drawCircle(Point center, int radius) {
        int cx = center.getX(), cy = center.getY();
        int x = 0, y = radius;
        int d = 3 - 2 * radius;

        while (y >= x) {
            // Dessiner les 8 octants du cercle
            drawCirclePixel(cx + x, cy + y);
            drawCirclePixel(cx - x, cy + y);
            drawCirclePixel(cx + x, cy - y);
            drawCirclePixel(cx - x, cy - y);
            drawCirclePixel(cx + y, cy + x);
            drawCirclePixel(cx - y, cy + x);
            drawCirclePixel(cx + y, cy - x);
            drawCirclePixel(cx - y, cy - x);

            if (d <= 0) {
                d = d + 4 * x + 6;
            } else {
                d = d + 4 * (x - y) + 10;
                y--;
            }
            x++;
        }
    }

    /**
     * Allume un pixel spécifique pour le tracé d'un cercle si les coordonnées sont valides.
     * @param x Coordonnée X.
     * @param y Coordonnée Y.
     */
    private void drawCirclePixel(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            area[y][x] = fullChar;
        }
    }

    /**
     * Dessine une courbe de Bézier cubique définie par quatre points de contrôle.
     * @param p1 Point de départ.
     * @param p2 Premier point de contrôle.
     * @param p3 Deuxième point de contrôle.
     * @param p4 Point d'arrivée.
     */
    public void drawCurve(Point p1, Point p2, Point p3, Point p4) {
        int steps = 100; // Number of steps for curve approximation
        for (int i = 0; i <= steps; i++) {
            float t = i / (float) steps;
            int x = (int) (Math.pow(1 - t, 3) * p1.getX() +
                    3 * Math.pow(1 - t, 2) * t * p2.getX() +
                    3 * (1 - t) * Math.pow(t, 2) * p3.getX() +
                    Math.pow(t, 3) * p4.getX());
            int y = (int) (Math.pow(1 - t, 3) * p1.getY() +
                    3 * Math.pow(1 - t, 2) * t * p2.getY() +
                    3 * (1 - t) * Math.pow(t, 2) * p3.getY() +
                    Math.pow(t, 3) * p4.getY());
            drawCirclePixel(x, y); // Use existing method to plot the pixel
        }
    }

    /**
     * Dessine un point unique sur la grille à partir d'un objet Point.
     * Vérifie si les coordonnées sont à l'intérieur des limites de la zone.
     * @param p Le point contenant les coordonnées x et y.
     */
    public void drawPoint(Point p) {
        int x = p.getX();
        int y = p.getY();

        if (x >= 0 && x < width && y >= 0 && y < height) {
            area[y][x] = fullChar;
        }
    }

    /**
     * Dessine un polygone en reliant une série de points.
     * @param points Liste ordonnée des sommets du polygone.
     */
    public void drawPolygon(ArrayList<Point> points) {
        if (points.size() < 2) return; // Un polygone nécessite au moins deux points

        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size()); // Connect last point to the first
            drawLine(p1, p2); // Dessiner une ligne entre deux points
        }
    }

    /**
     * @return La largeur de la zone.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width La nouvelle largeur de la zone.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return La hauteur de la zone.
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height La nouvelle hauteur de la zone.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return L'identifiant unique de la zone.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id Le nouvel identifiant de la zone.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Le nom de la zone.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Le nouveau nom de la zone.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return La matrice de caractères (pixels) de la zone.
     */
    public char[][] getArea() {
        return area;
    }

    /**
     * @param area La nouvelle matrice de caractères à assigner.
     */
    public void setArea(char[][] area) {
        this.area = area;
    }

    /**
     * @return La liste des calques de la zone.
     */
    public ArrayList<Layer> getLstLayers() {
        return layers;
    }

    /**
     * @return Le caractère actuel représentant le vide.
     */
    public char getEmptyChar() {
        return emptyChar;
    }

    /**
     * @param emptyChar Le nouveau caractère pour les pixels vides.
     */
    public void setEmptyChar(char emptyChar) {
        this.emptyChar = emptyChar;
    }

    /**
     * @return Le caractère actuel représentant un pixel plein.
     */
    public char getFullChar() {
        return fullChar;
    }

    /**
     * @param fullChar Le nouveau caractère pour les pixels pleins.
     */
    public void setFullChar(char fullChar) {
        this.fullChar = fullChar;
    }
}