import java.util.ArrayList;

public class Pair {
   private int x;
   private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }
    public boolean contains(ArrayList<Pair> arrayList){
        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i).getX() == x && arrayList.get(i).getY()==y) return  true;
        }
        return false;
    }
}
