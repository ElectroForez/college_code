#include <stdio.h>

int main() {
  dprintf(1, "OUT\n");
  dprintf(2, "ERR\n");
  dprintf(0, "IN\n");
  return 0;
}
