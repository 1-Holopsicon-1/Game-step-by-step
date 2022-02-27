package Game;

public class Cube {
    public int min;
    public int max;
    public int value;
    public boolean card_have = false;

    public Cube(int min_in, int max_in){
        min = min_in;
        max = max_in;
        value =  min + (int) (Math.random() * max);
    }

    //public void generateVal(){}
    public void showValue(){
         System.out.println(value);
    }
}


