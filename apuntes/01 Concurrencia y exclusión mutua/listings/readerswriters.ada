   protected RW is
      entry StartRead;
      procedure EndRead;
      entry Startwrite;
      procedure EndWrite;
   private
      Readers: Natural :=0;
      Writing: Boolean := false;
   end RW;
