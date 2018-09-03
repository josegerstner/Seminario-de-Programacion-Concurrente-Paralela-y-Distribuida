private class Worker extends Thread {
    public void run() {
        Note task = new Note("task");
        while (true) {
            Note t = space.removenote(task);
            int row = t.get(0), col = t.get(1);
            Note r = space.readnote(match("a", row));
            Note c = space.readnote(match("b", col));
            int ip = 0;
            for (int i = 1; i <= SIZE; i++)
                ip = ip + r.get(i)*c.get(i);
            space.postnote(new Note("result", row, col, ip));
        }
    }
}