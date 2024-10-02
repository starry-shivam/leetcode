import utils.ExecDuration;

import java.util.Arrays;

public class KokoEatingBananas875 {

    public static void main(String[] args) {
        KokoEatingBananas875 obj = new KokoEatingBananas875();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(obj.minEatingSpeed(piles, h));
        ExecDuration.measure(() -> obj.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();
        int res = end;

        while (start <= end) {
            int k = (start + end) / 2;
            long hours = 0;
            for (int pile : piles) {
                hours +=(pile + k - 1) / k; // ceil(pile / k)
            }
            if (hours <= h) {
                res = Math.min(k, res);
                end = k - 1;
            } else {
                start = k + 1;
            }
        }
        return res;
    }
}
