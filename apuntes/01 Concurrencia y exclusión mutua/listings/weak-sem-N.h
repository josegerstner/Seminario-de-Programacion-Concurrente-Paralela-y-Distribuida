typedef Semaphore {
	byte count;
	bool blocked[NPROCS];
  byte i, choice;
};

inline initSem(S, n) {
  S.count = n
}

inline wait(S) {
   atomic {
     if
     :: S.count >= 1 -> S.count--
     :: else ->
          S.blocked[_pid-1] = true;
          !S.blocked[_pid-1]
     fi
   }
}
