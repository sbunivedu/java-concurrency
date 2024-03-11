public class SynchronizedCounter {
  private int c = 0;

  public synchronized void increment() {
    c++;
  }

  public synchronized void decrement() {
    c--;
  }

  public synchronized int value() {
    return c;
  }

  public static void main(String[] args) throws InterruptedException {
    SynchronizedCounter c = new SynchronizedCounter();
    Updator up = new Updator(c, true);
    Updator down = new Updator(c, false);
    up.start();
    down.start();
    up.join();
    down.join();
    System.err.println("count=" + c.value());
  }
}

class Updator extends Thread {
  private SynchronizedCounter counter;
  private boolean up;

  public Updator(SynchronizedCounter c, boolean isUp) {
    counter = c;
    up = isUp;
  }

  public void run() {
    for (int i = 0; i < 500; i++) {
      if (up) {
        counter.increment();
      } else {
        counter.decrement();
      }
    }
  }
}
