package Game;

public abstract class PlayerTools {
    /*
       When a variable is declared with final keyword,
     its value can’t be modified, essentially, a constant.
     This also means that you must initialize a final variable.
     If the final variable is a reference, this means that
     the variable cannot be re-bound to reference another object,
     but internal state of the object pointed by that reference
     variable can be changed i.e. you can add or remove elements
     from final array or final collection. It is good practice
     to represent final variables in all uppercase, using underscore
     to separate words.
        ref = https://www.geeksforgeeks.org/final-keyword-java/
     */
    public final char token;
    public final GameTools game;

    public PlayerTools(GameTools game, char token) {
        this.game = game;
        this.token = token;
    }
}