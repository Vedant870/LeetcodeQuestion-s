class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;
        int[] ans = new int[k];
        SegmentTree st = new SegmentTree(s.toCharArray());
        for (int i = 0; i < k; i++) {
            st.update(queryIndices[i], queryCharacters.charAt(i));
            ans[i] = st.tree[1].best;
        }

        return ans;
    }
    static class Node {
        int len;
        int pref;
        int suff;
        int best;
        char leftChar;
        char rightChar;
        Node(int len, int pref, int suff, int best, char leftChar, char rightChar) {
            this.len = len;
            this.pref = pref;
            this.suff = suff;
            this.best = best;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }
    static class SegmentTree {
        Node[] tree;
        char[] arr;
        int n;
        SegmentTree(char[] arr) {
            this.arr = arr;
            n = arr.length;
            tree = new Node[4 * n];
            build(1, 0, n - 1);
        }
        void build(int node, int l, int r) {
            if (l == r) {
                tree[node] = new Node(1, 1, 1, 1, arr[l], arr[l]);
                return;
            }
            int mid = (l + r) / 2;
            build(node * 2, l, mid);
            build(node * 2 + 1, mid + 1, r);
            tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
        }
        void update(int idx, char c) {
            arr[idx] = c;
            update(1, 0, n - 1, idx, c);
        }
        void update(int node, int l, int r, int idx, char c) {
            if (l == r) {
                tree[node] = new Node(1, 1, 1, 1, c, c);
                return;
            }
            int mid = (l + r) / 2;
            if (idx <= mid) {
                update(node * 2, l, mid, idx, c);
            } else {
                update(node * 2 + 1, mid + 1, r, idx, c);
            }
            tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
        }
        Node merge(Node a, Node b) {
            int len = a.len + b.len;
            int pref = a.pref;
            int suff = b.suff;
            int best = Math.max(a.best, b.best);
            if (a.rightChar == b.leftChar) {
                best = Math.max(best, a.suff + b.pref);
                if (a.pref == a.len) {
                    pref = a.len + b.pref;
                }
                if (b.suff == b.len) {
                    suff = b.len + a.suff;
                }
            }
            return new Node(
                len,
                pref,
                suff,
                best,
                a.leftChar,
                b.rightChar
            );
        }
    }
}