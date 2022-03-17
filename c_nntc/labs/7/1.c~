#include <stdio.h>
#define ASCII_LENGTH 128

int get_stat(int chars_count[ASCII_LENGTH]) {
  int total_count = 0;
  int ch;
  while((ch = getchar()) != EOF) {
    chars_count[ch]++;
    total_count++;
  }
  
  return total_count;
}
  
void print_stat(int chars_count[ASCII_LENGTH], int total_count) {
  float unit = 0.2;
  
  for (int idCh = 0; idCh < ASCII_LENGTH; idCh++) {
    if (chars_count[idCh] != 0) {
      double perc = ((double)chars_count[idCh] / (double)total_count) * 100;
      printf("%3d (%c): %3d %5.2f ", idCh, idCh, chars_count[idCh], perc);
      int count_unit = perc / unit;
      for (int i = 0; i < count_unit; i++) {
	printf("#");
      }
      printf("\n");
    }
  }
}


int main(){
  int chars_count[ASCII_LENGTH] = { 0 };
  int total_count = get_stat(chars_count);
  print_stat(chars_count, total_count);

  return 0;
}
