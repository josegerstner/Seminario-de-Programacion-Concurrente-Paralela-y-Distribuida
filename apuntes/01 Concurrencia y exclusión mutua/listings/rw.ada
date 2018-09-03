protected RW is
  procedure Write(I: Integer);
  function Read return Integer;
private
  N: Integer := 0;
end RW;

protected body RW is
  procedure Write(I: Integer) is
  begin
    N := I;
  end Write;
  function Read return Integer is
  begin
    return N;
  end Read;
end RW;
