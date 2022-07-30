import java.util.Scanner;

class SpiralRhombus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        for(int t=0; t<test; t++){
            String det = sc.nextLine();
            String[] arr = det.split(" ");
            int h = Integer.parseInt(arr[0]);
            int N = Integer.parseInt(arr[1]);
            String s = sc.nextLine();
            rhombus(h,N,s);
        }
    }
    public static void rhombus(int h, int N, String s) {
        int size = 2 * h - 1;
        char[][] sol = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sol[i][j] = ' ';
            }
        }

        int i = size / 2;
        int j = 0;
        //String s = "abcdefghijklmnop";
        int len = s.length();
        int in = 0;
        int left = 0, top = 0, right = size - 1;
        int bottom = size - 1;
        boolean flag = false;
        while (i != j) {
            while (i >= top && !flag) {
                sol[i][j] = s.charAt((in++) % len);
                if (i == size / 2 && j == size / 2)
                    flag = true;
                i--;
                j++;
            }
            if (flag)
                break;
            i += 2;
            top++;
            left++;
            while (j <= right) {
                sol[i][j] = s.charAt((in++) % len);
                i++;
                j++;
            }
            j -= 2;
            right--;
            while (i <= bottom) {
                sol[i][j] = s.charAt((in++) % len);
                i++;
                j--;
            }
            bottom--;
            i -= 2;
            while (j >= left) {
                sol[i][j] = s.charAt((in++) % len);
                i--;
                j--;
            }
            j++;
        }
        sol[i][j] = s.charAt((in) % len);
        for (int a = 0; a < size; a++) {
            for (int b = 0; b < size; b++) {
                System.out.print(sol[a][b]);
            }
            System.out.println();
        }
    }
}
