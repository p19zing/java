import java.util.Scanner;

public class IntScanner {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Give int: ");
        int i1 = sc.nextInt();
        int i2 = sc.nextInt();
        System.out.println("sum is: " + i1 / i2);

    }
}
