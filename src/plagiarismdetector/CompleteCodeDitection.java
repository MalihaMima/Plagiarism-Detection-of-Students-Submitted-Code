
package plagiarismdetector;

public class CompleteCodeDitection {
    
    public static int CodeDitection(String s1, String s2){
        
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 == 0)
            return 0;
        else if(l2 == 0)
            return 0;
        else{
        int[][] L = new int[l1+1][l2+1];
        int i, j;
        for(i=0; i<=l1; i++){
            
            for(j=0;j<=l2; j++){
                
                if(i==0 || j==0)
                    L[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;
                else{
                    if(L[i-1][j] > L[i][j-1])
                        L[i][j] = L[i-1][j];
                    else
                        L[i][j] = L[i][j-1];
                } 
                
            }
        }
        return L[l1][l2];
        }
    }
}
