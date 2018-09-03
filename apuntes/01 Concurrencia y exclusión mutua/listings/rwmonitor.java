class RWMonitor {
  volatile int readers = 0;
  volatile boolean writing = false;

  synchronized void StartRead() {
    while (writing) wait();
    readers = readers + 1;
    notifyAll();
  }
  synchronized void EndRead() {
    readers = readers - 1;
    if (readers == 0) notifyAll();
  }

  synchronized void StartWrite() {
    while (writing || (readers != 0)) wait();
    writing = true;
  }

  synchronized void EndWrite() {
    writing = false;
    notifyAll();
  }
}
