package plagiarismdetector;

public class MianFunctionDitection {
    
    public static int CheckMainFuncion(String s1, int index, String s2, int index1){
        int points;
        int bracket = 0, l1 = 0, l2 = 0;
        for(int t=index; t<s1.length();t++){
            l1++;
            if(s1.charAt(t) == '{')
                bracket++;
            else if(s1.charAt(t) == '}' && bracket !=0){
                bracket--;
                if(bracket == 0)
                    break;
            }
        }
        bracket = 0;
        for(int t=index1; t<s2.length();t++){
            l2++;
            if(s2.charAt(t) == '{')
                bracket++;
            else if(s2.charAt(t) == '}' && bracket !=0){
                bracket--;
                if(bracket ==0)
                    break;
            }
        }
        int length1=0, length2=0;
        
        length1 = l1+index;
        length2 = l2+index1;
   
        points = 0;
        int j = index1;
        for(int i=index; i<length1 && j<length2 ; i++, j++){
            if(s1.charAt(i) == s2.charAt(j)){
                points++;
                continue;
            }
            while(s1.charAt(i) != s2.charAt(j)){
               
                if(i+1>=length1 || j+1>=length2){
                    break;
                }
                else{
                if(s1.charAt(i+1) == s2.charAt(j)){
                    i++;
                    points++;
                }
                else if(s1.charAt(i) == s2.charAt(j+1)){
                    j++;
                    points++;
                 }
                else{
                    if(length1>length2)
                        i++;
                    else if(length2>length1)
                        j++;
                    else{
                        i++; j++;
                    }
                }
            }
            }
        }
        return points;
    }
    
}
