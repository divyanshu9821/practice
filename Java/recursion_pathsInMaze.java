public class recursion_pathsInMaze {
    
    static int m,n;
    static int countPaths(int i,int j){
        if(i==m||j==n)return 0;
        if((i==(m-1))&&(j==(n-1)))return 1;

        int down = countPaths(i+1,j);

        int right = countPaths(i, j+1);
        return down+right;
    }

    public static void main(String[] args) {
        m= 10;
        n=10;
        System.out.println(countPaths(0, 0));
    }
}
