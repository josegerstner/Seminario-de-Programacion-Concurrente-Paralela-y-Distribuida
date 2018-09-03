never {    /* !(<>nostarve) */
accept_init:
T0_init:
    if
    :: (! ((nostarve))) -> goto T0_init
    fi;
}

never {    /* !([]<>nostarve) */
T0_init:
    if
    :: (! ((nostarve))) -> goto accept_S4
    :: (1) -> goto T0_init
    fi;
accept_S4:
    if
    :: (! ((nostarve))) -> goto accept_S4
    fi;
}
