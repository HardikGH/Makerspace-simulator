import java.lang.module.ModuleReader;

public class MotorController implements Runnable{
    public int count;
    public int interval;
    Stations st = new Stations();

    public MotorController(int count , int interval, Stations st){
        this.count = count;
        this.interval = interval;
        this.st = st;
    }
    public void run(){
        int i = 1;
        while(i <= count){
            st.solderingIron.lock();
            System.out.println("Motor Controllers with Custom PCBs: Using the soldering iron to tin the through-hole components");
            try {
                Thread.sleep(150); // Simulating soldering time
            } catch (InterruptedException e) {
                System.out.println("Error during soldering process.");
            } finally {
                st.solderingIron.unlock();
            }


            st.mill.lock();
            System.out.println("Motor Controllers with Custom PCBs: Running the board through the mill to cut out the traces");
            try {
                Thread.sleep(200); // Simulating milling process
            } catch (InterruptedException e) {
                System.out.println("Error during milling.");
            } finally {
                st.mill.unlock();
            }

            System.out.println("Motor Controllers with Custom PCBs: Brushing on some flux");
            try {
                Thread.sleep(200); // Simulating flux application time
            } catch (InterruptedException e) {
                System.out.println("Error while applying flux.");
            }

            System.out.println("Motor Controllers with Custom PCBs: Spreading on the solder paste");
            try {
                Thread.sleep(200); // Simulating solder paste application
            } catch (InterruptedException e) {
                System.out.println("Error while spreading solder paste.");
            }


            st.toasterOven.lock();
            System.out.println("Motor Controllers with Custom PCBs: Flowing the solder in the toaster oven");
            try {
                Thread.sleep(500); // Simulating solder flow process
            } catch (InterruptedException e) {
                System.out.println("Error during soldering in toaster oven.");
            } finally {
                st.toasterOven.unlock();
            }

            st.mill.lock();
            System.out.println("Motor Controllers with Custom PCBs: Running it through the mill again to clear out any bridges");
            try {
                Thread.sleep(200); // Simulating milling process
            } catch (InterruptedException e) {
                System.out.println("Error during secondary milling.");
            } finally {
                st.mill.unlock();
            }

            st.solderingIron.lock();
            System.out.println("Motor Controllers with Custom PCBs: Using the soldering iron to touch up any weak joints");
            try {
                Thread.sleep(150); // Simulating touch-up soldering
            } catch (InterruptedException e) {
                System.out.println("Error during soldering touch-up.");
            } finally {
                st.solderingIron.unlock();
            }

            System.out.println("Motor Controllers with Custom PCBs: Plugging in the motors");
            try {
                Thread.sleep(100); // Simulating motor plug-in process
            } catch (InterruptedException e) {
                System.out.println("Error during motor plug-in.");
            }

            // Reporting progress at defined intervals
            if (i % interval == 0) {
                System.out.println("Motor Controllers with Custom PCBs has produced " + i + " items so far.");
            }
            st.incrementTotal(); // Increment total count
            i++;
        }
    }
}
