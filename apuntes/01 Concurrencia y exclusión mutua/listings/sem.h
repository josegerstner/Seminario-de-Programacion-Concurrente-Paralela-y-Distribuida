inline wait( s )  {
        atomic { s > 0 ; s-- }
}

inline signal( s ) { s++ }

