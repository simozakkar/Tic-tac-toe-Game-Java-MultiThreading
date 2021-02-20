package Game;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        GameTools game = new GameTools();
        String choix;
        System.out.print("Welcome to X/O Game\n\t1- Player VS Player\n\t2- Player VS CPU\n\t====> : ");

        do {
            choix=scanner.nextLine();
        }while(!choix.equals("1") && !choix.equals("2"));
        System.out.println("\n 1 | 2 | 3 \n---+---+---\n 4 | 5 | 6 \n---+---+---\n 7 | 8 | 9 ");
        if (choix.equals("1")){
            System.out.println("Player VS Player");
            Thread player = new Thread(new Player(game,'X'));
            Thread player2 = new Thread(new Player(game,'O'));
            player.start();
            player2.start();
        }else{
            Thread player = new Thread(new Player(game,'X'));
            Thread cpuPlayer = new Thread(new CPUPlayer(game,'O'));
            player.start();
            cpuPlayer.start();
        }
    }
}
