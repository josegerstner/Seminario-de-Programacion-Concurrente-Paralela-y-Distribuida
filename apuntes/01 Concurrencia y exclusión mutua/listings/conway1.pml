active proctype Output() {
  byte c, count = 0;
  do
  :: pipe ? c;
     outC ! c;
     count++;
     if
     :: count >= K ->
        outC ! '\n';
        count = 0
     :: else
     fi
  od
}