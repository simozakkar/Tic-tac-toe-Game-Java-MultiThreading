package Game;


public class CPUPlayer extends PlayerTools implements Runnable {


    public CPUPlayer(GameTools game, char token) {
        super(game, token);
    }

    int TakeCase(){
        int count = -1,index = 1;
        int[] TabEmptyCasesIndex = new int[9];
        for (Character c:game.getBoard()){
            if (c.equals(' ')) TabEmptyCasesIndex[++count]=index;
            index++;
        }
        // TabEmptyCasesIndex is a table when we find just the empty cases (empty case ==> ' ')
        // (int) (Math.random() * count) in [0, len(TabEmptyCasesIndex)-1]
        // Let the  (int) (Math.random() * count) take one of the empty cases
        return TabEmptyCasesIndex[(int) (Math.random() * count)];
    }

    @Override
    public void run() {
        synchronized (game){
            while(true){
                System.out.print("CPU ==> ");
                int indexCpu;
                do {
                    indexCpu = TakeCase();
                }while (!game.makeMove(this.token,indexCpu));
                System.out.println(indexCpu);
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