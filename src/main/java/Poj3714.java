import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created By xfj on 2018/10/8
 */
public class Poj3714 {
    public static void main(String args[]){
        DecimalFormat df = new DecimalFormat("0.000");
        Scanner sc=new Scanner(System.in);
        int caseNum = Integer.parseInt(sc.nextLine());
        for(int i=0;i<caseNum;i++){
            ArrayList<Point> points = new ArrayList<>();
            int pointNum = Integer.parseInt(sc.nextLine());
            for(int j=0;j<2*pointNum;j++){
                String[] split = sc.nextLine().split(" ");
                Point point = new Point(Double.parseDouble(split[0]), Double.parseDouble(split[1]), (j<pointNum?0:1));
                points.add(point);
            }
            points.sort(Comparator.comparing(point -> point.getCd().getX()));
            Double solve = Calculate.solve(points, 0, 2 * pointNum - 1);
            System.out.println(df.format(solve));
        }
    }
}
