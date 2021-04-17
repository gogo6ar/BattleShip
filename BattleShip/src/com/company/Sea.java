package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.Ships.*;


public class Sea {
    private Ships[][] playerBoard;

    public void printShot() {
        System.out.println("    0   1   2   3   4   5   6   7   8   9");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + "\t");
            for (int q = 0; q < 10; q++) {
                if (playerBoard[i][q] == FIRE) System.out.print(FIRE.getDescription() + "\t");
                else if(playerBoard[i][q] == SHIP_SHOT) System.out.print(SHIP_SHOT.getDescription() + "\t");
                else System.out.print(EMPTY.getDescription() +"\t");
            }
            System.out.println("");
        }
    }

    public void printBoard() {
        System.out.println("    0   1   2   3   4   5   6   7   8   9");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + "\t");
            for (int q = 0; q < 10; q++) {
                System.out.printf(playerBoard[i][q].getDescription() + "\t");
            }
            System.out.println("");
        }
    }

    public boolean shot(int x, int y, String name) {
        boolean bShot = false;
        if (playerBoard[x][y] == EMPTY || playerBoard[x][y] == ARIA) {
            System.out.println("Мимо");
            bShot = false;
            playerBoard[x][y] = FIRE;
        }

        else if (playerBoard[x][y] == SHIP1PX || playerBoard[x][y] == SHIP2PX  ||
                playerBoard[x][y] == SHIP3PX || playerBoard[x][y] == SHIP4PX) {
            System.out.println("Попал");
            bShot = true;
            if (countOfShip(x,y) == 0) {
                System.out.println(name + "WIN");
                playerBoard[x][y] = SHIP_SHOT;

                System.exit(0);
            }
            playerBoard[x][y] = SHIP_SHOT;
        }
        return bShot;
    }

    int count1px = 1, count2px = 2, count3px = 3, count4px = 4;
    int countAll = 0;

    public int countOfShip(int x, int y) {
        if (playerBoard[x][y] == SHIP1PX) {
            count1px--;
            System.out.println("Однопалубный корабль уничтожен");
        }
        else if(playerBoard[x][y] == SHIP2PX) {
            count2px--;
            if (count2px == 0) System.out.println("Двупалубный корабль уничтожен");
        }
        else if(playerBoard[x][y] == SHIP3PX) {
            count3px--;
            if (count3px == 0) System.out.println("Трехпалубный корабль уничтожен");
        }
        else if(playerBoard[x][y] == SHIP4PX) {
            count4px--;
            if (count4px == 0) System.out.println("Четырехпалубный палубный корабль уничтожен");
        }
        countAll = count1px + count2px+ count3px + count4px;
        return countAll;
    }

    public void setCoordinates() {
        Scanner scanner = new Scanner(System.in);
        String[] reader = null;
        String[] readerFinal = null;
        List<Integer> coord_arr = new ArrayList<>();
        boolean check = false;

//        do {
//            System.out.println("Введите координаты для четырехпалубного корабля, по примеру: x1,y1;x2,y2;x3,y3;x4,y4");
//
//            reader = scanner.nextLine().split(";");
//
//            readerFinal = reader[0].split(",");
//            coord_arr.add(Integer.parseInt(readerFinal[0]));
//            coord_arr.add(Integer.parseInt(readerFinal[1]));
//
//            readerFinal = reader[1].split(",");
//            coord_arr.add(Integer.parseInt(readerFinal[0]));
//            coord_arr.add(Integer.parseInt(readerFinal[1]));
//
//            readerFinal = reader[2].split(",");
//            coord_arr.add(Integer.parseInt(readerFinal[0]));
//            coord_arr.add(Integer.parseInt(readerFinal[1]));
//
//            readerFinal = reader[3].split(",");
//            coord_arr.add(Integer.parseInt(readerFinal[0]));
//            coord_arr.add(Integer.parseInt(readerFinal[1]));
//
//            if (playerBoard[coord_arr.get(0)][coord_arr.get(1)] == EMPTY &&
//                    playerBoard[coord_arr.get(2)][coord_arr.get(3)] == EMPTY &&
//                    playerBoard[coord_arr.get(4)][coord_arr.get(5)] == EMPTY &&
//                    playerBoard[coord_arr.get(6)][coord_arr.get(7)] == EMPTY) {
//
//                playerBoard[coord_arr.get(0)][coord_arr.get(1)] = SHIP4PX;
//                playerBoard[coord_arr.get(2)][coord_arr.get(3)] = SHIP4PX;
//                playerBoard[coord_arr.get(4)][coord_arr.get(5)] = SHIP4PX;
//                playerBoard[coord_arr.get(6)][coord_arr.get(7)] = SHIP4PX;
//
//                setArea(coord_arr.get(0), coord_arr.get(1));
//                setArea(coord_arr.get(2), coord_arr.get(3));
//                setArea(coord_arr.get(4),coord_arr.get(5));
//                setArea(coord_arr.get(6), coord_arr.get(7));
//                check = true;
//            }
//
//            else {
//                System.out.println("ОШИБКА! Введите заново");
//            }
//            coord_arr.clear();
//        } while (check = false);
//
//
//        do {
//            System.out.println("Введите координаты для трехпалубного корабля, по примеру: x1,y1;x2,y2;x3,y3");
//
//            reader = scanner.nextLine().split(";");
//            readerFinal = reader[0].split(",");
//            coord_arr.add(Integer.parseInt(readerFinal[0]));
//            coord_arr.add(Integer.parseInt(readerFinal[1]));
//
//            readerFinal = reader[1].split(",");
//            coord_arr.add(Integer.parseInt(readerFinal[0]));
//            coord_arr.add(Integer.parseInt(readerFinal[1]));
//
//            readerFinal = reader[2].split(",");
//            coord_arr.add(Integer.parseInt(readerFinal[0]));
//            coord_arr.add(Integer.parseInt(readerFinal[1]));
//
//            if (playerBoard[coord_arr.get(0)][coord_arr.get(1)] == EMPTY &&
//                    playerBoard[coord_arr.get(2)][coord_arr.get(3)] == EMPTY &&
//                    playerBoard[coord_arr.get(4)][coord_arr.get(5)] == EMPTY) {
//
//                playerBoard[coord_arr.get(0)][coord_arr.get(1)] = SHIP3PX;
//                playerBoard[coord_arr.get(2)][coord_arr.get(3)] = SHIP3PX;
//                playerBoard[coord_arr.get(4)][coord_arr.get(5)] = SHIP3PX;
//
//                setArea(coord_arr.get(0), coord_arr.get(1));
//                setArea(coord_arr.get(2), coord_arr.get(3));
//                setArea(coord_arr.get(4),coord_arr.get(5));
//                check = true;
//            }
//
//            else {
//                System.out.println("ОШИБКА! Введите заново");
//            }
//            coord_arr.clear();
//        } while (check = false);

        check = false;


        do {
            System.out.println("Введите координаты для двухпалубного корабля, по примеру: x1,y1;x2,y2");
            reader = scanner.nextLine().split(";");

            readerFinal = reader[0].split(",");
            coord_arr.add(Integer.parseInt(readerFinal[0]));
            coord_arr.add(Integer.parseInt(readerFinal[1]));

            readerFinal = reader[1].split(",");
            coord_arr.add(Integer.parseInt(readerFinal[0]));
            coord_arr.add(Integer.parseInt(readerFinal[1]));


            if (playerBoard[coord_arr.get(0)][coord_arr.get(1)] == EMPTY && playerBoard[coord_arr.get(2)][coord_arr.get(3)] == EMPTY) {
                playerBoard[coord_arr.get(0)][coord_arr.get(1)] = SHIP2PX;
                playerBoard[coord_arr.get(2)][coord_arr.get(3)] = SHIP2PX;
                setArea(coord_arr.get(0), coord_arr.get(1));
                setArea(coord_arr.get(2), coord_arr.get(3));
                check = true;
            }

            else {
                System.out.println("ОШИБКА! Введите заново");
            }
            coord_arr.clear();
        } while(check == false);

        check = false;
        do {
            System.out.println("Введите координаты для одногопалубного корабля, по примеру: x1,y1");
            reader = scanner.nextLine().split(",");
            coord_arr.add(Integer.parseInt(reader[0]));
            coord_arr.add(Integer.parseInt(reader[1]));
            if (playerBoard[coord_arr.get(0)][coord_arr.get(1)] == EMPTY) {
                playerBoard[coord_arr.get(0)][coord_arr.get(1)] = SHIP1PX;
                setArea(coord_arr.get(0), coord_arr.get(1));
                check = true;
            }
            else {
                System.out.println("ОШИБКА! Введите заново");
            }
            coord_arr.clear();

        } while (check == false);
    }

    public void setArea(int x, int y) {
        if (x-1 >= 0 && x-1 <=9 && y - 1 >= 0 && y - 1 <= 9 &&
                playerBoard[x-1][y-1] == EMPTY) playerBoard[x-1][y-1] = ARIA;
        if (x-1 >= 0 && x-1 <= 9 && y - 1 >= 0 && y - 1 <= 9 &&
                playerBoard[x-1][y] == EMPTY) playerBoard[x-1][y] = ARIA;
        if (x-1 >= 0 && x-1 <= 9 && y+1 >= 0 && y+1 <= 9 &&
                playerBoard[x-1][y+1] == EMPTY) playerBoard[x-1][y+1] = ARIA;
        if (x >= 0 && x <= 9 && y-1 >= 0 && y-1 <= 9  &&
                playerBoard[x][y-1] == EMPTY) playerBoard[x][y-1] = ARIA;
        if (x >= 0 && x <= 9 && y>=0 && y<=9 &&
                playerBoard[x][y] == EMPTY) playerBoard[x][y] = ARIA;
        if (x >= 0 && x <= 9 && y+1 >=0 && y+1 <=9 &&
                playerBoard[x][y+1] == EMPTY) playerBoard[x][y+1] = ARIA;
        if (x+1 >= 0 && x+1 <= 9 && y-1 >= 0 && y-1 <=9 &&
                playerBoard[x+1][y-1] == EMPTY) playerBoard[x+1][y-1] = ARIA;
        if (x+1 >= 0 && x+1 <= 9 && y>=0 && y <=9 &&
                playerBoard[x+1][y] == EMPTY) playerBoard[x+1][y] = ARIA;
        if (x+1 >=0 && x+1<=9 && y+1 >=0 && y+1 <=9 &&
                playerBoard[x+1][y+1] == EMPTY) playerBoard[x+1][y+1] = ARIA;
    }


    public Sea(Ships[][] playerBoard) {
        this.playerBoard = playerBoard;
    }

    public Ships[][] getPlayerBoard() {
        return playerBoard;
    }

    public void setPlayerBoard(Ships[][] playerBoard) {
        this.playerBoard = playerBoard;
    }
}