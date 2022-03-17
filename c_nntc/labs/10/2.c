#include <stdio.h>
void printb(int num, int byte) {  
  for (int i = (8 * byte) - 1; i>=0; i--) {
    printf("%d", (num & (num << i)) != 0);
  }
  printf("\n"); 
}
int super_glue(int a, int b, int result_byte) {
  int result = 0;
  
  return 0;
}

int main() {
  int a;
  int b;
  scanf("%d", &a);
  scanf("%d", &b);
  printb(a, 2);
  printb(b, 2);
  printb(super_glue(a, b), 4);
  printf("%d\n", super_glue(a, b));
  return 0;
}
