
package plagiarismdetector;

public class RabinKarp {
    
    public static int RabinKarp(String pat, String txt){ 
        int q = 101, d = 256;
        int M = pat.length();
        int N = txt.length();
        int i, j; 
        int p = 0; 
        int t = 0;  
        int h = 1;
        int returnValue = 0;
        
        for (i = 0; i < M-1; i++) 
            h = (h*d)%q; 

        for (i = 0; i < M; i++) 
        { 
            p = (d*p + pat.charAt(i))%q; 
            t = (d*t + txt.charAt(i))%q; 
        } 
        for (i = 0; i <= N - M; i++) 
        { 
            if ( p == t ) { 
            for (j = 0; j < M; j++) 
            { 
                if (txt.charAt(i+j) != pat.charAt(j)) 
                    break; 
            } 
            if (j == M) 
                returnValue = i; 
        } 
        if ( i < N-M ){ 
            t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;
            if (t < 0)
                t = (t + q); 
        } 
        }
        return returnValue;
    }
    
}
