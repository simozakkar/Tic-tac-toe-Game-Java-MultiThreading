package Game;

import java.util.Scanner;

public class Player extends PlayerTools implements Runnable{


    public Player(GameTools game, char token) {
        super(game, token);
    }

    @Override
    public void run() {
        synchronized (game){
            while(true){
                System.out.println("Player "+this.token);
                game.showBoard();
                Scanner scanner = new Scanner(System.in);
                int index;
                do {
                    System.out.print(" : ");
                    try{
                        index = Integer.parseInt(scanner.nextLine());
                    }catch (Exception e){
                        index=10;
                    }
                }while(!game.makeMove(this.token,index));
                game.notify();
                try {
                    game.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
