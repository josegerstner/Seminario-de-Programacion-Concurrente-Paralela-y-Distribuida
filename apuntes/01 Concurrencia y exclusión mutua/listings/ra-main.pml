proctype Main( byte myID ) {
   do ::
      atomic {
         requestCS[myID] = true ;
         myNum[myID] = highestNum[myID] + 1 ;
      }
      for (J,0,NPROCS-1)
         if
         :: J != myID ->
            ch[J] ! request, myID, myNum[myID];
         :: else
         fi
      rof (J);
      for (K,0,NPROCS-2)
         ch[myID] ?? reply, _ , _;
      rof (K);
      critical_section();
      requestCS[myID] = false;
      byte N;
      do
         :: empty(deferred[myID]) -> break;
         :: deferred[myID] ? N -> ch[N] ! reply, 0, 0
      od
   od
}
