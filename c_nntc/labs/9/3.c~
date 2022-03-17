#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>
enum {
  BUFF_SIZE = 13
};

int main(int arg_count, char** args) {
  int f1 = open(args[1], O_RDONLY);
  int f2 = open(args[2], O_WRONLY | O_CREAT);
  char buf[BUFF_SIZE];
  if ((f1 == -1) || (f2 == -1)) {
    printf("AAAAAAAAAA\n");
    return 1;
  }
  
  int c_read;
  while ((c_read = read(f1, buf, BUFF_SIZE)) > 0) {
    write(f2, buf, c_read);
  }
  
  fchmod(f2, S_IRUSR);
  close(f1);  
  close(f2);
  return 0;
}
