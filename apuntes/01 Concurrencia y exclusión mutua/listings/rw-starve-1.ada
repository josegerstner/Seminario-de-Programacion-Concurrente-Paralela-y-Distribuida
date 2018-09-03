  protected RW is
    entry Start_Read;
    procedure End_Read;
    entry Start_Write;
    procedure End_Write;
  private
    Waiting_To_Read : integer := 0;
    Readers : Natural := 0;
    Writing : Boolean := false;
  end RW;
