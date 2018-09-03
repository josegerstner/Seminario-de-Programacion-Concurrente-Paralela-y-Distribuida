  protected RW is
    entry StartRead;
    procedure EndRead;
    entry Startwrite;
    procedure EndWrite;
    function NumberReaders return Natural;
  private
    entry ReadGate;
    entry WriteGate;
    Readers: Natural :=0;
    Writing: Boolean := false;
  end RW;