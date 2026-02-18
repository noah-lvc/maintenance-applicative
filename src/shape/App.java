package shape;

import java.util.ArrayList;

public class App {
    private ArrayList<Area> areas;
    public Area currentArea;
    public Layer currentLayer;
    public Shape currentShape;
    private Command command;

    public App() {
        areas = new ArrayList<>();
    }

    public void init() {
        System.out.println("Pixel Tracer App");
        Area area = new Area(40, 40, IdCounter.getInstance().getNextId(), "default");
        areas.add(area);
        currentArea = area;
        currentLayer = new Layer("default", IdCounter.getInstance().getNextId());
        currentArea.addLayer(currentLayer);
        currentArea.draw();

        while (true) {
            command = new Command();
            command.clear_commande();
            command.readFromStdin();
            command.read_exec_command(this, currentArea, currentLayer, currentShape);
        }
    }

    public void addAreaToList(Area area) {
        areas.add(area);
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public static void main(String[] args) {
        App app = new App();
        app.init();
    }
}