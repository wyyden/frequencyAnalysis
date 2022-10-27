import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
class Main{
    public static String readFile(String path, Charset encoding) throws IOException {
        String content = Files.lines(Paths.get(path), encoding)
                .collect(Collectors.joining(System.lineSeparator()));

        return content;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Прочитать из файла - 1; \nВвести вручную - 2\n");
        int answer = sc.nextInt();
        String content = null;
        if (answer == 1){
            String filePath = "2.txt";

            try {
                content = readFile(filePath, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            sc.nextLine();
            content = sc.nextLine();
        }
        char[] array = content.toLowerCase().replaceAll("[^A-Za-zА-Яа-я]", "").toCharArray();
        Arrays.sort(array);
        int count = 1;
        int countAll = 0;
        char symbol = ' ';
        for (int i=0; i<array.length-1; i++) {
            if ((i != array.length - 1) && (array[i] == array[i + 1])){
                if (i + 1 == array.length - 1) {
                    count++;
                    System.out.println(array[i] + ": " + count);
                    countAll++;
                    break;
                }
            count++;
            }
            else if ((i+1 == array.length-1) && (array[i] != array[i + 1])){
                System.out.println(array[i] + ": " + count);
                count = 1;
                System.out.println(array[i+1] + ": " + count);
                countAll += 2;
                break;
            }
            else{
                System.out.println(array[i] + ": " + count);
                count = 1;
            }
            countAll++;
        }
        System.out.println("Общее кол-во = " + countAll);
    }
}