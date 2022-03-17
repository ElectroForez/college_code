#include <stdio.h>
#define ASCII_LENGTH 128
int main(){
  int chars_count[ASCII_LENGTH] = { 0 };
  int chars_popularity[ASCII_LENGTH] = { 0 };
  int ch;
  int total_count = 0;
  float unit = 0.2;
  
  while((ch = getchar()) != EOF) {
    chars_count[ch]++;
    total_count++;
  }

  for (int idCh = 0; idCh < ASCII_LENGTH; idCh++) {
    chars_popularity[idCh] = idCh;
  }

  for (int i = 0; i < ASCII_LENGTH - 1; i++) {
    for (int j = i; j < ASCII_LENGTH - 1; j++) {
      if (chars_count[j] > chars_count[j + 1]) {
	int t;
	t = chars_count[j];
	chars_count[j] = chars_count[j + 1];
	chars_count[j + 1] = t;
	
	t = chars_popularity[j];
	chars_popularity[j] = chars_popularity[j + 1];
	chars_popularity[j + 1] = t;
      }
    }
  }
  
  for (int idCh = 0; idCh < ASCII_LENGTH; idCh++) {
    if (chars_count[idCh] != 0) {
      double percent = ((double)chars_count[idCh] / (double)total_count) * 100;
      printf("%3d (%c): %3d %5.2f ", chars_popularity[idCh], chars_popularity[idCh], chars_count[idCh], percent);
      int count_unit = percent / unit;
      for (int i = 0; i < count_unit; i++) {
	printf("#");
      }
      printf("\n");
    }
  }
  return 0;
}
