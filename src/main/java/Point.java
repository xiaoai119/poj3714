/**
 * Created By xfj on 2018/10/8
 */
public class Point {
    Integer type;
    Coordinate cd;

    Point(Double x, Double y, Integer type) {
        cd = new Coordinate(x, y);
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public Coordinate getCd() {
        return cd;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setCd(Coordinate cd) {
        this.cd = cd;
    }
}
