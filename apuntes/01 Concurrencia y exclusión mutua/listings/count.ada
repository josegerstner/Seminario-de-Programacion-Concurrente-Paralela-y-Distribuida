with Ada.Text_IO; use Ada.Text_IO;
procedure Count is
   N: Integer := 0;
   pragma Volatile(N);

   task type Count_Task;
   task body Count_Task is
      Temp: Integer;
   begin
      for I in 1..10 loop
         Temp := N;
         N := Temp + 1;
      end loop;
   end Count_Task;

begin
   declare
      P, Q: Count_Task;
   begin
      null;
   end;
   Put_Line("The value of N is " & Integer'Image(N));
end Count;
