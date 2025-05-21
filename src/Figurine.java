public class Figurine implements Runnable{

    public int count;
    public int interval;
    Stations st = new Stations();
    public Figurine(int count , int interval, Stations st){
        this.count = count;
        this.interval = interval;
        this.st = st;
    }

    public void run(){
        int i = 1;
        while(i <= count){
            try {
                st.resinPrinter.lock();
                System.out.println("Figurines for Mazes and Monsters: Printing the figurines on Resin Printer");
                Thread.sleep(250); //  Simulate printing time
            } catch (InterruptedException e) {
                System.out.println("Error in figurine printing.");
            } finally {
                st.resinPrinter.unlock();
            }

            try {
                st.airBrush.lock();
                System.out.println("Figurines for Mazes and Monsters: Painting using airbrush");
                Thread.sleep(150); //  Simulate painting time
            } catch (InterruptedException e) {
                System.out.println("Error in figurine painting.");
            } finally {
                st.airBrush.unlock();
            }

            System.out.println("Figurines for Mazes and Monsters: Starting a moral panic about DND and making a movie about it");

            if (i % interval == 0) { // Reports the items within the given interval
                System.out.println( "Figurines for Mazes and Monsters: produced " + i + " items so far.");
            }

            st.incrementTotal(); // increment total count
            i++;

        }
    }
}
