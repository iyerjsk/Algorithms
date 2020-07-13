package medianSortedArray;


/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 * @author iyerjsk
 *
 */
public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int nums1Length = nums1 != null ? nums1.length : 0;
		int nums2Length = nums2 != null ? nums2.length : 0;
		if(nums1 == null ) {
			if(nums2Length % 2 == 0) {
				return (nums2[nums2Length/2] + nums2[nums2Length -1])/2;
			}else {
				return nums2[(int)(nums2Length/2)];
			}
		}
		
		if(nums2 == null ) {
			if(nums1Length % 2 == 0) {
				return (nums1[nums1Length/2] + nums1[nums1Length -1])/2;
			}else {
				return nums1[(int)(nums1Length/2)];
			}
		}
		
		int[] x = nums1Length > nums2Length ? nums2 :  nums1;
		int[] y = nums1Length > nums2Length ? nums1 : nums2;
		
		
		
		// we need to find partition, px, py  where x[px] < y[py + 1] and y[py] < x[px + 1]
		int start = 0;
		int end = x.length;
		
		int leftX, leftY, rightX, rightY ;
		
		while(true) {
			
			int partitionX = (start + end) / 2;
		    int partitionY = ((x.length + y.length + 1 ) / 2) - partitionX;
			
			leftX = partitionX == 0 ?  Integer.MIN_VALUE : x[partitionX - 1];
			leftY = partitionY == 0 ?  Integer.MIN_VALUE : y[partitionY - 1];
			rightX = partitionX == x.length ?  Integer.MAX_VALUE : x[partitionX];
			rightY = partitionY == y.length ?  Integer.MAX_VALUE : y[partitionY];
			
			if (leftX <= rightY && leftY <= rightX) {
				break;
			} else if(leftX > rightY) {
				end = partitionX - 1;
			} else {
				start = partitionX  + 1;
			}
		}
		
		if((nums1Length + nums2Length) % 2 == 0) {
			return (double)(Math.max(leftX, leftY) + Math.min(rightX, rightY))/ 2;
		} else {
			return Math.max(leftX, leftY);
		}
        
    }
	
	public static void main (String[] args) {
		int[] input1 = {2,5,7,9,12 };
		int[] input2 = {4, 5,8,10,15,16};
		
		System.out.println (new Solution().findMedianSortedArrays(input1, input2));
		
		
		input1 = new int[] {1,3,8,9,15 };
		input2 = new int[] {7,11,18, 19, 21,25};
		
		System.out.println (new Solution().findMedianSortedArrays(input1, input2));
		
		input1 = new int[] {23,26,31,35 };
		input2 = new int[] {3,5,7,9,11,16};
		
		System.out.println (new Solution().findMedianSortedArrays(input1, input2));
		
	}

}
