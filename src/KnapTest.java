
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class KnapTest {



    @Test
    void testmoreBasicKnapsack() {
        // Given: values and weights arrays, and a knapsack capacity
        int[] values = {100, 120};
        int[] weights = {20, 30};
        Knap knap = new Knap();

        // The knapsack capacity is 50, the optimal solution should be to take items 2 and 3 (100 + 120 = 220)
        assertEquals(120, knap.knapsack(values, weights, 40));
    }
    @Test
    void testBasicKnapsack() {
        // Given: values and weights arrays, and a knapsack capacity
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        Knap knap = new Knap();

        // The knapsack capacity is 50, the optimal solution should be to take items 2 and 3 (100 + 120 = 220)
        assertEquals(220, knap.knapsack(values, weights, 50));
    }

    @Test
    void testKnapsackWithNoItems() {
        // Given: empty values and weights arrays, and any capacity
        int[] values = {};
        int[] weights = {};
        Knap knap = new Knap();

        // If there are no items, the maximum value that can be put in the knapsack is 0
        assertEquals(0, knap.knapsack(values, weights, 50));
    }

    @Test
    void testKnapsackWithZeroCapacity() {
        // Given: values and weights arrays, and a knapsack with zero capacity
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        Knap knap = new Knap();

        // With zero capacity, the knapsack cannot hold anything, so the maximum value is 0
        assertEquals(0, knap.knapsack(values, weights, 0));
    }

    @Test
    void testKnapsackWhereItemsCannotFit() {
        // Given: values and weights arrays with a knapsack capacity that can't hold any of the items
        int[] values = {60, 100, 120};
        int[] weights = {50, 60, 70};
        Knap knap = new Knap();

        // Since all items exceed the knapsack's capacity (50), the maximum value is 0
        assertEquals(0, knap.knapsack(values, weights, 40));
    }

    @Test
    void testKnapsackWithOptimalSubset() {
        // Given: values and weights arrays with a knapsack that can fit a subset of items optimally
        int[] values = {60, 100, 120, 80};
        int[] weights = {10, 20, 30, 15};
        Knap knap = new Knap();

        assertEquals(240, knap.knapsack(values, weights, 50));
    }

    @Test
    void testKnapsackWithAllItemsFit() {
        // Given: values and weights arrays and a knapsack large enough to fit all items
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        Knap knap = new Knap();

        // If the knapsack can fit all items (capacity=60), the optimal value will be the sum of all items: 60 + 100 + 120 = 280
        assertEquals(280, knap.knapsack(values, weights, 60));
    }

    @Test
    void testKnapsackWithLargerCapacity() {
        // Given: values and weights arrays and a larger knapsack capacity
        int[] values = {60, 100, 120, 130, 140};
        int[] weights = {10, 20, 30, 40, 50};
        Knap knap = new Knap();

        // The knapsack capacity is 100, the optimal solution should choose the best combination of items to maximize value
        // With capacity 100, the optimal combination is taking items 1, 2, 3, and 4 (total value = 60 + 100 + 120 + 130 = 410)
        assertEquals(410, knap.knapsack(values, weights, 100));

        // Now, test with even larger capacity, e.g., 150, and check that it should still include the best set of items,
        // possibly adding item 5 (value=140) to the knapsack.
        // With capacity 150, we can take all items, so the total value = 60 + 100 + 120 + 130 + 140 = 550
        assertEquals(550, knap.knapsack(values, weights, 150));
    }




}
