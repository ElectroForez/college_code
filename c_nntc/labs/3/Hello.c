#include <stdio.h>
#include <string.h>

#define MAX_BUF_LENGTH (1024)

int main() {
  int a = 10;
  char spaces[MAX_BUF_LENGTH] = "";
  for (int i = 0; i < a; i++) {
    printf("%sHello, world! %d\n", spaces, i);  
    strcat(spaces, " ");
  }
  return 0;
}
