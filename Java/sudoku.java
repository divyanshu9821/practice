public class sudoku {

    public static boolean isSafe(int[][] sudokuBoard, int row, int col, int num) {
        // for col
        for (int i = 0; i < sudokuBoard.length; i++) {
            if (sudokuBoard[i][col] == num)
                return false;
        }

        // for row
        for (int j = 0; j < sudokuBoard.length; j++) {
            if (sudokuBoard[row][j] == num)
                return false;
        }

        // for grid
        int startingRow = (row/3)*3;
        int startingCol = (col/3)*3;

        for (int i = startingRow; i < (startingRow + 3); i++) {
            for (int j = startingCol; j < (startingCol + 3); j++) {
                if(sudokuBoard[i][j]==num)
                    return false;
            }
        }
        return true;
    }

    public static boolean helper(int[][] sudokuBoard, int row, int col) {
        if (row == sudokuBoard.length - 1 && col == sudokuBoard.length) {
            return true;
        }

        if (col == sudokuBoard.length) {
            col = 0;
            row++;
        }

        if (sudokuBoard[row][col] != 0) {
            return helper(sudokuBoard, row, col + 1);
        }

        for (int num = 1; num < 10; num++) {
            if (isSafe(sudokuBoard, row, col, num)) {
                sudokuBoard[row][col] = num;

                if(helper(sudokuBoard,row,col+1))
                return true;
            }

            sudokuBoard[row][col] = 0;
        }

        return false;

    }

    public static void printSudoku(int[][] sudokuBoard) {
        for (int i = 0; i < sudokuBoard.length; i++) {
            for (int j = 0; j < sudokuBoard.length; j++) {
                System.out.print(sudokuBoard[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] sudokuBoard = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        if(helper(sudokuBoard, 0, 0))
            printSudoku(sudokuBoard);
            else
                System.out.println("No valid Solution exists");

    }
}