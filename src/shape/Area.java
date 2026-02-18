package shape;
import java.util.ArrayList;

public class Area {
    private int width;
    private int height;
    private int id;
    private String name;
    private char[][] area;
    private ArrayList<Layer> layers;
    private char emptyChar;
    private char fullChar;

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

    public void clearArea() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                area[i][j] = emptyChar; // Use the updated emptyChar value
            }
        }
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

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

    private void drawCirclePixel(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            area[y][x] = fullChar;
        }
    }

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

    public void drawPoint(Point p) {
        int x = p.getX();
        int y = p.getY();

        if (x >= 0 && x < width && y >= 0 && y < height) {
            area[y][x] = fullChar;
        }
    }

    public void drawPolygon(ArrayList<Point> points) {
        if (points.size() < 2) return; // Un polygone nécessite au moins deux points

        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size()); // Connect last point to the first
            drawLine(p1, p2); // Dessiner une ligne entre deux points
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char[][] getArea() {
        return area;
    }

    public void setArea(char[][] area) {
        this.area = area;
    }

    public ArrayList<Layer> getLstLayers() {
        return layers;
    }

    public char getEmptyChar() {
        return emptyChar;
    }

    public void setEmptyChar(char emptyChar) {
        this.emptyChar = emptyChar;
    }

    public char getFullChar() {
        return fullChar;
    }

    public void setFullChar(char fullChar) {
        this.fullChar = fullChar;
    }
}