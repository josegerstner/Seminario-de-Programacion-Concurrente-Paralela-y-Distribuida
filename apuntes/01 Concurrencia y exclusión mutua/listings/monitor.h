bool lock = false;

typedef Condition {
   bool gate;
   byte waiting;
}

#define emptyC(C) (C.waiting == 0)

inline enterMon() {
   atomic {
      !lock;
      lock = true;
   }
}

inline leaveMon() {
  lock = false;
}
