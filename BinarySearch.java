import java.util.List;

public class BinarySearch {

    //O(log n) instead of O(n) when checking each and every element of the array with a loop
    public static String binarySearch(Integer target, List<Integer> array){
        return binarySearchRecursive(target, array, 0, array.size()-1);
    }

    public static String binarySearchRecursive(Integer target, List<Integer> array, int leftIndex, int rightIndex){

        //If the statement says: "If target is not found, return the index where it would be if it were inserted in order."
        // we should write: return left;
        if(leftIndex > rightIndex) return "Not found";

        int middleIndex = (int) Math.floor((leftIndex+rightIndex)/2);

        if(array.get(middleIndex).equals(target)) {
            return "Found";
        }
        if(array.get(middleIndex) < target){
            return binarySearchRecursive(target, array, middleIndex+1, rightIndex);
        } else {
            return binarySearchRecursive(target, array, leftIndex, middleIndex-1);
        }
    }

    public static boolean isPerfectSquare(long num) {
        return isPerfectSquareRecursive(num,1,num);
    }

    public static boolean isPerfectSquareRecursive(long num,long left,long right){
        if(left > right) return false;
        long middle = (long) (left + right)/2;
        if(middle*middle == num) return true;

        if(middle*middle > num){
            return isPerfectSquareRecursive(num, left, middle-1);
        } else{
            //comprobar si lo de abajo se podria poner tmb como isPerfectSquareRecursive(num, left, middle-1), ya que no 
            //se en que caso se puede dar que middle sea <
            return isPerfectSquareRecursive(num, middle+1, right);
        }
    }

    // O(√n) solution. They ask for the number of COMPLETED rows with n coins
    public static int arrangeCoins(int n){
        int res = 0;
        int coinsRequired = 1;
        while(n-coinsRequired>=0){
            n -= coinsRequired;
            coinsRequired ++;
            res++;
        }
        return res;
    }

    //But for improving the performance, lets do binary search O(log n) https://youtu.be/5rHz_6s2Buw?si=xEUPv0FtVVFMJgoJ
    public static int arrangeCoins2(int n) {
        return arrangeCoinsRec(n, 0, n);
    }

    public static int arrangeCoinsRec(int n, int left, int right) {
        if (left > right) return right;

        int mid = left + (right - left) / 2;
        long k = (long) mid * (mid + 1) / 2; // total coins needed for 'mid' rows

        if (k == n) {
            return mid;
        } else if (k < n) {
            return arrangeCoinsRec(n, mid + 1, right);
        } else {
            return arrangeCoinsRec(n, left, mid - 1);
        }
}


public static void main (String[] args){
    List<Integer> array = List.of(1,2,3,4,5,6,13,16,17,20);
    System.out.println(binarySearch(1, array)); 
    System.err.println(isPerfectSquare(555));

}
    
}
