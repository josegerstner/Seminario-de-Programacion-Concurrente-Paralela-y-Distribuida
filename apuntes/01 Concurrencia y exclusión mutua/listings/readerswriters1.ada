   protected body RW is
      entry StartRead
        when not Writing is
      begin
         Readers := Readers + 1;
      end StartRead;

      procedure EndRead is
      begin
         Readers := Readers - 1;
      end EndRead;

      entry StartWrite
        when not Writing and Readers = 0 is
      begin
         Writing := true;
      end StartWrite;

      procedure EndWrite is
      begin
         Writing := false;
      end EndWrite;
   end RW;
