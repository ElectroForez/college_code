#include <stdio.h>

int main() {
  int ch;
  int count_symbols = 0;
  int count_lines = 0;
  int count_words = 0;
  int en_uc_start = 65;//uc - uppercase
  int en_uc_end = 90;
  int en_lc_start = 97;//lc - lowercase
  int en_lc_end = 122;
  int num_start = 48;
  int num_end = 57;
  //это свой аналог булевых переменных
  char last_letter;//1 - если последний/текущий символ был буквой(или числом)
  char cur_letter;//0 - в ином случае
  //возьмём первый символ
  ch = getchar();
  //если это конец файла, то можно выходить из программы
  if (ch == EOF) {
    printf("\t%d\t%d\t%d\n", count_lines, count_words, count_symbols);
    return 0;
  }
  count_symbols++;//+1 к кол. символов
  if(ch == '\n')//поиск линии
    count_lines++;

  //смотрим находится ли символ в промежутках
  if ((en_uc_start <= ch && ch <= en_uc_end) || (en_lc_start <= ch && ch <= en_lc_end)
      || (num_start <= ch && ch <= num_end))
    //инициализируем last_letter
    last_letter = 1;
  else
    last_letter = 0;
  
  while((ch = getchar()) != EOF) {
    count_symbols++;
    if(ch == '\n')
      count_lines++;

    if ((en_uc_start <= ch && ch <= en_uc_end) || (en_lc_start <= ch && ch <= en_lc_end)
	|| (num_start <= ch && ch <= num_end))
      cur_letter = 1;
    else
      cur_letter = 0;

    if (cur_letter == 0 && last_letter == 1)
      count_words++;
    last_letter = cur_letter;//делаем текущий символ предыдущим
  }
  
  printf("\t%d\t%d\t%d\n", count_lines, count_words, count_symbols);
  return 0;
}
