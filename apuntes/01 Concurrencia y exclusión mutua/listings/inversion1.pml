mtype = { idle, blocked, nonCS, CS, long };

mtype data = idle, comm = idle, telem = idle;

#define ready(p)  (p != idle && p != blocked)

active proctype Data() {
    do
    ::  data = nonCS;
        enterCS(data);
        exitCS(data);
        data = idle;
    od
}
