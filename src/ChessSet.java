public class ChessSet implements Runnable {
    public int count;
    public int interval;
    Stations st = new Stations();

    public ChessSet(int count, int interval, Stations st) {
        this.count = count;
        this.interval = interval;
        this.st = st;
    }

    public void run() {
        int i = 1;
        while (i <= count) {
            try {
                st.resinPrinter.lock();
                System.out.println("Chess Set: Printing out the white pieces using the resin printer");
                Thread.sleep(200); // Simulate 3D printing time
            } catch (InterruptedException e) {
                System.out.println("Error while printing white pieces.");
            } finally {
                st.resinPrinter.unlock();
            }

            try {
                st.lathe.lock();
                System.out.println("Chess Set: Turning the white rooks on the lathe");
                Thread.sleep(150); // Simulate lathe work
            } catch (InterruptedException e) {
                System.out.println("Error while turning white rooks.");
            } finally {
                st.lathe.unlock();
            }

            try {
                st.resinPrinter.lock();
                System.out.println("Chess Set: Printing out the black pieces using the resin printer");
                Thread.sleep(200); // Simulate printing time
            } catch (InterruptedException e) {
                System.out.println("Error while printing black pieces.");
            } finally {
                st.resinPrinter.unlock();
            }

            try {
                st.lathe.lock();
                System.out.println("Chess Set: Turning the black rooks on the lathe");
                Thread.sleep(150); // Simulate lathe work
            } catch (InterruptedException e) {
                System.out.println("Error while turning black rooks.");
            } finally {
                st.lathe.unlock();
            }

            try {
                st.fdmPrinter.lock();
                System.out.println("Chess Set: Using the FDM printer to produce the board");
                Thread.sleep(250); // Simulate FDM printing time
            } catch (InterruptedException e) {
                System.out.println("Error while printing chessboard.");
            } finally {
                st.fdmPrinter.unlock();
            }

            System.out.println("Chess Set: Boxing all the parts up together");
            try {
                Thread.sleep(100); // Simulate packaging time
            } catch (InterruptedException e) {
                System.out.println("Error while boxing chess set.");
            }

            // Print progress at the specified interval
            if (i % interval == 0) {
                System.out.println("Chess Set has produced " + i + " items so far.");
            }

            // increment total count
            st.incrementTotal();
            i++;
        }
    }
}
