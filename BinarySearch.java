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
            return isPerfectSquareRecursive(num, middle+1, right);
        }
    }


public static void main (String[] args){
    List<Integer> array = List.of(1,2,3,4,5,6,13,16,17,20);
    System.out.println(binarySearch(1, array)); 
}
    
}
