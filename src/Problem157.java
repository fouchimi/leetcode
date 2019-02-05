public class Problem157 {
    public int read(char[] buf, int n) {
        char[] tempBuf = new char[4];
        int index = 0, currentIndex;
        do {
            currentIndex = read4(tempBuf);
            for(int i = 0; i < currentIndex && index < n; i++) buf[index++] = tempBuf[i];
        } while (index < n && currentIndex == 4);
        return index;
    }

    // API
    private int read4(char[] buf) {
        return 0;
    }
}
