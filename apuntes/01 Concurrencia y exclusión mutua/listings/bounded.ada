task body Buffer is
  B: Buffer_Array;
  In_Ptr, Out_Ptr, Count: Index := 0;

begin
  loop
    select
      when Count < Index'Last =>
        accept Append(I: in Integer) do
            B(In_Ptr) := I;
        end Append;
      Count := Count + 1; In_Ptr := In_Ptr + 1;
    or
      when Count > 0 =>
        accept Take(I: out Integer) do
            I := B(Out_Ptr);
        end Take;
      Count := Count - 1; Out_Ptr := Out_Ptr + 1;
    or
        terminate;
    end select;
  end loop;
end Buffer;