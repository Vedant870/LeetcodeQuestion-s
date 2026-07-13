class Solution {
    private int findIncrement(int digits) {
        int inc = 0;
        for (int i = 0; i < digits; i++) {
            inc = inc * 10 + 1;
        }
        return inc;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> seq = new ArrayList<>();
        int originalLow = low;
        // Number of digits
        int lowDigits = String.valueOf(low).length();
        while (lowDigits <= String.valueOf(high).length()) {
            // First digit
            int start = 1;
            // Generate first number like 123 / 1234 / ...
            int first = 0;
            int d = start;
            for (int i = 0; i < lowDigits; i++) {
                first = first * 10 + d;
                d++;
            }
            int inc = findIncrement(lowDigits);
            int num = first;
            while (num % 10 != 0) {
                if (num >= originalLow && num <= high)
                    seq.add(num);
                if (num % 10 == 9) break;
                num += inc;
            }
            lowDigits++;
        }
        return seq;
    }
}