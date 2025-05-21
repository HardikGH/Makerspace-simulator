public class Flashlight implements Runnable {
    public int count;
    public int interval;
    Stations st = new Stations();
    public Flashlight(int count , int interval, Stations st){
        this.count = count;
        this.interval = interval;
        this.st = st;
    }

    public void run(){
        int i = 1;
        while (i <= count) {

            st.lathe.lock();
            System.out.println("Flashlight: Throwing some round stock into the lathe to hollow it out");
            try {
                Thread.sleep(200); // Simulating lathe operation time
            } catch (InterruptedException e) {
                System.out.println("Error during lathe operation.");
            } finally {
                st.lathe.unlock(); // Unlock lathe after use
            }

            System.out.println("Flashlight: Drill a couple holes");
            try {
                Thread.sleep(100); // Simulating drilling process
            } catch (InterruptedException e) {
                System.out.println("Error during drilling.");
            }

            // Locking soldering iron to assemble the electrical components
            st.solderingIron.lock();
            System.out.println("Flashlight: Using the soldering iron to connect some batteries, an LED, and a switch");
            try {
                Thread.sleep(250); // Simulating soldering time
            } catch (InterruptedException e) {
                System.out.println("Error during soldering.");
            } finally {
                st.solderingIron.unlock(); // Unlock soldering iron after use
            }

            // Report the production progress at defined intervals
            if (i % interval == 0) {
                System.out.println("Flashlight has produced " + i + " items so far.");
            }
            st.incrementTotal(); // Increment total count
            i++;
        }
    }
}
