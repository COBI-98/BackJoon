import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long total;
    static int N;
    static long[] buildings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        buildings = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Long.parseLong(st.nextToken());
        }

        if (N == 1) {
            System.out.println(0);
        }
        else if (N >= 2) {
            total = 0;
            for (int i = 0; i < N; i++) {
                int tmp = 0;
                tmp+=leftSearch(i);
                tmp+=rightSearch(i);

                total = Math.max(total, tmp);
            }
            System.out.println(total);
        }
    }
    
    private static int leftSearch(int target) {
        int tmp2 = 0;
        double leftslope = Double.POSITIVE_INFINITY;
        for (int i = target-1; i >= 0; i--) {
            
            double currentSlope = (double) (buildings[target] - buildings[i]) / (target - i);
            if (i == target-1 || currentSlope < leftslope) {
                leftslope = currentSlope;
                tmp2++;

            }

        }
        return tmp2;
    }

    private static int rightSearch(int target) {
        int tmp2 = 0;
        double rightslope = Double.NEGATIVE_INFINITY;
        for (int i = target+1; i < N; i++) {
            
            double currentSlope = (double) (buildings[target] - buildings[i]) / (target - i);
            if (i == target+1 || currentSlope > rightslope){
                rightslope = currentSlope;
                tmp2++;

            }
        }
        return tmp2;
    }
}