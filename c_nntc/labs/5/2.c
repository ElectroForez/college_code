#include <stdio.h>
#define ASCII_LENGTH 128
int main(){
  int chars_count[ASCII_LENGTH] = { 0 };
  int ch;
  while((ch = getchar()) != EOF) {
    chars_count[ch]++;
  }

  for (int idCh = 0; idCh < ASCII_LENGTH; idCh++) {
    if (chars_count[idCh] != 0)
      printf("%3d (%c): %d\n", idCh, idCh, chars_count[idCh]);
  }
  
  return 0;
}
