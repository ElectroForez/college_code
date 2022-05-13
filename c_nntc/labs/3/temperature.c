#include <stdio.h>

int main() {
  int t1C = 0;
  int t2C = 100;
  printf("C\tK\tF\n");
  for (; t1C <= t2C; t1C = t1C + 10) {
    double tK = t1C + 273.15;
    double tF =  9 / 5 * t1C + 32;
    printf("%d\t%3.2f\t%3.2f\n", t1C, tK, tF);
  }
  return 0;
}
