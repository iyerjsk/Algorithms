package arrays;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 *
 * Return true if and only if the given array A is monotonic.
 *
 *
 */
public class MonotonicArray {
    public boolean isMonotonic(int[] A) {

        int diff = 0;
        for (int i = 0, j = 1; i < A.length - 1; i++, j++){
            if(diff > 0 && A[j] - A[i] < 0){
                return false;
            }else if(diff < 0 && A[j] - A[i] > 0){
                return false;
            }else if(A[i] != A[j]){
                diff = A[j] - A[i];
            }
        }
        return true;
    }
}
