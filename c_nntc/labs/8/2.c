#include <stdio.h>

enum {
  MAX = 20
};

void reverse(char arr[MAX], int i) {
  if (arr[i] == '\0')
    return;
  else {
    reverse(arr, i + 1);
    putchar(arr[i]);
  }
}


int main() {
  int ch;
  char str[MAX];
  int i = 0;
  while((ch = getchar()) != EOF) {
    if (i > MAX) {
      dprintf(2, "Length must be not more than %d symbols\n", MAX);
      return 0;
    }
    str[i++] = ch;
   
  }
  reverse(str, 0);
  printf("\n");
  return 0;
}
