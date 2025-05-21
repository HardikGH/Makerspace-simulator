public class Sak implements Runnable{
    public int count;
    public int interval;
    Stations st = new Stations();

    public Sak(int count , int interval, Stations st){
        this.count = count;
        this.interval = interval;
        this.st = st;
    }

    public void run(){
        int i = 1;
        while (i <= count) {
            System.out.println("SAK scales: Grabbing some aluminum stock");
            try {
                Thread.sleep(100); // Simulating time taken to gather materials
            } catch (InterruptedException e) {
                System.out.println("Error while grabbing aluminum stock.");
            }

            st.mill.lock();
            System.out.println("SAK scales: Throwing it onto the mill to carve out the scales");
            try {
                Thread.sleep(250); // Simulating milling process
            } catch (InterruptedException e) {
                System.out.println("Error during milling.");
            } finally {
                st.mill.unlock();
            }

            System.out.println("SAK scales: Deburring with a file if necessary");
            try {
                Thread.sleep(150); // Simulating deburring process
            } catch (InterruptedException e) {
                System.out.println("Error while deburring.");
            }

            System.out.println("SAK scales: Washing");
            try {
                Thread.sleep(100); // Simulating washing time
            } catch (InterruptedException e) {
                System.out.println("Error while washing.");
            }

            st.toasterOven.lock();
            System.out.println("SAK scales: Throwing into the toaster oven to dry completely");
            try {
                Thread.sleep(200); // Simulating drying process
            } catch (InterruptedException e) {
                System.out.println("Error during drying.");
            } finally {
                st.toasterOven.unlock();
            }

            System.out.println("SAK scales: Anodizing");
            try {
                Thread.sleep(250); // Simulating anodizing process
            } catch (InterruptedException e) {
                System.out.println("Error during anodizing.");
            }

            // Reporting progress at defined intervals
            if (i % interval == 0) {
                System.out.println("SAK scales has produced " + i + " items so far.");
            }
            st.incrementTotal(); // Increment total count
            i++;
        }
    }
}
