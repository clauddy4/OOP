package main.lab2.decode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input:");
        String htmlString = input.nextLine();
        Decode decode = new Decode();
        String out = decode.HtmlDecode(htmlString);
        System.out.println(out);
    }
}