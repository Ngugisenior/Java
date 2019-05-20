import java.io.*;
import java.util.*;

class Utkarsh {

    InputStream is;
    PrintWriter out;

    void solve() {
        int n = ni();
        assert (1 <= n && n <= 100000);

        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = ni();
            assert (1 <= a[i] && a[i] <= 10000);
        }

        int max = a[0];
        for(int x : a) {
            if(x > max) max = x;
        }

        int ans = 0;
        for(int x : a) {
            if(x != max && x > ans) ans = x;
        }

        out.println(ans);
    }

    //-----------------------------------------------------------

    void run() { 
        is = System.in; 
        out = new PrintWriter(System.out);
        long start = System.currentTimeMillis() % 1000000000;
        solve(); 
        long end = System.currentTimeMillis() % 1000000000;
        //System.out.println("TIME = " + (end - start));
        
        out.flush();
    }
    public static void main(String[] args) { 
        new Utkarsh().run();
    }
    
    byte input[] = new byte[1024];
    int len = 0, ptr = 0;
    
    int readByte() { 
        if(ptr >= len) { ptr = 0; 
            try { len = is.read(input); }
            catch(IOException e) { throw new InputMismatchException(); } 
            if(len <= 0){ return -1; } 
        } return input[ptr++];
    }
    boolean isSpaceChar(int c) { 
        return !( c >= 33 && c <= 126 ); 
    }
    int skip(){ 
        int b = readByte(); 
        while(b != -1 && isSpaceChar(b)) { b = readByte(); } 
        return b;
    }
    
    int ni() { 
        int n = 0, b = readByte(); boolean minus = false; 
        while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')) { b = readByte(); } 
        if(b == '-') { minus = true; b = readByte(); } 
        if(b == -1) { return -1; } 
        while(b >= '0' && b <= '9') { n = n * 10 + (b - '0'); b = readByte(); } 
        return minus ? -n : n;
    }
}
