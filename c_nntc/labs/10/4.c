#include <stdio.h>

enum {
  ARR_SIZE=5
};

void print_array(int arr[], int arr_size) {
  for(int i=0; i < arr_size; i++)
    printf("%d ", arr[i]);
  printf("\n");
}

void read_array(int arr[], int arr_size) {
  for (int i=0; i < arr_size; i++)
    scanf("%d", &arr[i]);
}
  
char is_pow2(int num) {
  return num && !(num & (num - 1));
}

int main() {
  int array[ARR_SIZE];
  read_array(array, ARR_SIZE);
  printf("a = ");
  print_array(array, ARR_SIZE);
  
  for (int i=0; i < ARR_SIZE; i++) {
    if (is_pow2(array[i]))
      printf("%d is pow 2\n", array[i]);
    else
      printf("%d is not pow 2\n", array[i]);      
  }
  return 0;
}
