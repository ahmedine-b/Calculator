package domain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CalculatriceOutput {
    public static void getStarted(){
        System.out.println("Compile: javac Main.java");
        System.out.println("Usage: java Main input.txt <+|-|*> <-log>");
    }
    public static void invalidOperator(String operator){
        System.err.println("Invalid operator: " + operator);
    }
    public static void invalidNumber(String message){
        System.err.println("Invalid number found in file: " + message);
    }
    public static void errorReadingFile(String message){
        System.err.println("Error reading file: " + message);
    }
    public static void getTotals(int total, String operationName){
        System.out.println("\n-------");
        System.out.println("total = " + total + " (" + operationName + ")");
    }
    public static void inputNumber(int number){
        System.out.println(number);
    }
    public static void calculLogger(int total, String operator, int number){
        System.out.print(" " + operator + " " + number + " (= " + total + ")");
    }
    public static void operationLogger(int total, String line, int lineNumber, int number){
        System.out.println("\n[" + System.currentTimeMillis() + "][log] parsed value = " + number);
        System.out.println(line);
        System.out.println("[" + System.currentTimeMillis() + "][log] accumulation : " + total + " on line " + lineNumber);
    }
    public static void endLog(String operationName){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss:SSSSSS");
        System.out.println("[" + LocalTime.now().format(dtf) + "][log] applying operation " + operationName);
        System.out.println("[" + LocalTime.now().format(dtf) + "][log] end of operation");
    }

}
