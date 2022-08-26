package lt.bit.spring;

import java.util.Objects;

public class Keturkampis {

    private Taskas ak;
    private Taskas vk;
    private Taskas ad;
    private Taskas vd;

    public Keturkampis() {
        this.ak = new Taskas(0, 0);
        this.vk = new Taskas(0, 1);
        this.ad = new Taskas(1, 0);
        this.vd = new Taskas(1, 1);
    }

    public Keturkampis(Taskas ak, Taskas vk, Taskas ad, Taskas vd) {
        this.ak = ak;
        this.vk = vk;
        this.ad = ad;
        this.vd = vd;
    }

    public Taskas getAk() {
        return ak;
    }

    public void setAk(Taskas ak) {
        this.ak = ak;
    }

    public Taskas getVk() {
        return vk;
    }

    public void setVk(Taskas vk) {
        this.vk = vk;
    }

    public Taskas getAd() {
        return ad;
    }

    public void setAd(Taskas ad) {
        this.ad = ad;
    }

    public Taskas getVd() {
        return vd;
    }

    public void setVd(Taskas vd) {
        this.vd = vd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Keturkampis)) return false;
        Keturkampis that = (Keturkampis) o;
        return Objects.equals(getAk(), that.getAk()) && Objects.equals(getVk(), that.getVk()) && Objects.equals(getAd(), that.getAd()) && Objects.equals(getVd(), that.getVd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAk(), getVk(), getAd(), getVd());
    }

    @Override
    public String toString() {
        return "Keturkampis{" +
                "ak=" + ak +
                ", vk=" + vk +
                ", ad=" + ad +
                ", vd=" + vd +
                '}';
    }
}
