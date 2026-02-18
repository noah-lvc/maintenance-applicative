package shape;

import java.util.ArrayList;

public class Layer {
    private int id;
    private String name;
    private boolean visible;
    private ArrayList<Shape> shapes;

    public Layer(String name, int id) {
        this.name = name;
        this.id = id;
        this.shapes = new ArrayList<>();
        this.visible = true;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    public boolean isVisible() {
        return visible;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}