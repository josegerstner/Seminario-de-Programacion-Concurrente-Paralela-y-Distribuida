import java.util.concurrent.Semaphore;
class CountSem extends Thread {
  static volatile int n = 0;
  static Semaphore s = new Semaphore(1);

  public void run() {
    int temp;
    for (int i = 0; i < 10; i++) {
      try {
        s.acquire();
      }
      catch (InterruptedException e) {}
      temp = n;
      n = temp + 1;
      s.release();
    }
  }

  public static void main(String[] args) {
      /* As before */
  }
}
