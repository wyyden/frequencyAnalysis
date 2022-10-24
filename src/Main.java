import java.util.Arrays;
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] array = sc.nextLine().toLowerCase().replaceAll(" ", "").toCharArray();
        Arrays.sort(array);
        int max = 0;
        int count = 1;
        char symbol = ' ';
        for (int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if (array[i] == array[j]) count++;
            }
            System.out.println(array[i] + ": " + count);
            count = 1;
        }
        System.out.println(symbol + " " + max);
    }
}