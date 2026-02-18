package shape;

public enum ErrorMessage {
    UNKNOWN_COMMAND("Commande inconnue"),
    MISSING_COMMAND("Commande manquante"),
    INVALID_PARAMETERS("Erreur: mauvais nombre de paramètres"),
    INTEGER_PARAMETER("Erreur : les coordonnées et la longueur doivent être des nombres"),
    EXIT("Exiting..."),
    CLEAR("Clearing..."),
    PLOT("plot"),
    HELP("~~~ Help ~~~"),
    DONE("done"),
    UNKNOWN_ID("Id inconnu dans la list");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}