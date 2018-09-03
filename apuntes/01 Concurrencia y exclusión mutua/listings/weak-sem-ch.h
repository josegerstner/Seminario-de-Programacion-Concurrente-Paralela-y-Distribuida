typedef Semaphore {
	byte count;
	chan ch = [NPROCS] of { pid };
	byte temp, i;
};
inline initSem(S, n) { S.count = n }
inline wait(S) {
   atomic {
     if
     :: S.count >= 1 -> S.count--;
     :: else -> S.ch ! _pid; !(S.ch ?? [eval(_pid)])
     fi
   }
}
inline signal(S) {
   atomic {
     S.i = len(S.ch);
     if
     :: S.i == 0 -> S.count++ /*No blocked process, increment count*/
     :: else -> 
	     do
       :: S.i == 1 -> S.ch ? _; break /*Remove only blocked process*/
       :: else -> S.i--;
         S.ch ? S.temp;
         if :: break :: S.ch ! S.temp fi
       od
     fi
   }
}
