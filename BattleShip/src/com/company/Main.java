package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sea pB1 = new Sea(new Ships[][]{
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY}
        }
        );

        Sea pB2 = new Sea(new Ships[][]{
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY},
                {Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY, Ships.EMPTY}
        }
        );



        Scanner scanner = new Scanner(System.in);
        System.out.println("???????????? ?????????? ?????????????? ??????: ");
        String name1 = scanner.nextLine();
        System.out.println("???????????? ?????????? ?????????????? ??????: ");
        String name2 = scanner.nextLine();


        pB1.setCoordinates();
        pB1.printBoard();

        pB2.setCoordinates();
        pB2.printBoard();

        boolean p = true;
        String[] coor_fire;
        int x,y;

        int queue = (int) ( Math.random() * (2-1) ) + 1;

        while(p) {
//            if (queue == 1) System.out.println(name1 + ", ???????? ??????????????!");
//            if (queue == 2) System.out.println(name2 + ", ???????? ??????????????!");
//            System.out.println("?????????????? ???????????????????? ?????? ???????????????? (x,y)");
//            coor_fire = scanner.nextLine().split(",");
//            x = Integer.parseInt(coor_fire[0]);
//            y = Integer.parseInt(coor_fire[1]);
            if (queue == 1) {
                System.out.println(name1 + ", ???????? ??????????????!");
                boolean nextShot = true;
                while(nextShot) {
                    System.out.println("?????????????? ???????????????????? ?????? ???????????????? (x,y)");
                    coor_fire = scanner.nextLine().split(",");
                    x = Integer.parseInt(coor_fire[0]);
                    y = Integer.parseInt(coor_fire[1]);
                    nextShot = pB2.shot(x, y, name1);
                    pB1.printShot();
                }

                queue = 2;
            }

            else  {
                boolean nextShot = true;
                System.out.println(name2 + ", ???????? ??????????????!");
                while (nextShot) {
                    System.out.println("?????????????? ???????????????????? ?????? ???????????????? (x,y)");
                    coor_fire = scanner.nextLine().split(",");
                    x = Integer.parseInt(coor_fire[0]);
                    y = Integer.parseInt(coor_fire[1]);
                    nextShot = pB1.shot(x, y, name2);
                    pB2.printShot();
                }
                queue = 1;
            }
        }
    }
}

