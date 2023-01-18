public class LongestPalindromeSubsequenceUsingTopDown {
    public static void main(String[] args){
        String s1 = "MADAM";
        int[][] arr = new int[s1.length()][s1.length()];
        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr.length; j++){
                arr[i][j] = -1;
            }
        }
        int m =Solution(s1, 0,s1.length()-1,arr);
        System.out.println(m);
    }
    public static int Solution(String s1, int start, int end, int[][] arr){
        if (start == end){
            return 1;
        }
        else if (start > end){
            return 0;
        }
        else if (arr[start][end]!=-1){
            return arr[start][end];
        }
        else if (s1.charAt(start) == s1.charAt(end)){
            arr[start][end] = 2 + Solution(s1,start+1,end-1,arr);
            return arr[start][end];
        }
        else {
            arr[start][end] = Math.max(Solution(s1, start+1, end, arr),Solution(s1, start, end-1, arr));
            return arr[start][end];
        }
    }
}
