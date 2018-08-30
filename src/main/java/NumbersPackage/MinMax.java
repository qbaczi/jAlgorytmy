package NumbersPackage;

import java.util.stream.IntStream;

public class MinMax {

    private static int[] tab = {7, 6, 1, 3, 8, 10, 13, 2};

    public static void main(String[] args) {

        printArray(tab);
        System.out.println();
        System.out.println("======================1==========================");
        System.out.println(maxValue() + " max");
        System.out.println(minValue() + " min");
        System.out.println("======================2==========================");
        printArray(reverse(tab));
        System.out.println();
        System.out.println("=======================3=========================");
        printArray(numberX2(tab));
        System.out.println();
        System.out.println("========================4=========================");
        printArray(minMaxReverse(tab));
        System.out.println();
        System.out.println("=========================5=========================");


        printArray(bubbleSort(tab));
        System.out.println();
        printArray(bubbleSort2(tab,false));
    }


    private static void printArray(int[] tab) {
        IntStream.of(tab).forEach((number) -> System.out.print(number + " "));
    }

    private static int[] bubbleSort(int[] tab) {

        for (int i = tab.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (tab[j] > tab[j + 1]) {
                    swap(tab, j, j + 1);
                }
            }
        }
        return tab;
    }

    private static int[] bubbleSort2(int[] tab, boolean check) {


        for (int i = tab.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (check) {
                    if (tab[j] > tab[j + 1]) {
                        swap(tab, j, j + 1);
                    }
                }else {
                    if (tab[j] < tab[j + 1]) {
                        swap(tab, j, j + 1);
                    }
                }
            }
        }
        return tab;
    }

    private static void swap(int[] tab, int index1, int index2) {
        int temp;
        temp = tab[index1];
        tab[index1] = tab[index2];
        tab[index2] = temp;
    }

    private static int maxValue() {

        int max = tab[0];

        for (int i = 1; i < tab.length; i++) {

            if (tab[i] > max) {
                max = tab[i];
            }
        }
        return max;
    }

    private static int minValue() {


        int min = tab[0];

        for (int i = 1; i < tab.length; i++) {
            if (tab[i] < min) {
                min = tab[i];

            }
        }

        return min;
    }

    private static int[] reverse(int[] tab) {
        int[] tab2 = new int[tab.length];
        int y = 0;
        for (int i = tab.length - 1; i >= 0; i--) {
            tab2[i] = tab[y];
            y++;
        }
        return tab2;

    }


    private static int[] numberX2(int[] tab) {
        int[] tab3 = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            tab3[i] = tab[i] * 2;
        }
        return tab3;
    }

    private static int maxValueIndex(int[] tab) {

        int max = tab[0];
        int count = 0;

        for (int i = 1; i < tab.length; i++) {

            if (tab[i] > max) {
                max = tab[i];
                count = i;
            }

        }
        return count;
    }

    private static int minValueIndex(int[] tab) {


        int min = tab[0];
        int count = 0;
        for (int i = 1; i < tab.length; i++) {
            if (tab[i] < min) {
                min = tab[i];
                count = i;
            }

        }
        return count;
    }

    private static int[] minMaxReverse(int[] tab) {

        int tmp = tab[maxValueIndex(tab)];

        tab[maxValueIndex(tab)] = tab[minValueIndex(tab)];
        tab[minValueIndex(tab)] = tmp;

        return tab;
    }

}