import java.util.ArrayList;

public class HMM {
    Room casper_room;

    public HMM(Room casper_room) {
        this.casper_room = casper_room;
    }
    void initialProbability(){
        int freeCells = casper_room.getRow()* casper_room.getColumn()- casper_room.getObstacle();
        for(int i=0;i<casper_room.getRow();i++){
            for(int j=0;j<casper_room.getColumn();j++){
                if(casper_room.getRoom()[i][j] !=-1.0) casper_room.getRoom()[i][j] = 1.0/freeCells;

            }
        }
        casper_room.setCopyRoom(casper_room.getRoom());
    }
    void transitionProbability(int u,int v){
        ArrayList<Pair> adjEdgeList = casper_room.adjacent_edge_sharing_free_cells(u,v);
        ArrayList<Pair> adjCornerList = casper_room.adjacent_corner_sharing_free_cells(u,v);
        double prob=0;
        int x,y,count;
        for(int i=0;i<adjEdgeList.size();i++){
            x = adjEdgeList.get(i).getX();
            y = adjEdgeList.get(i).getY();
            count = casper_room.getAdjEdgeCellNo(x,y);
            prob = prob + casper_room.getCopyRoom()[x][y] * (0.9/count);
        }
        for(int i=0;i<adjCornerList.size();i++){
            x=adjCornerList.get(i).getX();
            y=adjCornerList.get(i).getY();
            count = casper_room.getAdjCornerCellNo(x,y);
            prob = prob+casper_room.getCopyRoom()[x][y] * (0.1/(count));

        }
        casper_room.getRoom()[u][v] = prob;
    }
    void transitionProbAllCells(){
        for(int i=0; i<casper_room.getRow();i++){
            for(int j=0;j<casper_room.getColumn();j++){
                if(casper_room.getRoom()[i][j] !=-1.0) transitionProbability(i,j);
            }
        }
        casper_room.setCopyRoom(casper_room.getRoom());
    }
    void ghostFound(int u,int v){
        ArrayList<Pair> adjEdgeList = casper_room.adjacent_edge_sharing_free_cells(u,v);
        ArrayList<Pair> adjCornerList = casper_room.adjacent_corner_sharing_free_cells(u,v);
        int x,y,w,z;
        for(int i=0;i<adjEdgeList.size();i++){
            x = adjEdgeList.get(i).getX();
            y = adjEdgeList.get(i).getY();
            casper_room.getRoom()[x][y]*=0.85;
        }
        for(int i=0;i<adjCornerList.size();i++){
            w=adjCornerList.get(i).getX();
            z=adjCornerList.get(i).getY();
            casper_room.getRoom()[w][z]*=0.85;
        }
        for(int i=0; i<casper_room.getRow();i++){
            for(int j=0;j<casper_room.getColumn();j++){
                if(casper_room.getRoom()[i][j] != -1.0 && !new Pair(i,j).contains(adjEdgeList) && !new Pair(i,j).contains(adjCornerList))
                    casper_room.getRoom()[i][j] *=0.15;
            }
        }
        casper_room.setCopyRoom(casper_room.getRoom());
    }
    void ghostNotFound(int u, int v){
        ArrayList<Pair> adjEdgeList = casper_room.adjacent_edge_sharing_free_cells(u,v);
        ArrayList<Pair> adjCornerList = casper_room.adjacent_corner_sharing_free_cells(u,v);
        int x,y,w,z;
        for(int i=0;i<adjEdgeList.size();i++){
            x = adjEdgeList.get(i).getX();
            y = adjEdgeList.get(i).getY();
            casper_room.getRoom()[x][y]*=0.15;
        }
        for(int i=0;i<adjCornerList.size();i++){
            w=adjCornerList.get(i).getX();
            z=adjCornerList.get(i).getY();
            casper_room.getRoom()[w][z]*=0.15;
        }
        for(int i=0; i<casper_room.getRow();i++){
            for(int j=0;j<casper_room.getColumn();j++){
                if(casper_room.getRoom()[i][j] != -1.0 &&  !new Pair(i,j).contains(adjEdgeList) && !new Pair(i,j).contains(adjCornerList))
                    casper_room.getRoom()[i][j] *=0.85;
            }
        }
        casper_room.setCopyRoom(casper_room.getRoom());
    }
    Pair ghostLocation(){
        int x = 0, y = 0;
        double temp = -10;
        for(int i=0;i< casper_room.getRow();i++){
            for(int j=0;j< casper_room.getColumn();j++){
                if(casper_room.getRoom()[i][j]>temp){
                    temp = casper_room.getRoom()[i][j];
                    x=i;
                    y=j;
                }
            }
        }
        return new Pair(x,y);
    }
    void normalization(){
        double temp=0;
        for(int i=0;i< casper_room.getRow();i++) {
            for (int j = 0; j < casper_room.getColumn(); j++) {
                if (casper_room.getRoom()[i][j] != -1.0) temp += casper_room.getRoom()[i][j];
            }
        }
        for(int i=0;i< casper_room.getRow();i++) {
            for (int j = 0; j < casper_room.getColumn(); j++) {
                if (casper_room.getRoom()[i][j] != -1.0) casper_room.getRoom()[i][j]/=temp;
            }
        }
    }


}
