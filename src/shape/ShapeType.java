package shape;

/**
 * Énumération ShapeType
 * * Définit la liste exhaustive des types de formes géométriques 
 * gérées par l'application Pixel Tracer.
 * Utilisée pour l'identification et le filtrage des objets graphiques.
 */
public enum ShapeType {
    /** Représente un point unique (x, y). */
    POINT, 
    
    /** Représente un segment de droite entre deux points. */
    LINE, 
    
    /** Représente un quadrilatère régulier (quatre côtés égaux). */
    SQUARE, 
    
    /** Représente un quadrilatère dont les angles sont droits. */
    RECTANGLE, 
    
    /** Représente une forme circulaire définie par un centre et un rayon. */
    CIRCLE, 
    
    /** Représente une forme fermée composée de plusieurs segments. */
    POLYGON, 
    
    /** Représente une courbe de Bézier définie par des points de contrôle. */
    CURVE
}