bit sem = 1;

inline enterCS(state) {
    atomic {
        if
        :: sem == 0 ->
             state = blocked;
             sem != 0;
        :: else ->
        fi;
        sem = 0;
        state = CS;
    }
}

inline exitCS(state) {
    atomic {
        sem = 1;
        state = idle
    }
}