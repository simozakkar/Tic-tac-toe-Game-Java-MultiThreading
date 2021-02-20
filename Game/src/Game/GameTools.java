package Game;

import java.util.*;

import static java.lang.System.exit;

public class GameTools {
    private List<Character> board = new ArrayList<>();

    public void showBoard() {
        int index=0;
        System.out.println();
        for (Character c : board){
            if (index%3==2 ){
                System.out.print(" "+c);
                if (index != 8)
                    System.out.print("\n---+---+---\n");
            }
            else
                System.out.print(" "+c+" |");
            index++;
        }
        System.out.println();
    }

    public GameTools() {
        for(char i=0;i<9;i++) board.add(' ');
    }

    public List<Character> getBoard() {
        return board;
    }

    /*
              0 | 1 | 2
             ---+---+---
              3 | 4 | 5
             ---+---+---
              6 | 7 | 8
    */
    public boolean checkWinnerV(char token, int index){
        //if the index equals 0, 3 or 6
        if (index%3==0) return board.get(index+1).equals(token)
                && board.get(index+2).equals(token);

        //if index == 1, 4 or 7
        if (index%3==1) return board.get(index+1).equals(token)
                && board.get(index-1).equals(token);

        //if index == 2, 5 or 8
        return board.get(index-1).equals(token)
                && board.get(index-2).equals(token);
    }
    public boolean checkWinnerDiago(char token, int index){
        // index%2 == 0 ==> index = 0, 2, 4, 6 or 8
        // if value of case 4 != token return false
        if (index%2!=0 || !board.get(4).equals(token)) return false;
        // else if the  0, 4 and 8 == token or 2, 4 and 6 == token return true else return false.
        return (board.get(0).equals(board.get(4)) && board.get(0).equals(board.get(8)))
                || (board.get(2).equals(board.get(4)) && board.get(2).equals(board.get(6)));
    }
    /*
         for any value of index {0,...,8}
         let n = index%3  ==> n = 0, 1, or 2
         the (n, n+3, n+3*2) = (0, 3, 6) or (1, 4, 7) or (2, 5, 8)
          0 | 1 | 2
         ---+---+---
          3 | 4 | 5
         ---+---+---
          6 | 7 | 8
    */
    public boolean checkWinnerH(char token, int index){
        int n=index%3;
        return board.get(n).equals(token)
                && board.get(n+3).equals(token)
                && board.get(n+6).equals(token) ;

        /*
        return board.get((index+3)%9).equals(token)
                && board.get((index+6)%9).equals(token);
        */
    }

    public boolean makeMove(char token, int index){
        index--;
        if (index >= 9 || !board.get(index).equals(' ')) return false;
        board.set(index, token);
        // check if this player win
        if (checkWinnerH(token, index) || checkWinnerV(token, index) || checkWinnerDiago(token, index)){
            System.out.println("Player "+token+" Win ");
            showBoard();
            exit(1);
        }
        if (!board.contains(' ')) {
            System.out.println("Game over !!");
            showBoard();
            exit(1);
        }
        return true;
    }

}
