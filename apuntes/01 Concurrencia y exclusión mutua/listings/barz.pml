byte gate = 1;
int count = K;

active [N] proctype P () {
  do ::
    atomic { gate > 0; gate--; }
    d_step {
      count--;
      if
      :: count > 0 -> gate++
      :: else
      fi
    }
    /*  Critical section  */
    d_step {
      count++;
      if
      :: count == 1 -> gate++
      :: else
      fi
    }
  od
}
