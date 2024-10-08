import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long[][] C = new long[202][202];

        for (int i = 0; i <= 200; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                if (C[i][j] > 1000000000L) {
                    C[i][j] = 1000000001L;
                }
            }
        }

        long total = C[N + M][N];

        if (K > total) {
            sb.append(-1);
        } else {
            while (N > 0 || M > 0) {
                if (N > 0 && K <= C[N + M - 1][N - 1]) {
                    sb.append('a');
                    N--;
                } else {
                    sb.append('z');
                    if (N > 0) {
                        K -= C[N + M - 1][N - 1];
                    }
                    M--;
                }
            }
        }

        System.out.println(sb);
    }
}
