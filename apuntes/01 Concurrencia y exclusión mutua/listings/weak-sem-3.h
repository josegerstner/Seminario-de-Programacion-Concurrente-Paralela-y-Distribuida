typedef Semaphore {
	byte count;
	bool blocked[NPROCS];
};

inline initSem(S, n) {
  S.count = n 
}
