#include <stdio.h>

int main() {
  char word[] = "ABASA";
  for (int i = 1; i < 110; i++) {    
    printf("\033[%dm%s\033[0m = %d\n", i, word, i);
  }
  printf("\033[6;7;31;94m%s\033[0m\n", word);
  return 0;
}
