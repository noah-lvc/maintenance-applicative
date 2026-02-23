package shape;

/**
 * Class Shape
 *
 * <<abstract>>
 * * Classe de base abstraite pour toutes les formes géométriques du système.
 * Elle définit les propriétés communes à tous les objets graphiques tels que 
 * l'identifiant unique, la couleur et le statut de remplissage.
 */
abstract public class Shape  {

   /** Identifiant unique de la forme. */
   private int id;
    
   /** Couleur de la forme (par défaut "BLACK"). */
   private String color;
   
   /** Indique si la forme doit être remplie ou non. */
   private boolean fill;

   /**
     * Constructeur de la classe Shape.
     * @param id L'identifiant unique généré pour cette forme.
     * @param type Le type de forme (issu de l'énumération ShapeType).
     */
    public Shape(int id, ShapeType type) {
        this.id = id;
        this.color = "BLACK";
        this.fill = false;
    }

    /**
     * Méthode abstraite forçant chaque sous-classe à définir sa propre 
     * logique de rendu sur une zone de dessin.
     * @param area La zone de dessin (Area) où la forme sera tracée.
     */
    public abstract void draw(Area area);

    /**
     * Méthode abstraite retournant les détails techniques de la forme.
     * @return Une chaîne de caractères décrivant les propriétés spécifiques de la forme.
     */
    public abstract String print();

    /**
     * Définit la valeur de l'identifiant.
     * @param newVar La nouvelle valeur de l'id.
     */
    public void setId(int newVar) {
        id = newVar;
    }

    /**
     * Récupère la valeur de l'identifiant.
     * @return L'id actuel de la forme.
     */
    public int getId() {
        return id;
    }

    /**
     * Définit si la forme doit être remplie.
     * @param newVar Vrai pour remplir la forme, faux pour n'avoir que le contour.
     */
    public void setFill(boolean newVar) {
        fill = newVar;
    }

    /**
     * Récupère le statut de remplissage.
     * @return Vrai si la forme est remplie, faux sinon.
     */
    public boolean getFill() {
        return fill;
    }

    /**
     * Définit la couleur de la forme.
     * @param newVar Le nom de la couleur.
     */
    public void setColor(String newVar) {
        color = newVar;
    }

    /**
     * Récupère la couleur de la forme.
     * @return Le nom de la couleur actuelle.
     */
    public String getColor() {
        return color;
    }

  /**
     * Retourne une description générique de la forme.
     * @return Une chaîne de caractères "Unknown shape".
     */
  public String toString(){

    return "Unknown shape";
  }
}