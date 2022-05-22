package exercise38;

public class CoffeMachine {

    private int maxTalpa; //ml
    private int currentTalpa;

    public CoffeMachine(int maxTalpa) {
        this.maxTalpa = maxTalpa;
        currentTalpa = maxTalpa;
    }

    public void fillUp() {
        currentTalpa = maxTalpa;
        System.out.println("Aparatas pripildytas!");
    }

    public void makeCoffe(int talpa) {
        if (talpa >= currentTalpa) {
            System.out.println("Atsiprasome, truksta vandens.");
        } else {
            //currentTalpa=currentTalpa-talpa;
            currentTalpa -= talpa;
            System.out.println("Stai jusu puodelis kavos!");
        }
    }
}
