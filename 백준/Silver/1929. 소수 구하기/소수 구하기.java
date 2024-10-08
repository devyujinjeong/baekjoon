import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] num = new int[N+1];
		
		for (int i = 2	; i <= N; i++) {
			num[i] = i;
		}		
		
		for(int i=2; i<=Math.sqrt(N); i++) {
			if(num[i]==0) {
				continue;
			}
			
			for(int j=i+i; j<=N; j = j+i) {
				num[j] = 0;
			}
		}
		
		for(int i=M; i<=N; i++) {
			if(num[i]!=0) {
				bw.write(num[i]+"\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}