proctype Receive( byte myID ) {
    byte reqNum, source;
    do ::
        ch[myID] ?? request, source, reqNum;
        highestNum[myID] =
            ((reqNum > highestNum[myID]) ->
                reqNum : highestNum[myID]);
        atomic {
            if
            :: requestCS[myID] &&
                 ( (myNum[myID] < reqNum) ||
                 ( (myNum[myID] == reqNum) &&
                        (myID < source)
                 ) ) ->
                    deferred[myID] ! source
            :: else ->
                ch[source] ! reply, 0, 0
            fi
        }
    od
}

