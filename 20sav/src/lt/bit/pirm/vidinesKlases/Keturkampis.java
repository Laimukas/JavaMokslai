package lt.bit.pirm.vidinesKlases;

public class Keturkampis {
    
    private Taskas vk;
    private Taskas vd;
    private Taskas ak;
    private Taskas ad;
    
    public Keturkampis() {
        vk = new Taskas((int) (Math.random() * 10), (int) (Math.random() * 10) + 50);
        vd = new Taskas((int) (Math.random() * 10) + 50, (int) (Math.random() * 10) + 50);
        ak = new Taskas((int) (Math.random() * 10), (int) (Math.random() * 10));
        ad = new Taskas((int) (Math.random() * 10) + 50, (int) (Math.random() * 10));
    }
    
    public String toString() {
        return vk.toString() + " - " + vd.toString() + "\r\n" +
                ak.toString() + " - " + ad.toString();
    }

    public double perimetras() {
        double p = Math.sqrt((vd.x - vk.x) * (vd.x - vk.x) + (vd.y - vk.y) * (vd.y - vk.y));
        p += Math.sqrt((vd.x - ad.x) * (vd.x - ad.x) + (vd.y - ad.y) * (vd.y - ad.y));
        p += Math.sqrt((ak.x - ad.x) * (ak.x - ad.x) + (ak.y - ad.y) * (ak.y - ad.y));
        p += Math.sqrt((ak.x - vk.x) * (ak.x - vk.x) + (ak.y - vk.y) * (ak.y - vk.y));
        return p;
    }

    private class Taskas {
        int x;
        int y;

        public Taskas(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }
    
    
}
