package exercise.penkt;

public class main {
    //masyvai
    public static void main(String[] args) {

        //javoj ir javascripte sutinkami vienmaciai masyvai,cia bus kitokiu pvz
        //buna ir matricu kurios gali atrodyti taip
        //cia dvimatis masyvas
//        int[][] kvadratas = new int[3][4];
//
//        kvadratas[1][2] = 123;
        //arba
        int[][] kvadratas ={
                {1,2,3,4},
                {5,6,7,8,9,10},
                {11,12}
        };
        //kubas
//        int[][][] kubas = new int[3][4][5];



        for (int i = 0; i < kvadratas.length; i++) {
            for (int j = 0; j < kvadratas[i].length; j++) {
                System.out.print(kvadratas[i][j] + "\t");
            }
            System.out.println();
        }



    }
}
