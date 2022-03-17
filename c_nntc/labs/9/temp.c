#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

int main(int argc, char** args) {
  printf("argc = %d\n", argc);
  printf("\nargs\n");
  for (int i = 0; i < argc; i++)
    printf("%d:%s\n", i, args[i]);
  return 0;
}
