// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл

package work2;

// import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.*;

public class work2 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(work2.class.getName());
        FileHandler fh = new FileHandler("work2\\logFile.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        
        Scanner scn = new Scanner(System.in);
        System.out.printf("Введите масив (цифры): ");
        String numbers = scn.nextLine();
        numbers = numbers.replace(" ", "");
        String[] array = numbers.split(",");
        logger.info("Исходный массив");
        int [] num = Arrays.stream(array)
                        .mapToInt(Integer::parseInt)
                        .toArray();
 
        scn.close();
        
        mass.printArrayInt(num);
        int[] newArr = listSort(num);
        System.out.printf("\n Отсортированный массив: \n");
        mass.printArrayInt(newArr);
    }
    public static int[] listSort(int [] arr){
        for(int k = 0; k < arr.length-1; k++) {
            
            for (int i = 0; i < arr.length - k-1; i++){
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        return arr;
    }
}

