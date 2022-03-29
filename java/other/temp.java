class temp {
    private static void printNumber(int number) {
       switch (number) {
       case 1:
          System.out.println("one");
       case 2:
          System.out.println("two");
          break;
       case 3:
          System.out.println("three");
          return;
       default:
          System.out.println("too many");
       }
    }
    public static void main(String[] args) {
       for (int i = 1; i <= 4; i++) {
           printNumber(i);
       }
    }
}
