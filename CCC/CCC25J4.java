//2 pointers template look but be aware of N - 1 is when all days are sunny. Read question carefully
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] weather = new char[n];
        int Scount = 0;
        int Tcount = 0;
        for(int i = 0; i < n; i++) {
	    char ch = br.readLine().charAt(0);
	    if(ch == 'S') {
		weather[i] = ch;
		Scount++;
	    }else {
		weather[i] = 'P';
		Tcount++;
	    }
        }
        if(Scount == 0) {
            System.out.println(1);
        }else if(Tcount == 0) {
            System.out.println(n-1);
        }else {
	    int left = 0;
	    int notsunnyday = 0;
	    int longest = -1;
            for(int right = 0; right < weather.length; right++) {
        	if(weather[right] == 'P') {
    		    notsunnyday++;
    		}
    		while(notsunnyday > 1) {
    		    if (weather[left] == 'P') {
    			notsunnyday--; 
		    }
                    left++;
    		}
    			longest = Math.max(longest, right - left + 1);
	    }   
            System.out.println(longest);
        }
       
    }	
}
