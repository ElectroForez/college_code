#include <stdio.h>


void printb(int number) {
  for (int i = 31; i >=0; i--) {
    printf("%d", (number & (1 << i)) != 0);
  }
  printf("\n");    
}

int main() {
  int a;
  scanf("%d", &a);
  printb(a);  
  return 0;
}
