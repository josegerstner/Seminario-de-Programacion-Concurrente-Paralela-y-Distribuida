#define inherit(p) (p == CS)

active proctype Data() {
  do
  ::  data = nonCS;
      assert( ! (telem == CS && comm == long) );
      enterCS(data); exitCS(data);
      data = idle;
  od
}

active proctype Comm()
  provided (!ready(data) && !inherit(telem))
    { ... }

active proctype Telem()
  provided  (!ready(data) && !ready(comm) || inherit(telem))
    { ... }