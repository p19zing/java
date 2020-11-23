import java.util.Scanner;

public class CtoF {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Give C: ");
        int C=sc.nextInt();
        System.out.println(" is: "+(C*9/5+32));

    }
}
