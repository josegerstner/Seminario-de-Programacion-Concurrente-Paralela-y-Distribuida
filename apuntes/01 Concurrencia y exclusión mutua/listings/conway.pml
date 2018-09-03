#define N 9
#define K  4

chan inC, pipe, outC  = [0] of { byte };

active proctype Compress() {
  byte previous, c, count = 0;
  inC ? previous;
  do
  :: inC ? c ->
     if
     :: (c == previous) && (count < N-1) -> count++
     :: else ->
        if
        :: count > 0 ->
           pipe ! count+1;
           count = 0
        :: else
        fi;
        pipe ! previous;
        previous = c;
     fi
  od
}
