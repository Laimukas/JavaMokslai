package lt.bit.task7;

public class Main {
    public static void main(String[] args) {
        // siuo metu duodam prielaida kad detuve is dvieju soviniu ir paduodam du sovinius (a,b) ir padarom du suvius (shot()),atitinkami atsakymai
        Magazine magazine = new Magazine(2);
        magazine.loadBullet("a");
        magazine.loadBullet("b");
        magazine.shot();
        magazine.shot();
    }
}
