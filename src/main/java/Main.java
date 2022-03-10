import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int loops = 10000;
        List<String> imeis = Arrays.asList("XL3189203", "I893erLm", "U892746");

        while (loops > 0) {
            Thread[] threads = new Thread[3];
            for (int i = 0; i < 3; i++) {
                threads[i] = new Thread(new Sender(imeis.get(i)));
                threads[i].start();
            }

            for (int i = 0; i < 3; i++) {
                threads[i].join();
            }

            loops--;

            System.out.println("Am executat a " + loops + " data");

            Thread.sleep(10000); //10 seconds

        }

    }
}
