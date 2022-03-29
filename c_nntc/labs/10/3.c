#include<stdio.h>

void printb(int number) {
  int i = 31;
  printf("%d", (number & (1 << i)) == 0); 
  for (--i; i >=0; i--) {
    printf("%d", (number & (1 << i)) != 0);
  }
  printf("\n");    
}

int nulls_bit(int num){
  int count = 0;
  for (int i=0;  i < 32; i++) {
    if (((1 <<  i) & num) == 0)
      count++;
  }
  return count;
}

int main() {
  int num;
  scanf("%d", &num);
  printb(num);
  printf("%d\n", nulls_bit(num));
  return 0;
}
