#include <stdio.h>

int main() {
  /* Функция getchar считывает один символ из std */
  int ch = getchar();
  /* EOF -- End Of File */
  while (ch != EOF) {
    /* putchar записывает символ в стандартный вывода */
    putchar(ch);
    ch = getchar();
  }
   return 0;
}
