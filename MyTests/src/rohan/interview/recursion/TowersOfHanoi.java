package rohan.interview.recursion;

public class TowersOfHanoi {
    public static void main(String[] args) {
        printMoves(1, 2, 3, 3);
    }

    public static void printMoves(int towerFrom, int towerTo, int towerHelper, int diskNumber) {
        if (diskNumber < 1) {
            System.out.println("No Moves");
            return;
        }

        if (diskNumber == 1) {
            System.out.println(String.format("Move disk %d from %d to %d", diskNumber, towerFrom, towerTo));
            return;
        }

        printMoves(towerFrom, towerHelper, towerTo, diskNumber - 1);

        System.out.println(String.format("Move disk %d from %d to %d", diskNumber, towerFrom, towerTo));

        printMoves(towerHelper, towerTo, towerFrom, diskNumber - 1);        
    }
}