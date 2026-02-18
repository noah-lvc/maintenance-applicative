package shape;

public class IdCounter {
    private static IdCounter instance;
    private int id;

    private IdCounter(){
        id=0;
    }

    public static synchronized IdCounter getInstance(){
        if (instance==null){
            instance = new IdCounter();
        }

        return instance;
    }

    public synchronized int getNextId(){
        return id++;
    }
}