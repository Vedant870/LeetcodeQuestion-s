class Solution {
    private static final int MAXN = 50002;
    private static final double EPSILON = 1e-12;
    private double[] logFact;

    private void precomputeLogFactorials() {
        logFact = new double[MAXN];
        logFact[0] = 0.0;
        for (int i = 1; i < MAXN; i++) {
            logFact[i] = logFact[i - 1] + Math.log(i);
        }
    }

    private double getLogPermutations(int n, Map<Character, Integer> cnt) {
        double res = logFact[n];
        for (int f : cnt.values()) {
            res -= logFact[f];
        }
        return res;
    }

    public String smallestPalindrome(String s, long k) {
        precomputeLogFactorials();

        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int oddCount = 0;
        char oddChar = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                oddChar = (char) (i + 'a');
            }
        }
        if (oddCount > 1) {
            return "";
        }

        // Build half string
        StringBuilder half = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            freq[i] /= 2;
            char c = (char) (i + 'a');
            while (freq[i]-- > 0) {
                half.append(c);
            }
        }

        String halfStr = half.toString();
        Map<Character, Integer> cnt = new TreeMap<>();
        for (char c : halfStr.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        int len = halfStr.length();

        StringBuilder result = new StringBuilder();
        while (result.length() < len) {
            boolean found = false;
            for (char ch : cnt.keySet()) {
                int f = cnt.get(ch);
                if (f == 0) continue;

                cnt.put(ch, f - 1);
                double logPerms = getLogPermutations(len - result.length() - 1, cnt);
                double logK = Math.log(k);

                if (logPerms + EPSILON >= logK) {
                    result.append(ch);
                    found = true;
                    break;
                } else {
                    long permutations = (long) Math.round(Math.exp(logPerms));
                    if (k > permutations) {
                        k -= permutations;
                        cnt.put(ch, f);
                    } else {
                        result.append(ch);
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                return "";
            }
        }
        String rev = new StringBuilder(result).reverse().toString();
        if (oddChar != 0) {
            result.append(oddChar);
        }
        result.append(rev);
        return result.toString();
    }
}