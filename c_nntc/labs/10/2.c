#include <stdio.h>
#include <stdlib.h>

void printb(int num, int byte) {  
  for (int i = (8 * byte) - 1; i>=0; i--) {
    printf("%d", (num & (num << i)) != 0);
  }
  printf("\n"); 
}f

int super_glue(int a, int b, int num_byte) {
  int result = a;
  result = (result << (num_byte * 8)) | b;
  return result;
}

int main(int argc, char* argv[]) {
  int a = atoi(argv[1]);
  int b = atoi(argv[2]);
  printb(a, 2);
  printb(b, 2);
  printb(super_glue(a, b, 2), 4);
  printf("%d\n", super_glue(a, b, 2));
  return 0;
}
