protected type Semaphore(Initial: Natural) is
  entry Wait;
  procedure Signal;
private
  Count: Natural := Initial;
end Semaphore;

protected body Semaphore is
  entry Wait when Count > 0 is
  begin
    Count := Count - 1;
  end Wait;

  procedure Signal is
  begin
    Count := Count + 1;
    end Signal;
end Semaphore;
