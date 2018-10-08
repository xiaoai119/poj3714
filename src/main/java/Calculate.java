import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created By xfj on 2018/10/8
 */
public class Calculate {
    public static Double calcuDistance(Point point1, Point point2) {
        if (point1.type.equals(point2.type)) {
            return Double.MAX_VALUE;
        } else
            return Math.sqrt(Math.pow((point1.getCd().getX() - point2.getCd().getX()), 2) + Math.pow((point1.getCd().getY() - point2.getCd().getY()), 2));
    }

    public static Double solve(List<Point> points, int start, int end) {
//        基本情况
        if (end - start == 1) {
            return calcuDistance(points.get(start), points.get(end));
        } else if (end - start == 2) {
            return Math.min(Math.min(calcuDistance(points.get(start), points.get(end)), calcuDistance(points.get(start), points.get(end - 1))), calcuDistance(points.get(start + 1), points.get(end)));
        }else if(end==start){
            return 0d;
        }
        int pilot = (start + end) / 2;
        Double d = Math.min(solve(points, start, pilot), solve(points, pilot, end));

        List<Point> points1 = new ArrayList<Point>();
        for(int i=start;i<end+1;i++){
            if(Math.abs(points.get(i).getCd().getX()-points.get(pilot).getCd().getX())<d)
                points1.add(points.get(i));
        }
        points1.sort(Comparator.comparing(point -> point.getCd().getY()));
        for(int index1=0;index1<points1.size();index1++)
            for(int index2=index1+1;index2<Math.min(points1.size(),index1+6);index2++)
                d=Math.min(d,calcuDistance(points1.get(index1),points1.get(index2)));
        return d;
    }
}
