class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        
        // Initialize each StringBuilder
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean goingDown = false;

        // Traverse through characters in s
        for (char c : s.toCharArray()) {
            rows[row].append(c);

            // Change direction if we are at top or bottom row
            if (row == 0 || row == numRows - 1) {
                goingDown = !goingDown;
            }

            // Update row index
            row += goingDown ? 1 : -1;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }

        return result.toString();
    }
}
