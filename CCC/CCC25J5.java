//Template Rock Climbing DP. Trick is to use flip array.
import java.io.*;
public class Main {
	  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  	public static void main(String[] args) throws IOException {
    		int R = Integer.parseInt(br.readLine());
    		int C = Integer.parseInt(br.readLine());
    		int M = Integer.parseInt(br.readLine());
    		int[][] dist = new int[2][C];
    		for(int i = 0; i < C; i++) {
    			  dist[0][i] = getGrid(0, i, M, C);
    		}
    		int curr= 0;
    		int prev = 0;
    		for(int i = 1; i < R; i++) {
      			curr = i%2;
      			prev = (i + 1)%2;
      			for(int j = 0; j < C; j++) {
      				  int min = dist[prev][j];
      				if(j != 0) {
      					  min = Math.min(min, dist[prev][j-1]);
      				}
      				if(j != C-1) {
      					  min = Math.min(min, dist[prev][j+1]);
              }
      				  dist[curr][j] = getGrid(i, j, M, C) + min;
      			}
    		}
    		int ans = Integer.MAX_VALUE;
    		for(int i = 0; i < C; i++) {
      			ans = Math.min(ans, dist[curr][i]); 
    		}
  		System.out.println(ans);
  	}
  	public static int getGrid(int r, int c, int m, int C) {
  		  return (r*C + c)%m + 1;
  	}
}
