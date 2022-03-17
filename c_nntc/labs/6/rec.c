#include <stdio.h>
#include <string.h>

  
void flip_str(char str[], int i) {
  if (i < STR_SIZE) {
    flip_str(str, i + 1);
  }
  putchar(str[i]);
}

int main() {
  char word[] = "abasa";
  flip_str(word, 0);
  printf("\n");
  return 0;
}
