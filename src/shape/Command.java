package shape;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * La classe Command est responsable de l'analyse (parsing) et de l'exécution
 * des instructions saisies par l'utilisateur.
 * Elle sépare les paramètres textuels des paramètres numériques pour faciliter 
 * le traitement des différentes commandes de dessin et de gestion.
 */
public class Command {
    /** Le nom de la commande (premier mot saisi). */
    private String name;
    /** Liste des paramètres entiers extraits de la saisie. */
    private ArrayList<Integer> intParams;
    /** Liste des paramètres textuels extraits de la saisie. */
    private ArrayList<String> strParams;
    /** Limite maximale de paramètres autorisés par liste. */
    private static final int MAX_PARAM = 30;

    /**
     * Constructeur par défaut initialisant les structures de paramètres.
     */
    public Command() {
        this.name = "";
        this.intParams = new ArrayList<>();
        this.strParams = new ArrayList<>();
    }

    /**
     * Réinitialise le nom et les listes de paramètres de la commande.
     */
    public void clear_commande() {
        this.name = "";
        this.intParams.clear();
        this.strParams.clear();
    }

    /**
     * Ajoute un paramètre entier à la liste si la limite n'est pas atteinte.
     * @param p L'entier à ajouter.
     */
    public void addIntParam(int p) {
        if (intParams.size() < MAX_PARAM) {
            intParams.add(p);
        }
    }

    /**
     * Ajoute un paramètre textuel à la liste si la limite n'est pas atteinte.
     * @param s La chaîne de caractères à ajouter.
     */
    public void addStrParam(String s) {
        if (strParams.size() < MAX_PARAM) {
            strParams.add(s);
        }
    }

    /**
     * Lit une ligne depuis l'entrée standard, la découpe en jetons (tokens)
     * et les répartit entre intParams et strParams selon leur nature.
     */
    public void readFromStdin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("~> ");
        String line = scanner.nextLine().trim().toLowerCase();

        if (line.isEmpty()) return;
        

