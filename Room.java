import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Room {
   private int row;
   private int column;
   private int obstacle;
   private double [][] room;
    private double [][] copyRoom;


    public Room(int row, int column,int obstacle) {
        this.row = row;
        this.column = column;
        room = new double[row][column];
        copyRoom = new double[row][column];
        this.obstacle = obstacle;
    }
    ArrayList<Pair> adjacent_edge_sharing_free_cells(int u, int v){
        ArrayList<Pair> adjEdgeCells = new ArrayList<>();
        if((u-1)>=0 && room[u-1][v] !=-1) adjEdgeCells.add(new Pair(u-1,v));
        if((u+1)!=row && room[u+1][v] !=-1) adjEdgeCells.add(new Pair(u+1,v));
        if((v-1)>=0 && room[u][v-1]!=-1) adjEdgeCells.add(new Pair(u,v-1));
        if((v+1) != column && room[u][v+1]!=-1) adjEdgeCells.add(new Pair(u,v+1));
        return adjEdgeCells;
    }
    ArrayList<Pair> adjacent_corner_sharing_free_cells(int u,int v){
        ArrayList<Pair> adjCornerCells = new ArrayList<>();
        if((u-1)>=0 && (v-1)>=0 && room[u-1][v-1] !=-1) adjCornerCells.add(new Pair(u-1,v-1));
        if((u-1)>=0 && (v+1) !=column && room[u-1][v+1] !=-1) adjCornerCells.add(new Pair(u-1,v+1));
        if((u+1)!=row && (v-1)>=0 && room[u+1][v-1] !=-1) adjCornerCells.add(new Pair(u+1,v-1));
        if((u+1)!=row && (v+1)!=column && room[u+1][v+1]!=-1) adjCornerCells.add(new Pair(u+1,v+1));
        adjCornerCells.add(new Pair(u,v));
        return adjCornerCells;
    }
    int getAdjEdgeCellNo(int u,int v){
       return adjacent_edge_sharing_free_cells(u,v).size();
    }
    int getAdjCornerCellNo(int u,int v){
        return adjacent_corner_sharing_free_cells(u,v).size();
    }

    public double[][] getRoom() {
        return room;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getObstacle() {
        return obstacle;
    }

    public void setCopyRoom(double[][] r) {
        for(int i=0; i<row;i++){
            for(int j=0;j<column;j++){
                copyRoom[i][j] = r[i][j];
            }
        }
    }

    public double[][] getCopyRoom() {
        return copyRoom;
    }

    void print_room(){

      /*  String lineSplit = "";
        StringJoiner splitJoiner = new StringJoiner("+", "|", "|");
        for (int index = 0; index < room[0].length; index++) {
            splitJoiner.add(String.format("%7s", "").replace(" ", "-"));
        }
        lineSplit = splitJoiner.toString();
        for (double[] row : room) {
            StringJoiner sj = new StringJoiner(" | ", "| ", " |");
            for (double col : row) {
                sj.add(String.format("%.3f", col));
            }
            System.out.println(lineSplit);
            System.out.println(sj.toString());
        }
        System.out.println(lineSplit);
        */

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){

                if(j==0) System.out.print(String.format("%.4f",room[i][j]* (room[i][j]==-1? Math.abs(0.0):100))+"\t");
                else System.out.print(String.format("%.4f",room[i][j]* (room[i][j]==-1? Math.abs(0.0):100))+"\t");
            }
            System.out.println();

        }
        System.out.println("-------------------------------------------------------------------------------");
    }

}
