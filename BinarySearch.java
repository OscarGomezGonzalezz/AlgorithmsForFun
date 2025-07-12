import java.util.List;

public class BinarySearch {

    public static String binarySearch(Integer target, List<Integer> array){
        return binarySearchRecursive(target, array, 0, array.size()-1);
    }

    public static String binarySearchRecursive(Integer target, List<Integer> array, int leftIndex, int rightIndex){

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

public static void main (String[] args){
    List<Integer> array = List.of(1,2,3,4,5,6,13,16,17,20);
    System.out.println(binarySearch(1, array)); 



}
    
}
