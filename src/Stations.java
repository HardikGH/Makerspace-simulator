import java.util.concurrent.locks.ReentrantLock;
public class Stations{
    //locks to represent all the stations in the makerspace.
    public ReentrantLock fdmPrinter;
    public ReentrantLock resinPrinter;
    public ReentrantLock solderingIron;
    public ReentrantLock toasterOven;
    public ReentrantLock lathe;
    public ReentrantLock mill;
    public ReentrantLock airBrush;
    public ReentrantLock lock; // lock for incrementing the total quantity safely
    int total;

    //Constructor to initialize all the stations
    public Stations(){
        fdmPrinter = new ReentrantLock();
        resinPrinter = new ReentrantLock();
        solderingIron = new ReentrantLock();
        toasterOven = new ReentrantLock();
        lathe = new ReentrantLock();
        mill = new ReentrantLock();
        airBrush = new ReentrantLock();
        lock = new ReentrantLock();
    }

    // Method to safely increment the total count of produced items
    public void incrementTotal(){
        lock.lock();
        total++;
        lock.unlock();
    }
}
