public class Toaster implements Runnable {
    public int count;
    public int interval;
    Stations st = new Stations();

    public Toaster(int count, int interval, Stations st) {
        this.count = count;
        this.interval = interval;
        this.st = st;
    }

    public void run() {
        int i = 1;
        while (i <= count) {
            try {
                st.toasterOven.lock();
                System.out.println("Toaster pastry: Popping a pastry into the toaster oven");
                Thread.sleep(200); // Simulate the baking time
            } catch (InterruptedException e) {
                System.out.println("Error while toasting the pastry.");
            } finally {
                st.toasterOven.unlock();
            }

            // Simulating the sequence of eating a hot pastry
            System.out.println("Toaster pastry: Consuming half the pastry");
            try {
                Thread.sleep(100); // Pause to simulate eating
            } catch (InterruptedException e) {
                System.out.println("Error while consuming the pastry.");
            }

            System.out.println("Toaster pastry: Regretting not letting the pastry cool");
            try {
                Thread.sleep(50); // Short pause for regret
            } catch (InterruptedException e) {
                System.out.println("Error while regretting.");
            }

            System.out.println("Toaster pastry: Resuming consuming the pastry");
            try {
                Thread.sleep(100); // Finish eating
            } catch (InterruptedException e) {
                System.out.println("Error while resuming consumption.");
            }

            System.out.println("Toaster pastry: Wondering if it’s smart to use the same oven for both pastries and lead solder");

            // Print progress at the specified interval
            if (i % interval == 0) {
                System.out.println("Toaster pastry has produced " + i + " items so far.");
            }

            //increment total count
            st.incrementTotal();
            i++;
        }
    }
}
