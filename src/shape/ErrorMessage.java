package shape;

/**
 * Énumération regroupant les messages d'erreur et de retour utilisateur de l'application.
 * Chaque constante contient un message textuel prédéfini utilisé pour l'affichage console.
 */
public enum ErrorMessage {
    /** Indique que le nom de la commande saisie n'existe pas. */
    UNKNOWN_COMMAND("Commande inconnue"),
    
    /** Indique qu'aucune commande n'a été fournie. */
    MISSING_COMMAND("Commande manquante"),
    
    /** Indique que le nombre d'arguments fournis ne correspond pas à ce qui est attendu. */
    INVALID_PARAMETERS("Erreur: mauvais nombre de paramètres"),
    
    /** Indique qu'un paramètre numérique est attendu à la place d'une chaîne de caractères. */
    INTEGER_PARAMETER("Erreur : les coordonnées et la longueur doivent être des nombres"),
    
    /** Message affiché lors de la fermeture de l'application. */
    EXIT("Exiting..."),
    
    /** Message affiché lors de la réinitialisation de la zone de dessin. */
    CLEAR("Clearing..."),
    
    /** Message de confirmation pour l'action de tracé. */
    PLOT("plot"),
    
    /** En-tête du menu d'aide. */
    HELP("~~~ Help ~~~"),
    
    /** Indique qu'une opération s'est terminée avec succès. */
    DONE("done"),
    
    /** Indique qu'un identifiant (ID) fourni n'existe pas dans la liste des zones ou calques. */
    UNKNOWN_ID("Id inconnu dans la list");

    /** Le contenu textuel du message. */
    private final String message;

    /**
     * Constructeur de l'énumération.
     * @param message Le texte associé à l'erreur.
     */
    ErrorMessage(String message) {
        this.message = message;
    }

    /**
     * Récupère le texte du message.
     * @return Le message sous forme de chaîne de caractères.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Affiche directement le message sur la sortie standard (console).
     */
    public void printMessage() {
        System.out.println(message);
    }
}