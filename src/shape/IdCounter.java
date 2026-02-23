package shape;

/**
 * Classe IdCounter
 * * Gère la génération d'identifiants uniques pour les différentes entités du système (Area, Layer, Shape).
 * Implémente le pattern Singleton pour assurer l'unicité du compteur et la synchronisation.
 */
public class IdCounter {
    /** L'instance unique de la classe IdCounter. */
    private static IdCounter instance;
    
    /** La valeur actuelle du compteur d'identifiants. */
    private int id;

    /**
     * Constructeur privé pour empêcher l'instanciation externe.
     * Initialise le compteur à 0.
     */
    private IdCounter(){
        id=0;
    }

    /**
     * Récupère l'instance unique de la classe. 
     * Si l'instance n'existe pas, elle est créée (Lazy Initialization).
     * La méthode est synchronisée pour garantir la sécurité entre les threads (Thread-Safe).
     * * @return L'instance unique de IdCounter.
     */
    public static synchronized IdCounter getInstance(){
        if (instance==null){
            instance = new IdCounter();
        }

        return instance;
    }

    /**
     * Génère et retourne l'identifiant suivant.
     * La valeur est incrémentée après chaque appel.
     * La méthode est synchronisée pour éviter que deux entités ne reçoivent le même ID.
     * * @return L'identifiant unique généré (entier).
     */
    public synchronized int getNextId(){
        return id++;
    }
}