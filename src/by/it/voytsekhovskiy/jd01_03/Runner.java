package by.it.voytsekhovskiy.jd01_03;


import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        InOut.printArray(InOut.getArray(line));
        InOut.printArray(InOut.getArray(line), "Example", 5);
        Helper.findMin(InOut.getArray(line));
        Helper.findMax(InOut.getArray(line));
        Helper.sort(InOut.getArray(line));
    }
}
