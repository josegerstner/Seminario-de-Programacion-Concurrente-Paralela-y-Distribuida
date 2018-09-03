chan space = [25] of { byte, short, short, short, short };

active[WORKERS] proctype Worker() {
    short row, col, ip, r1, r2, r3, c1, c2, c3;
    do
    :: space ??  't',  row, col, _, _;
       space ??  <'a', eval(row), r1, r2, r3>;
       space ??  <'b', eval(col), c1, c2, c3>;
       ip = r1*c1 + r2*c2 + r3*c3;
       space !  'r', row, col, ip, 0;
    od;
}
