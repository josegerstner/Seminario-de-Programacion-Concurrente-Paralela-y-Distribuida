public class Note {
    public String id;
    public Object[] p;

    // Constructor for an array of objects
    public Note (String id, Object[] p) {
        this.id = id;
        if (p != null) this.p = p.clone();
    }

    // Constructor for a single integer
    public Note (String id, int p1) {
        this(id, new Object[]{new Integer(p1)});
    }

    // Accessor for a single integer value
    public int get(int i) {
        return ((Integer)p[i]).intValue();
    }
}
