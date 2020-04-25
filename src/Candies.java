public class Candies {

    public static void main(String[] args) {


        int ratings[] = new int[]{4, 6, 4, 5, 6, 2};

        long result = findMinimumCandies(ratings);

        System.out.println("Minimum candies required are => " +result);
    }

    static long findMinimumCandies(int[] ratings) {


        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        long[] candies = new long[ratings.length];
        candies[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        long minimumCandies = candies[ratings.length - 1];

        for (int i = ratings.length - 2; i >= 0; i--) {
            long cur = 1;
            if (ratings[i] > ratings[i + 1]) {
                cur = candies[i + 1] + 1;
            }
            minimumCandies += Math.max(cur, candies[i]);
            candies[i] = cur;
        }


        return minimumCandies;

    }
}
