#include <stdio.h>

int main(){
  int digits_count = 0;
  int spaces_count = 0;
  int tabs_count  = 0;
  int other_count = 0;
  int ch;
  while((ch = getchar()) != EOF) {
    if ((ch >= 48) && (ch <= 57)) {
      digits_count++;
    } else if (ch == ' ') {
      spaces_count++;
    } else if (ch == '\t') {
      tabs_count++;
    } else {
      other_count++;
    }
    
  }

  printf("digits: %d\n", digits_count);
  printf("spaces: %d\n", spaces_count);
  printf("tabs  : %d\n", tabs_count);
  printf("other : %d\n", other_count);
  return 0;
}
