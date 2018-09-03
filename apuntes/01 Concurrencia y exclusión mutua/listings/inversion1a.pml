active proctype Comm() provided (!ready(data)) {
    do
    ::  comm = long;
        comm = idle;
    od
}

active proctype Telem() provided (!ready(data) && !ready(comm)) {
    do
    ::  telem = nonCS;
        enterCS(telem);
        exitCS(telem);
        telem = idle;
    od
}
