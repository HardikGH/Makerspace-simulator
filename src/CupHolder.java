public class CupHolder implements Runnable{
    public int count;
    public int interval;
    Stations st = new Stations();

    public CupHolder(int count , int interval , Stations st){
        this.count = count;
        this.interval = interval;
        this.st = st;
    }
    public void run(){
        int i = 1;
        while (i <= count) {
            st.toasterOven.lock();
            System.out.println("Cup holder: Throwing the filament into the toaster oven to dry it");
            try {
                Thread.sleep(150); // Sleep to simulate drying time
            } catch (InterruptedException e) {
                System.out.println("Error during toaster oven drying.");
            } finally {
                st.toasterOven.unlock();
            }

            st.fdmPrinter.lock();
            System.out.println("Cup holder: Produce the basic holder on the FDM printer");
            try {
                Thread.sleep(200); // Sleep to simulate the printing process
            } catch (InterruptedException e) {
                System.out.println("Error during FDM printing.");
            } finally {
                st.fdmPrinter.unlock();
            }

            st.airBrush.lock();
            System.out.println("Cup holder: Using pure acetone in the airbrush station to smooth the layer lines");
            try {
                Thread.sleep(200); // Sleep to simulate airbrushing process
            } catch (InterruptedException e) {
                System.out.println("Error during airbrushing.");
            } finally {
                st.airBrush.unlock();
            }

            System.out.println("Cup holder: Set it aside to dry for a bit");

            // Report the progress at defined intervals
            if (i % interval == 0) {
                System.out.println("Cup Holder has produced " + i + " items so far.");
            }
            st.incrementTotal(); // Increment total count
            i++;
        }
    }
}
