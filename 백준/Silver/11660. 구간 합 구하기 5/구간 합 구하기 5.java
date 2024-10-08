import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] A = new int[N+1][N+1];
        
        for (int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j<=N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] D = new int[N+1][N+1];
        
        for (int i = 1; i<=N; i++) {
            for (int j = 1; j<=N; j++) {
                D[i][j] = D[i][j-1]+D[i-1][j]-D[i-1][j-1]+A[i][j];
            }
        }
        
        for (int i = 0; i <M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());        	
        
        	int sum = D[c][d] - D[a-1][d] - D[c][b-1] + D[a-1][b-1];
        	System.out.println(sum);
        }
    }
}