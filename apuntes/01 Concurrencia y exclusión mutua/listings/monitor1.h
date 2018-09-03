inline waitC(C) {
   atomic {
      C.waiting++;
      lock = false;    /* Exit monitor */
      C.gate;          /* Wait for gate */
      lock = true;     /* IRR */
      C.gate = false;  /* Reset gate */
      C.waiting--;
   }
}

inline signalC(C) {
   atomic {
      if 
         /* Signal only if waiting */
      :: (C.waiting > 0) ->
        C.gate = true;
        !lock;       /* IRR - wait for released lock */
        lock = true; /* Take lock again */
      :: else
      fi;
   }
}

