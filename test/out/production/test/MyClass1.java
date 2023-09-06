public class MyClass1 {

    private int a;
    public double b;

    public MyClass1(int first, double second)
    {
        this.a = first;
        this.b = second;
    }

    public static void incrementBoth(MyClass1 c1) {
        c1.a = c1.a + 1;
        c1.b = c1.b + 1.0;
    }

    // new method
    public static void incrementA(int first)
    {
        first = first + 1;
        System.out.println("11111");
        System.out.println(first);
    }

    // new method
    public static void incrementB(double second)
    {
        second = second + 1.0;
        System.out.println("22222");
        System.out.println(second);
    }

    public static void main(String[] args)
    {
        MyClass1 c1 = new MyClass1(10, 20.5);
        MyClass1 c2 = new MyClass1(10, 31.5);
        // different code below
        incrementA(c2.a);
        incrementB(c2.b);
        System.out.println(c2.a + ", "+ c2.b);
    }

}
