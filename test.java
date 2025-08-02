public class test {

    //This is a final recurisve function because we are returning directly the value of the recursive function without a
    // modification in each iteration
    public static int binarySearch(int target, int[] nums){
        return binarySearchRec(target, nums, 0, nums.length-1);
    }
    public static int binarySearchRec(int target, int[] nums, int left, int right){
        if(left>right) return left;

        int middle = (int) (left+right)/2;
        if(nums[middle] == target) return middle;

        if(nums[middle] > target){
            return binarySearchRec(target, nums, left, middle-1);
        } else{
            return binarySearchRec(target, nums, middle+1, right);
        }
    }


    //given a number n for example 16, we want to check if its square root is an integer, but we can not use 
    //the library Math, and ** does not exists in java

    public static boolean isPerfectSquare(long num ){
        return isPerfectSquareRec(num, 1, num);
    }

    public static boolean isPerfectSquareRec(long num, long left, long right){
        if(left>right) return false;

        long middle = (long) (left+right)/2;

        if(middle*middle == num) return true;

        if(middle*middle > num) return isPerfectSquareRec(num, left, middle-1);
        else return isPerfectSquareRec(num, left, right);
    }


    public static void main(String[] args){

        int[] nums = {1,2,4,5,6,19};
        // System.err.println(binarySearch(7, nums));
    }
    
}
