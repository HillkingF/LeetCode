package offer;

public class offer_11 {
    public int minArray(int[] numbers) {
        if(numbers == null || numbers.length == 0) return 0;
        int res = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] < res) return numbers[i];
        }
        return res;

    }
}
