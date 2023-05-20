import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void yn (boolean flag) throws IOException {
        FastWriter out = new FastWriter();
        if (flag){
            out.print("YES");
        }else{
            out.print("NO");
        }

        out.close();
    }

    public static <T extends Number & Comparable<T>> T gcd(T a, T b) {
        if (b.longValue() == 0) {
            return a;
        }
        return gcd(b, (T) (Number) (a.longValue() % b.longValue()));
    }

    public static long lcm(long a, long b){
        return (a*b) / gcd(a,b);
    }

    public static boolean isPowerOf(int base , int number) {
        if (number <= 0) {
            return false;
        }
        double logValue = Math.log(number) / Math.log(base);
        return Math.abs(logValue - Math.round(logValue)) < 1e-10;
    }

    public static <T extends Number & Comparable<T>> boolean isPrime(T n) {
        if (n.intValue() <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n.longValue()); i++) {
            if (n.longValue() % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long binaryToDecimal(long number){
        return Integer.parseInt(String.valueOf(number),2);
    }
    public static long binaryToDecimal(String number){
        return Integer.parseInt(number,2);
    }

    public static boolean canFormC(int a, int b , int c){
        //can get c from a and b
        for (int i = 0; i <= c/2; i++) {
            int j = c - (i*a);
            if (j%b ==0){
                return true;
            }
        }

        return false;
    }

    public static boolean isInteger(Object value) {
        if (value instanceof Integer) {
            return true;
        } else {
            return false;
        }
    }

    public static int sumDigits(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
        public int[] nextIntArr() throws IOException {
            String[] str = br.readLine().split("\\s+");
            int[] inp = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                inp[i] = Integer.parseInt(str[i]);
            }
            return inp;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;
        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        public void print(Object object) throws IOException {
            bw.append("" + object);
        }
        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }
        public void close() throws IOException {
            bw.close();
        }
    }

    public static void main(String[] args) throws IOException{
        FastReader s = new FastReader();
        FastWriter out = new FastWriter();
//---------------------------------------------------------<{START}>-----------------------------------------------------//

        int n = s.nextInt();
        int even = 0;
        int odd =0;

        int count;

        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            sum+=arr[i]/2;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] %2==0){
                out.println(arr[i]/2);
            }else{
                if (sum>0){
                    if (arr[i] >0){
                        out.println((arr[i]/2));
                    }else{
                        out.println((arr[i]/2)-1);
                        sum--;
                    }

                }else if (sum <0){
                    if (arr[i] > 0){
                        out.println((arr[i]/2)+1);
                        sum++;
                    }else{
                        out.println((arr[i]/2));
                    }

                }else{
                    out.println(arr[i]/2);
                }
            }
        }

//---------------------------------------------------------<{END}>-------------------------------------------------------//
        out.close();
    }

}
