package lt.bit.task7;

import java.util.ArrayList;

public class Magazine {

    private int maxSize;
    private ArrayList<String> bullets;

    public Magazine(int maxSize) {
        this.maxSize = maxSize;
        this.bullets = new ArrayList<>();
    }

    public void loadBullet(String bullet) {
        if (bullets.size() == maxSize) {
            System.out.println("Magazine is full");
        } else {
            bullets.add(bullet);
        }
    }

    public boolean isLoaded() {
        return bullets.size() >= 1;
    }

    public void shot() {
        if (!isMagazineEmpty()) {
            String bullet = bullets.get(bullets.size() - 1);
            System.out.println(bullet);
            bullets.remove(bullet);
            isMagazineEmpty();
        }
    }

    private boolean isMagazineEmpty() {
        if (bullets.size() == 0) {
            System.out.println("Magazine is empty");
            return true;
        }
        return false;
    }
}
