package kraken.pandora;

import java.util.Scanner;

public class IsItZero {


    public static void main(String[] args) {
        final float m = 3.14f;
        float r;
        float v;

        Scanner scanner = new Scanner(System.in);
        r = scanner.nextFloat(); // 输入10

        // 计算球的面积
        v = 3 / 4 * m * r * r * r;

        System.out.println(v);
    }

}
