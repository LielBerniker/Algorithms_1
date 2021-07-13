class AA {
  public  AA() {
        print();
    }
    public static void print() {
        System.out.println("from AA");
    }




static class BB extends AA {
    public static void print() {
        System.out.println("from BB");
    }
}



    public static double first(double arg) {
        System.out.println("arg = " + arg);
        return -1;
    }

    public static double second(double arg) {
        while (true);
    }
    public static double third(double arg) {
        if (System.currentTimeMillis() % 2 == 0) {
            return arg * arg;
        }
        return 4;
    }
    public static int forth(double arg) {
        double k = 1;
        return k;
    }
    public static double fifth(double arg) {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        BB b = new BB();
        b.print();
        double i= forth(4.5);

        second(9.7);
    }
}