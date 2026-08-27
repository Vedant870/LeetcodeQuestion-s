class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] alpha = new int[26];
        for(int i=0; i<s.length(); i++){
            alpha[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<target.length(); i++){
            int c = target.charAt(i) - 'a';
            if(alpha[c]>0){
                sb.append(target.charAt(i));
                alpha[c]--;
            }else{
                while(c<26 && alpha[c]==0){
                    c++;
                }
                if(c==26){
                    int largestChar = -1;
                    for(int j=25; j>=0; j--){
                        if(alpha[j]>0){
                            largestChar = j+'a';
                            break;
                        }
                    }
                    while(i>=1){
                        sb.deleteCharAt(i-1);
                        alpha[target.charAt(i-1)-'a']++;
                        largestChar = Math.max(largestChar, target.charAt(i-1));
                        if(largestChar > target.charAt(i-1)){
                            int justGrater = target.charAt(i-1) + 1 - 'a';
                            while(alpha[justGrater]<1){
                                justGrater++;
                            }
                            sb.append((char)(justGrater+'a'));
                            alpha[justGrater]--;
                            return smallestLeft(sb, alpha);
                        }
                        i--;
                        
                    }
                    return "";
                }
                sb.append((char)(c+'a'));
                alpha[c]--;
                return smallestLeft(sb, alpha);
            }
        }
        if(target.equals(sb.toString())){
            int n = s.length();
            alpha[sb.charAt(n-1) - 'a']++;
            int largestChar = sb.charAt(n-1);
            for(int i=n-2; i>=0; i--){
                if(sb.charAt(i) < largestChar){
                    alpha[sb.charAt(i) - 'a']++;
                    int justLarger = sb.charAt(i) - 'a' + 1;
                    while(alpha[justLarger]==0){
                        justLarger++;
                    }
                    sb.setCharAt(i, (char)(justLarger+'a'));
                    alpha[justLarger]--;
                    return setSmallestLeft(sb, i+1, alpha);
                }else{
                    alpha[sb.charAt(i) - 'a']++;
                    largestChar = Math.max(largestChar, sb.charAt(i));
                    
                }
            }
            return "";
        }else return sb.toString();
    }
    private String setSmallestLeft(StringBuilder sb, int ind, int[] alpha){
        for(int i=0; i<26; ){
            if(alpha[i]>0){
                sb.setCharAt(ind, (char)(i+'a'));
                ind++;
                alpha[i]--;
            }else i++;
        }
        return sb.toString();
    }
    private String smallestLeft(StringBuilder sb, int[] alpha){
        for(int i=0; i<26;){
            if(alpha[i]>0){
                sb.append((char)(i+'a'));
                alpha[i]--;
            }else{
                i++;
            }
        }
        return sb.toString();
    }
    private void printAlpha(int[] alpha){
        for(int i=0; i<26; i++){
            if(alpha[i]>0){
                System.out.print((char)(i+'a')+": "+alpha[i]+", ");
            }
        }
        System.out.println();
    }
}