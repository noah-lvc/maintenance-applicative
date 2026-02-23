package shape;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principale de l'application Pixel Tracer.
 * Elle gère le cycle de vie de l'application, maintient la liste des zones de dessin
 * et orchestre l'exécution des commandes utilisateur.
 */
public class App {

    /** Liste des zones de dessin (Area) créées dans l'application. */
    private ArrayList<Area> areas;

    /** La zone de dessin actuellement sélectionnée. */
    public Area currentArea;

    /** Le calque (Layer) actuellement sélectionné. */
    public Layer currentLayer;

    /** La forme (Shape) actuellement sélectionnée. */
    public Shape currentShape;

    /** La commande en cours de traitement. */
    private Command command;

    /**
     * Constructeur de l'application.
     * Initialise la liste des zones de dessin.
     */
    public App() {
        areas = new ArrayList<>();
    }

    /**
     * Initialise l'application, crée la zone par défaut et lance la boucle 
     * principale d'écoute des commandes utilisateur.
     */
    public void init() {
        System.out.println("Pixel Tracer App");
        Area area = new Area(40, 40, IdCounter.getInstance().getNextId(), "default");
        areas.add(area);
        currentArea = area;
        currentLayer = new Layer("default", IdCounter.getInstance().getNextId());
        currentArea.addLayer(currentLayer);
        currentArea.draw();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            command = new Command();
            command.clear_commande();
            command.readFromStdin();
            command.read_exec_command(this, currentArea, currentLayer, currentShape);
        }
    }

    /**
     * Ajoute une nouvelle zone de dessin à la liste de l'application.
     * * @param area La zone de dessin à ajouter.
     */
    public void addAreaToList(Area area) {
        areas.add(area);
    }

    /**
     * Récupère la liste de toutes les zones de dessin.
     * * @return Une ArrayList contenant les instances d'Area.
     */
    public ArrayList<Area> getAreas() {
        return areas;
    }

    /**
     * Point d'entrée principal du programme.
     * * @param args Arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        App app = new App();
        app.init();
    }
}