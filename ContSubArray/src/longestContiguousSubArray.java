import java.util.HashMap;

public class longestContiguousSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 // Define test cases
		
		int[] arr1 = {1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0}; // 8
		
	    int[] arr2 = {0, 1, 0, 0, 1, 1, 0}; // 6
		
		int[] arr3 = {1, 1, 1, 0, 0, 0, 1, 0}; // 8
		
		int[] arr4 = {0, 0, 0, 1, 0, 1, 0, 0, 0}; // 4
		
		int[] arr5 = {0, 1, 0, 0, 0, 1, 1}; // 6
		
		System.out.print("Array: [");
		
		 // Call the function and store the result
		
		int result = longestContSubArray(arr4);  
		
		System.out.print("]");
		
		System.out.println("");
		
		// Print the final result
		
		System.out.println(result);

	}
	
	public static int longestContSubArray(int[] array) {
		
		int sum = 0; // Variable to keep track of cumulative sum (treat 0 as -1 and 1 as +1)
		int longestSubArray = 0; // Variable to store the maximum length of subarray found
		
		// HashMap to store the first occurrence of each cumulative sum
		HashMap<Integer, Integer> subArrayMap = new HashMap<>();
		
		// Iterate through the array
		for (int i = 0; i < array.length; i++) {
			
			 // Convert 0 to -1 for balanced sum calculation
			if (array[i] == 0) 
			{
				sum--;
			}
			if (array[i] == 1) 
			{
				sum++;
			}
			
			 // If cumulative sum becomes zero, update the longest subarray length
			if (sum == 0) 
			{
				longestSubArray = i + 1; // Subarray from index 0 to i is balanced
			} 
			
			// Check if sum is already a key in the HashMap
			else if (!subArrayMap.containsKey(sum)) 
			{
				// Puts sum and index first found as Key-Value Pairs
				subArrayMap.put(sum, i); 
			}
			// Check if HashMap is empty and if current index - index of first occurrence > longest sub array
			else if (!subArrayMap.isEmpty() && i - subArrayMap.get(sum) > longestSubArray)
			{	
				 longestSubArray = i - subArrayMap.get(sum);
			} 
			
			  // Print each element during iteration
			System.out.print(" " + array[i] + " ");
			
		}
		return longestSubArray; // Return the maximum subarray length found
	}
}