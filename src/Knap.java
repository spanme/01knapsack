public class Knap {
    public int knapsack(int[] values, int[] weights, int capacity) {
        if (weights.length == 0 || capacity == 0) {
            return 0;
        }
        return knapsackr(values, weights, capacity,0);
    }

    public int knapsackr(int[] values, int[] weights, int capacity, int i) {
        int addme = 0;
        if (i >= weights.length ) {
            return 0;
        }
        int n = i + 1;
        if (weights[i] <= capacity) {
            addme = values[i] + knapsackr(values, weights, capacity - weights[i], n);
        }
        return Math.max(addme, knapsackr(values, weights,capacity, n));
    }
}
