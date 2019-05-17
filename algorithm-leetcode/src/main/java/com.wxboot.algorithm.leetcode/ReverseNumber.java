public class ReverseNumber {

    
    private int reverseNumber(int number) {
        String s = String.valueOf(number);
        char[] arr = s.toCharArray();
        char minus = '-';

        int start = 0;
        if (arr[0] == minus) {
            start = 1;
        }
        int mid = ((arr.length - start) / 2);
        int right = arr.length - 1;
        for (int i = start; i <= mid && right >= mid; i++, right--) {
            char temp = arr[i];
            arr[i] = arr[right];
            arr[right] = temp;
        }
        Long result = Long.parseLong(String.valueOf(arr));
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : result.intValue();
    }

}