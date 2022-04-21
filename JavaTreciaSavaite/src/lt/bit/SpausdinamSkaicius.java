package lt.bit;

public class SpausdinamSkaicius {

    public static void main(String[] args) {
        spausdintiSkaiciusNuoIki(1,100);

    }
    public static void spausdintiSkaiciusNuoIki (int x, int y){
        for (int i=x;i<=y;i++){
            System.out.print(i+","); //nutrynem ln ir spausdins eilutej
        }
    }
}
