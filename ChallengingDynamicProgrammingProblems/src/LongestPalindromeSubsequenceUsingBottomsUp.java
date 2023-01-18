public class LongestPalindromeSubsequenceUsingBottomsUp {
    public static void main(String[] args){
        Solution("TMENENT");
    }

    public static void Solution(String s1) {
        int[][] arr = new int[s1.length()][s1.length()];
        for (int end = 0; end < s1.length(); end++) {
            for (int start = s1.length() - 1; start >= 0; start--) {
                if (start > end) {
                    arr[start][end] = 0;
                } else if (start == end) {
                    arr[start][end] = 1;
                } else {
                    if (s1.charAt(start) == s1.charAt(end)) {
                        arr[start][end] = Math.max(2 + arr[start + 1][end - 1], Math.max(arr[start][end - 1], arr[start + 1][end]));
                    } else {
                        arr[start][end] = Math.max(arr[start][end - 1], arr[start + 1][end]);
                    }
                }
            }
        }
        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr.length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println(arr[0][s1.length()-1]);
    }
}


