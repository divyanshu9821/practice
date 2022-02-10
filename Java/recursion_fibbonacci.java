import java.util.Scanner;

// using recursion
public class recursion_fibbonacci {

    static void fibbo(int a, int b, int n)
    {
        if(n==0)
            return;
        int c = a+b;
        System.out.println(c);
        fibbo(b,c,n-1);
    }

    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(a);
        System.out.println(b);
        fibbo(a, b, n-2);
        sc.close();
    }
}
