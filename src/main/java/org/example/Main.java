package org.example;

import org.example.controller.Map;

import java.util.Scanner;

public class Main {
    static Map<Integer, String> map;
    public static void main(String[] args) {
        map = new Map<Integer, String>();
        map.add(20, "Twenty");
        map.add(21, "TwentyOne");
        map.add(22, "TwentyTwo");
        System.out.println("Hash store!");
        Scanner i = new Scanner(System.in);
        int input = getInput(i);
        while(true) {
            if(input == 1) {
                map.remove(22);
                String val = map.get(22);
                System.out.println(val);
                System.out.println("Enter a key to add");
                int key = i.nextInt();
                System.out.println("Enter it's value");
                String value = i.next();
                map.add(key, value);
                System.out.println("Added!");
                input = getInput(i);
                continue;
            } else if(input == 2) {
                System.out.println("Enter Search key");
                int key = i.nextInt();
                String val = map.get(key);
                if(val != null) {
                    System.out.println(val);
                } else {
                    System.out.println("Not found!");
                }
                input = getInput(i);
                continue;
            } else {
                continue;
            }
        }
    }

    public static int getInput(Scanner i) {
        System.out.println("Enter 1 to create a hash");
        System.out.println("Enter 2 to search a key");
        System.out.println("Enter 3 to exit");
        return i.nextInt();
    }
}