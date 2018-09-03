  synchronized int Take() {
    int temp;
    while (Count == 0)
      try {
         wait();
      } catch (InterruptedException e) {}
    temp = Buffer[Oldest];
    Oldest = (Oldest + 1) % N;
    Count = Count - 1;
    notifyAll();
    return temp;
  }
}