        String[] tokens = line.split("\\s+");
        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                intParams.add(Integer.parseInt(token));
            } else {
                strParams.add(token);
            }
        }

        if (!strParams.isEmpty()) {
            name = strParams.get(0);
        }
    }

    /**
     * Affiche l'état interne de la commande (nom et paramètres) à des fins de débogage.
     */
    public void debug() {
        System.out.println("\n --- ");
        System.out.println("str:");
        for (String s : strParams) {
            System.out.println("<" + s + ">");
        }
        System.out.println("int:");
        for (int i : intParams) {
            System.out.println("<" + i + ">");
        }
    }

    /** @return Le nom de la commande. */
    public String getName() {
        return name;
    }

    /** @return La liste des paramètres textuels. */
    public ArrayList<String> getStrParams() {
        return strParams;
    }

    /** @return La liste des paramètres entiers. */
    public ArrayList<Integer> getIntParams() {
        return intParams;
    }

    /**
     * Affiche le menu d'aide listant toutes les commandes disponibles et leurs formats.
     */
    public void printHelp() {
        System.out.println("\t**************************************************");
        System.out.println("\t****         VECTOR TEXT-BASED EDITOR         ****");
        System.out.println("\t**************************************************");
        System.out.println("\t==== Control ====");
        System.out.println("\tclear : clear screen ");
        System.out.println("\texit : exit the program ");
        System.out.println("\thelp : print this help ");
        System.out.println("\tplot : draw screen");
        System.out.println("\t==== Draw shapes ====");
        System.out.println("\tpoint px py : create point at position (px, py)");
        System.out.println("\tline x1 y1 x2 y2 : draw line from (x1, y1) to (x2, y2)");
        System.out.println("\tsquare x1 y1 l : draw square at (x1, y1) with side length l");
        System.out.println("\trectangle x1 y1 w h : draw rectangle at (x1, y1) with width w and height h");
        System.out.println("\tcircle x y r : draw circle at (x, y) with radius r");
        System.out.println("\tpolygon x1 y1 x2 y2 ... : draw polygon with vertices (x1, y1), (x2, y2), ...");
        System.out.println("\tcurve x1 y1 x2 y2 x3 y3 x4 y4 : draw Bezier curve with the given control points");
        System.out.println("\t==== Draw manager ====");
        System.out.println("\tlist {layers, areas, shapes} example :  list layers");
        System.out.println("\tselect {area, layer} {id}");
        System.out.println("\tdelete {area, layer, shape} {id}");
        System.out.println("\tnew {area, layer}");
        System.out.println("\t==== Set ====");
        System.out.println("\tset char {border, background} ascii_code");
        System.out.println("\tset layer {visible, invisible} {id}");
    }

    /**
     * Analyse le nom de la commande et l'exécute en utilisant les paramètres fournis.
     * Cette méthode interagit directement avec l'instance de l'application et la zone active.
     * * @param app L'instance de l'application.
     * @param area La zone de dessin courante.
     * @param layer Le calque courant.
     * @param shape La forme courante.
     */
    public void read_exec_command(App app, Area area, Layer layer, Shape shape) {
        Point p1;
        Point p2;
        Point p3;
        Point p4;

        boolean shouldDrawCanvas = true;

        switch (getName()) {
            case "exit":
                if (this.strParams.size() == 1) {
                    ErrorMessage.EXIT.printMessage();
                    System.exit(0);
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                    shouldDrawCanvas = false;
                }
                break;

            case "clear":
                if (this.strParams.size() == 1) {
                    app.currentArea.clearArea();
                    System.out.flush();
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                    shouldDrawCanvas = false;
                }
                break;

            case "help":
                printHelp();
                shouldDrawCanvas = false;
                break;

            case "plot":
                if (this.strParams.size() == 1) {
                    app.currentArea.clearArea();
                    app.currentArea.draw();
                    System.out.println("Canvas redrawn.");
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                    System.out.println("Expected format: plot");
                }
                shouldDrawCanvas = false;
                break;

            case "point":
                if (this.intParams.size() == 2) {
                    p1 = new Point(this.intParams.get(0), this.intParams.get(1));
                    app.currentLayer.addShape(p1);
                    area.drawLine(p1, p1);
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                    System.out.println("Expected format: point {x} {y}");
                    shouldDrawCanvas = false;
                }
                break;

            case "line":
                if (this.intParams.size() == 4) {
                    p1 = new Point(this.intParams.get(0), this.intParams.get(1));
                    p2 = new Point(this.intParams.get(2), this.intParams.get(3));
                    Line line = new Line(p1, p2);
                    app.currentLayer.addShape(line);
                    area.drawLine(p1, p2);
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                    System.out.println("Expected format: line {x1} {y1} {x2} {y2}");
                    shouldDrawCanvas = false;
                }
                break;

            case "square":
                if (this.intParams.size() == 3) {
                    p1 = new Point(this.intParams.get(0), this.intParams.get(1));
                    Square square = new Square(p1, this.intParams.get(2));
                    app.currentLayer.addShape(square);
                    area.drawSquare(p1, this.intParams.get(2));
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                    System.out.println("Expected format: square {x} {y} {length}");
                    shouldDrawCanvas = false;
                }
                break;

            case "rectangle":
                if (this.intParams.size() == 4) {
                    p1 = new Point(this.intParams.get(0), this.intParams.get(1));
                    Rectangle rectangle = new Rectangle(p1, this.intParams.get(2), this.intParams.get(3));
                    app.currentLayer.addShape(rectangle);
                    area.drawRectangle(p1, this.intParams.get(2), this.intParams.get(3));
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                    System.out.println("Expected format: rectangle {x} {y} {width} {height}");
                    shouldDrawCanvas = false;
                }
                break;

            case "circle":
                if (this.intParams.size() == 3) {
                    p1 = new Point(this.intParams.get(0), this.intParams.get(1));
                    Circle circle = new Circle(p1, this.intParams.get(2));
                    app.currentLayer.addShape(circle);
                    area.drawCircle(p1, this.intParams.get(2));
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                    System.out.println("Expected format: circle {x} {y} {radius}");
                    shouldDrawCanvas = false;
                }
                break;

            case "curve":
                if (this.intParams.size() == 8) {
                    p1 = new Point(this.intParams.get(0), this.intParams.get(1));
                    p2 = new Point(this.intParams.get(2), this.intParams.get(3));
                    p3 = new Point(this.intParams.get(4), this.intParams.get(5));
                    p4 = new Point(this.intParams.get(6), this.intParams.get(7));
                    Curve curve = new Curve(p1, p2, p3, p4);
                    app.currentLayer.addShape(curve);
                    area.drawCurve(p1, p2, p3, p4);
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                    System.out.println("Expected format: curve {x1} {y1} {x2} {y2} {x3} {y3} {x4} {y4}");
                    shouldDrawCanvas = false;
                }
                break;

            case "polygon":
                if (this.intParams.size() >= 4 && this.intParams.size() % 2 == 0) {
                    ArrayList<Point> points = new ArrayList<>();
                    for (int i = 0; i < this.intParams.size(); i += 2) {
                        points.add(new Point(this.intParams.get(i), this.intParams.get(i + 1)));
                    }
                    Polygon polygon = new Polygon(points);
                    app.currentLayer.addShape(polygon);
                    area.drawPolygon(points);
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                    System.out.println("Expected format: polygon {x1} {y1} {x2} {y2} ...");
                    shouldDrawCanvas = false;
                }
                break;

            case "list":
                if (this.strParams.size() == 2) {
                    String target = this.strParams.get(1);
                    switch (target) {
                        case "layers":
                            for (Layer l : app.currentArea.getLstLayers()) {
                                System.out.println("Layer ID: " + l.getId() + ", Name: " + l.getName());
                            }
                            break;
                        case "areas":
                            for (Area a : app.getAreas()) {
                                System.out.println("Area ID: " + a.getId() + ", Name: " + a.getName());
                            }
                            break;
                        case "shapes":
                            for (Shape s : app.currentLayer.getShapes()) {
                                System.out.println("Shape ID: " + s.getId() + ", Type: " + s.getClass().getSimpleName());
                            }
                            break;
                        default:
                            ErrorMessage.UNKNOWN_COMMAND.printMessage();
                    }
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                }
                shouldDrawCanvas = false;
                break;

            case "select":
                if (this.strParams.size() == 2 && this.intParams.size() == 1) {
                    String target = this.strParams.get(1);
                    int id = this.intParams.get(0);
                    switch (target) {
                        case "area":
                            boolean areaFound = false;
                            for (Area a : app.getAreas()) {
                                if (a.getId() == id) {
                                    app.currentArea = a;
                                    System.out.println("Selected Area ID: " + id);
                                    areaFound = true;
                                    break;
                                }
                            }
                            if (!areaFound) {
                                ErrorMessage.UNKNOWN_ID.printMessage();
                            }
                            break;
                        case "layer":
                            boolean layerFound = false;
                            for (Layer l : app.currentArea.getLstLayers()) {
                                if (l.getId() == id) {
                                    app.currentLayer = l;
                                    System.out.println("Selected Layer ID: " + id);
                                    layerFound = true;
                                    break;
                                }
                            }
                            if (!layerFound) {
                                ErrorMessage.UNKNOWN_ID.printMessage();
                            }
                            break;
                        default:
                            ErrorMessage.UNKNOWN_COMMAND.printMessage();
                    }
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                    System.out.println("Expected format: select {area, layer} {id}");
                }
                shouldDrawCanvas = false;
                break;

            case "delete":
                if (this.strParams.size() == 2 && this.intParams.size() == 1) {
                    String target = this.strParams.get(1);
                    int id = this.intParams.get(0);
                    switch (target) {
                        case "area":
                            app.getAreas().removeIf(a -> a.getId() == id);
                            System.out.println("Deleted Area ID: " + id);
                            break;
                        case "layer":
                            app.currentArea.getLstLayers().removeIf(l -> l.getId() == id);
                            app.currentArea.clearArea();
                            app.currentArea.draw();
                            System.out.println("Deleted Layer ID: " + id);
                            break;
                        case "shape":
                            app.currentLayer.getShapes().removeIf(s -> s.getId() == id);
                            System.out.println("Deleted Shape ID: " + id);
                            break;
                        default:
                            ErrorMessage.UNKNOWN_COMMAND.printMessage();
                    }
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                    System.out.println("Expected format: delete {area, layer, shape} {id}");
                }
                shouldDrawCanvas = false;
                break;

            case "new":
                if (this.strParams.size() == 2) {
                    String target = this.strParams.get(1);
                    switch (target) {
                        case "area":
                            Area newArea = new Area(40, 40, IdCounter.getInstance().getNextId(), "new_area");
                            app.addAreaToList(newArea);
                            System.out.println("Created new Area ID: " + newArea.getId());
                            break;
                        case "layer":
                            Layer newLayer = new Layer("new_layer", IdCounter.getInstance().getNextId());
                            app.currentArea.addLayer(newLayer);
                            System.out.println("Created new Layer ID: " + newLayer.getId());
                            break;
                        default:
                            ErrorMessage.UNKNOWN_COMMAND.printMessage();
                    }
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                }
                shouldDrawCanvas = false;
                break;

            case "set":
                if (this.strParams.size() == 3 && this.intParams.size() == 1) {
                    String target = this.strParams.get(2);
                    int asciiCode = this.intParams.get(0);

                    if (asciiCode < 32 || asciiCode > 126) {
                        ErrorMessage.INVALID_PARAMETERS.printMessage();
                        System.out.println("ASCII code must be between 32 and 126 for printable characters.");
                        shouldDrawCanvas = false;
                        break;
                    }

                    char newChar = (char) asciiCode;
                    switch (target) {
                        case "background":
                            area.setEmptyChar(newChar);
                            System.out.println("Background character set to: " + newChar);
                            break;
                        case "border":
                            area.setFullChar(newChar);
                            System.out.println("Border character set to: " + newChar);
                            break;
                        default:
                            ErrorMessage.UNKNOWN_COMMAND.printMessage();
                    }
                } else {
                    ErrorMessage.INVALID_PARAMETERS.printMessage();
                    System.out.println("Expected format: set char {background, border} {ascii_code}");
                }
                shouldDrawCanvas = false;
                break;

            default:
                System.out.println("Commande inconnue");
                shouldDrawCanvas = false;
                break;
        }

        if (shouldDrawCanvas) {
            app.currentArea.draw();
        }
    }
}