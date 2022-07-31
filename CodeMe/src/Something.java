import java.util.Scanner;

class Something {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String up = "\\/";
        String down = "/\\";
        int t = Integer.parseInt(sc.nextLine());
        int[] size = new int[t];
        for (int test = 0; test < t; test++) {
            size[test] = Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < t; i++) {
            if (size[i] % 2 == 0) {
                evenPattern(size[i], up, down);
            } else {
                oddPattern(size[i],up,down);
            }
        }


        //System.out.println(space(init)+up + space(middle)+ up+space(init));
    }

    public static void evenPattern(int size, String up, String down) {
        for (int i = 0; i < size / 2; i++) {
            int init = i * 2;
            System.out.println(space(init) + up + space((size * 2) - 4 - (2 * init)) + up + space(init));
            System.out.println(space(init) + down + space((size * 2) - 4 - (2 * init)) + down + space(init));

        }
        for (int i = size / 2 - 1; i >= 0; i--) {
            int init = i * 2;
            System.out.println(space(init) + up + space((size * 2) - 4 - (2 * init)) + up + space(init));
            System.out.println(space(init) + down + space((size * 2) - 4 - (2 * init)) + down + space(init));

        }
    }

    public static void oddPattern(int size,String up, String down) {
        int flag=0;
        for (int i = 0; i < size / 2; i++) {
            int init = i * 2;
            System.out.println(space(init) + up + space((size * 2) - 4 - (2 * init)) + up + space(init));
            System.out.println(space(init) + down + space((size * 2) - 4 - (2 * init)) + down + space(init));
            flag=i+1;

        }
        System.out.println(space(flag*2)+up+space(flag*2));
        System.out.println(space(flag*2)+down+space(flag*2));
        for (int i = size / 2 - 1; i >= 0; i--) {
            int init = i * 2;
            System.out.println(space(init) + up + space((size * 2) - 4 - (2 * init)) + up + space(init));
            System.out.println(space(init) + down + space((size * 2) - 4 - (2 * init)) + down + space(init));

        }

    }

    public static String space(int n) {
        String s = "";
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            builder.append(" ");
        }
        return (builder.toString());
    }
}

