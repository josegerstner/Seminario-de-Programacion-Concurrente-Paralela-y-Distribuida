bool wantp = false, wantq = false;
byte turn = 1;

active proctype p() {
  do :: wantp = true;
    do :: !wantq -> break;
       :: else ->
          if :: (turn == 1)
             :: (turn == 2) ->
                wantp = false; (turn == 1); wantp = true
          fi
    od;
    printf("MSC: p in CS\n") ;
    turn = 2; wantp = false
 od
}
