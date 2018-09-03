byte critical = 0;

bool PinCS = false;

#define nostarve PinCS   /* LTL claim <> nostarve */

active proctype p() {
  do ::
     /* preprotocol */
     critical++;
     assert(critical<= 1);
     PinCS = true;
     critical--;
     /* postprotocol */
  od
}
