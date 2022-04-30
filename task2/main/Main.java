package homework3.task2;

class Main {

    public static void main(String[] args) {
        System.out.println(Median.median(new int[]{5, 5, 5, 100, 5, 5, 5, 5})); //5
        System.out.println(Median.median(new int[]{1, 5, 2, 8, 7})); //5
        System.out.println(Median.median(new int[]{1, 6, 2, 8, 7, 2})); //4
        System.out.println(Median.median(new int[]{1, 2, 3, 4})); //2.5
        System.out.println(Median.median(new int[]{10, -7})); //1.5
        System.out.println(Median.median(new int[]{-4})); //-4

        System.out.println(Median.median(new double[]{1, 0.5, 0.5, 0.5, 0.5, 0.55, 0.5, 0.5})); //0.5
        System.out.println(Median.median(new double[]{0.5, 0.2, 0.4, 0.3, 0.1})); //0.3
        System.out.println(Median.median(new double[]{0.1, 0.2, 0.3, 0.4, 0.2, 0.5})); //0.25
        System.out.println(Median.median(new double[]{2.6, 12.2, 3.5})); //3.5
        System.out.println(Median.median(new double[]{0})); //0.0
    }
}
