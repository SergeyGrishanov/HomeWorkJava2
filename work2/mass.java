package work2;

import java.io.BufferedReader;
import java.io.FileReader;

public class mass {
    public static String [] ReadLineFromFile(String pathway) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(pathway));
        String str;
        int size = 0;
        while ((str = br.readLine()) != null) {
            size +=1;
            }
        br.close();
        String [] listData = new String [size];
       
        int i = 0;
        BufferedReader br1 = new BufferedReader(new FileReader(pathway));
        while ((str = br1.readLine()) != null) {
            listData[i] = str;
            i += 1;
            }
        br1.close();
        return listData;
    
    }   
    
    public static void printArrayInt(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            System.out.printf("%d, ", array[i]);
        }
        System.out.print(array[array.length-1]);
    }
    
    public static void printArraeString(String [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
