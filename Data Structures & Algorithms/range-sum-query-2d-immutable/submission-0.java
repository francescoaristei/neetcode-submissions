class NumMatrix {
    private int[][] matrix;
    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix[0].length];
        this.sums = new int[matrix.length][matrix[0].length];

        int prev = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.matrix[i][j] = matrix[i][j];
                this.sums[i][j] = this.matrix[i][j] + prev;
                prev = this.sums[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            result += this.sums[i][col2] - this.sums[i][col1] + this.matrix[i][col1];
        }
        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */