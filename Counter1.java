public class Counter1 {
  private int c = 0;

  public int value() {
    return c;
  }

  public void increment() {
    c++;
  }

  public void decrement() {
    c--;
  }

  public static void main(String[] args) throws InterruptedException {
    Counter1 c = new Counter1();
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
  private Counter1 Counter1;
  private boolean up;

  public Updator(Counter1 c, boolean isUp) {
    Counter1 = c;
    up = isUp;
  }

  public void run() {
    for (int i = 0; i < 500; i++) {
      if (up) {
        Counter1.increment();
      } else {
        Counter1.decrement();
      }
    }
  }
}
