// К калькулятору из предыдущего ДЗ добавить логирование.

// Без логирования калькулятор работает. Не смог добавить логирование. В чем проблема?

package work4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Scanner;

public class work4 {
    
    private static File log;
    private static FileWriter logWriter;
    public static void main(String[] args) {    
        try {
            log = new File("work4\\log.txt");
            log.createNewFile();
            logWriter = new FileWriter(log);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                logWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) { 
        Scanner scn = new Scanner(System.in);
        System.out.printf("Введите число 1: ");
        int a = 0;
        if (!scn.hasNextInt()) {
            System.out.println("Вы ввели не число!");
        } else {
            a = scn.nextInt();
            logStep("User entered the first operand = " + a);
            Scanner sc = new Scanner(System.in);
            System.out.printf("Введите оператор: +, -, *, / \n");
            String signOperation = "";
            if (sc.hasNextLine()) {
                signOperation = sc.nextLine();
                logStep("User entered the operation = " + signOperation);
            }
            if (signOperation.equals("+") || signOperation.equals("-") || signOperation.equals("*")
                    || signOperation.equals("/")) {
                int b = 0;
                System.out.printf("Введита число 2: ");
                if (!scn.hasNextInt()) {
                    System.out.println("Вы ввели не число!");
                } else {
                    b = scn.nextInt();
                    logStep("User entered the first operand = " + b);
                    // printResultOperation(a, b, signOperation);
                    int res;
                    switch (signOperation) {
                    case "+":
                        res = add(a, b);
                        logStep("Result is " + res);
                        System.out.println(a + " + " + b + " = " + add(a, b));
                        break;
                    case "-":
                        res = minus(a, b);
                        logStep("Result is " + res);
                        System.out.println(a + " - " + b + " = " + minus(a, b));
                        break;
                    case "*":
                        res = mult(a, b);
                        logStep("Result is " + res);
                        System.out.println(a + " * " + b + " = " + mult(a, b));
                        break;
                    case "/":
                        res = divide(a, b);
                        logStep("Result is " + res);
                         System.out.println(a + " / " + b + " = " + res);
                        break;
                    default:
                        logStep("Wrong operation!");
                        System.out.println("Wrong operation!");
                }
                    
                }
            } else {
                System.out.println("Выввели неверный оператор!");

            }
            
            scn.close();
            sc.close();
        
            
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
        private static int divide(int a, int b) {
        if (b != 0)
            return a / b;
        return -1;
    }

    private static int mult(int a, int b) {
        return a * b;
    }

    private static int minus(int a, int b) {
        return a - b;
    }

    private static int add(int a, int b) {
        return a + b;
    }
    public static void logStep(String note) throws IOException {
        logWriter.write(new Timestamp(System.currentTimeMillis()) + " " + note + "\n");
    }
}
    