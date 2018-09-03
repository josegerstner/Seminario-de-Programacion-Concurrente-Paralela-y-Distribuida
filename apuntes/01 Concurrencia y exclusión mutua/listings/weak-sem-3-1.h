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

inline signal(S) {
   atomic {
     if
     :: S.blocked[0] -> S.blocked[0] = false
     :: S.blocked[1] -> S.blocked[1] = false
     :: S.blocked[2] -> S.blocked[2] = false
     :: else -> S.count++
     fi
   }
}
