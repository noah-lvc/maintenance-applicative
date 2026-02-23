package shape;

import java.util.ArrayList;

/**
 * Classe Layer
 * * Représente un calque (couche) de dessin dans une zone donnée.
 * Un calque contient une liste de formes et possède un état de visibilité 
 * qui détermine si son contenu doit être rendu lors de l'affichage.
 */
public class Layer {
    /** Identifiant unique du calque. */
    private int id;
    
    /** Nom du calque. */
    private String name;
    
    /** État de visibilité du calque (vrai par défaut). */
    private boolean visible;
    
    /** Liste des formes (Shape) contenues dans ce calque. */
    private ArrayList<Shape> shapes;

    /**
     * Constructeur d'un calque.
     * @param name Nom à attribuer au calque.
     * @param id Identifiant unique fourni (généralement via IdCounter).
     */
    public Layer(String name, int id) {
        this.name = name;
        this.id = id;
        this.shapes = new ArrayList<>();
        this.visible = true;
    }

    /**
     * Définit si le calque doit être visible ou masqué.
     * @param visible Vrai pour afficher le calque, faux pour le masquer.
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Ajoute une forme géométrique à la liste des formes du calque.
     * @param shape La forme à ajouter.
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Supprime une forme spécifique de la liste du calque.
     * @param shape La forme à retirer.
     */
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    /**
     * Vérifie si le calque est actuellement visible.
     * @return Vrai si le calque est visible, faux sinon.
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Récupère la liste de toutes les formes présentes sur ce calque.
     * @return Une ArrayList contenant les instances de Shape.
     */
    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    /**
     * Récupère l'identifiant du calque.
     * @return L'identifiant entier.
     */
    public int getId() {
        return id;
    }

    /**
     * Récupère le nom du calque.
     * @return Le nom sous forme de chaîne de caractères.
     */
    public String getName() {
        return name;
    }

}