import java.util.Scanner;

public class Probabilistic_Model {

    public static void main(String[] args) {
        int n,m,k,p,q;
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        k=scanner.nextInt();

        Room r = new Room(n,m,k);

        for(int i=0;i<k;i++){
            p=scanner.nextInt();
            q=scanner.nextInt();
            r.getRoom()[p][q] = -1;
        }
        HMM hmm = new HMM(r);
        hmm.initialProbability();
        r.print_room();
        String str;
        int u,v,w;

        while(true){
            str = scanner.next();
            if(str.equals("R")){
                 u = scanner.nextInt();
                 v = scanner.nextInt();
                 w = scanner.nextInt();
                hmm.transitionProbAllCells();
                //System.out.println("Checkingggggggg");
               // r.print_room();
               if(w==1) hmm.ghostFound(u,v);
                else hmm.ghostNotFound(u,v);
                hmm.normalization();

                r.print_room();
            }
            else if(str.equals("C")){
                System.out.println("Casper is most probably at "+hmm.ghostLocation());
            }
            else if(str.equals("Q")){
                System.out.println("Bye Casper");
                break;
            }

        }


    }
}
