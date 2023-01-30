// 1) Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.
// 2) К калькулятору из предыдущего дз добавить логирование.
//
// 1) Solution:
//
// import java.io.IOException;
// import java.util.Arrays;
// import java.util.logging.*;

// public class ht2 {
//     public static void main(String[] args) throws IOException {
//         int length = 10;
//         int[] myArray = CreateRndArray(length);
//         ArrayPrinter(myArray);
//         int[] sortedArr = BubbleSort(myArray);
//         // ArrayPrinter(sortedArr);
//         System.out.println(Arrays.toString(sortedArr));
//     }
//     public static int[] CreateRndArray(int setLength){
//         int[] myArr = new int[setLength];
//         for (int i = 0; i < myArr.length; i++) {
//             myArr[i]=(int)(Math.random()*11);
//         }
//         return myArr;
//     }

//     public static int[] BubbleSort(int[] inputArray) throws SecurityException, IOException{
//         Logger myLogger = Logger.getLogger(ht2.class.getName());
//         FileHandler fHandler = new FileHandler("log.txt");
//         SimpleFormatter sFormatter = new SimpleFormatter();

//         myLogger.addHandler(fHandler);
//         fHandler.setFormatter(sFormatter);
//         int iteration = 1;
//         int temp = 0;
//         String array=Arrays.toString(inputArray);
//         String message = String.format("Array to sort:\n%s", array);
//         myLogger.info(message);
//         myLogger.info("sorting array log:");
//         for (int out = inputArray.length - 1; out >= 1; out--) {
//             for (int i = 0; i < out; i++) {
//                 if (inputArray[i]>inputArray[i+1]) {
//                     temp=inputArray[i];
//                     inputArray[i]=inputArray[i+1];
//                     inputArray[i+1]=temp;
//                 }
//             }
//             String messageWithIter = String.format("Iteration:\tno.%d\nArray looks like this:\t%s", iteration, Arrays.toString(inputArray));
//             myLogger.info(messageWithIter);
//             iteration++;
//         }

//         return inputArray;
//     }

//     public static void ArrayPrinter(int[] inputArr){
//         for (int i = 0; i < inputArr.length; i++) {
//             System.out.println(inputArr[i]);
//         }
//         System.out.println();
//     }

// }
//
// 2) Solution:
// import java.util.Scanner;
// import java.io.IOException;
// import java.util.logging.*;

// public class ht2 {
//     public static void main(String[] args) throws IOException {
//         try (Scanner sc = new Scanner(System.in)) {
//             Logger myLogger = Logger.getLogger(ht2.class.getName());
//             FileHandler fHandler = new FileHandler("log.txt");
//             SimpleFormatter sFormatter = new SimpleFormatter();

//             myLogger.addHandler(fHandler);
//             fHandler.setFormatter(sFormatter);
//             String message="";
//             int actionNum = 0;
//             System.out.println("Выберите действие:\n1-посчитать на калькуляторе\n2-закрыть калькулятор");
//             String action = sc.nextLine();
//             actionNum = Integer.parseInt(action);
//             while (actionNum != 2) {
//                 System.out.println("Введите первое число:\n");
//                 String numOne = sc.nextLine();
//                 int nOne = Integer.parseInt(numOne);
//                 System.out.println("Введите знак операции, которую хотите совершить (+ - * /):\n");
//                 String operand = sc.nextLine();
//                 System.out.println("Введите второе число:\n");
//                 String numTwo = sc.nextLine();
//                 int nTwo = Integer.parseInt(numTwo);
//                 myLogger.info("Starting to log");
//                 switch (operand) {
//                     case "+":
//                         System.out.printf("%d + %d = %d\n", nOne, nTwo, nOne + nTwo);
//                         message = String.format("User input:\n%s %s %s\nAnswer was:\n%s", numOne, operand, numTwo, nOne+nTwo);
//                         myLogger.info(message);
//                         break;
//                     case "-":
//                         System.out.printf("%d - %d = %d\n", nOne, nTwo, nOne - nTwo);
//                         message = String.format("User input:\n%s %s %s\nAnswer was:\n%s", numOne, operand, numTwo, nOne-nTwo);
//                         myLogger.info(message);
//                         break;
//                     case "*":
//                         System.out.printf("%d * %d = %d\n", nOne, nTwo, nOne * nTwo);
//                         message = String.format("User input:\n%s %s %s\nAnswer was:\n%s", numOne, operand, numTwo, nOne*nTwo);
//                         myLogger.info(message);
//                         break;
//                     case "/":
//                         System.out.printf("%d / %d = %d\n", nOne, nTwo, nOne / nTwo);
//                         message = String.format("User input:\n%s %s %s\nAnswer was:\n%s", numOne, operand, numTwo, nOne/nTwo);
//                         myLogger.info(message);
//                         break;
//                     default:
//                         System.out.println("Вы соврешили некорректный ввод!");
//                         message = String.format("Incorrect User input occured:\n%s %s %s\n", numOne, operand, numTwo);
//                         myLogger.info(message);
//                         break;
//                 }
//                 System.out.println("Выберите действие:\n1-посчитать на калькуляторе\n2-закрыть калькулятор");
//                 action = sc.nextLine();
//                 actionNum = Integer.parseInt(action);
//             } fHandler.close();
//             // System.out.printf("%s\n%s\n%s", numOne, operand, numTwo);
//         } catch (NumberFormatException e) {
//             e.printStackTrace();
//         }
//     }
// }