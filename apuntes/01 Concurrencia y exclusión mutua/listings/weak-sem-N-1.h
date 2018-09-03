inline signal(S) {
   atomic {
     S.i = 0;
     S.choice = 255;
     do
     :: (S.i == NPROCS) -> break
     :: (S.i < NPROCS) && !S.blocked[S.i] -> S.i++
     :: else -> 
         if
         :: (S.choice == 255) -> S.choice = S.i
         :: (S.choice != 255) -> S.choice = S.i
         :: (S.choice != 255) ->
         fi;
         S.i++
     od;
     if
     :: S.choice == 255 -> S.count++
     :: else -> S.blocked[S.choice] = false
     fi
   }
}