#include "reader.h"
#include <math.h>


int nint(double x)
{
  x = x+0.5;
  int k = (int)x;
  return k;
}

int EUC2DDistances(double x1, double y1, double x2, double y2)
{
  int dist = nint( sqrt( pow(x1-x2, 2) + pow(y1-y2, 2) ) );
  return dist;
}
