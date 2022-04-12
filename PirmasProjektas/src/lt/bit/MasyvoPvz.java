package lt.bit;
import java.util.ArrayList;
import java.util.Arrays;
public class MasyvoPvz {
    //---------pirmas pvz
    /*
    public static void main(String[] args) {
// TODO Auto-generated method stub
        int arr[] = {1,2,3,4,5,6};
        int n = arr.length;
        int newArr[] = new int[n+1];
        int value = 7;
        System.out.println(Arrays.toString(arr));
        for(int i = 0; i<n; i++) {
            newArr[i] = arr[i];
        }
        newArr[n] = value;
        System.out.println(Arrays.toString(newArr));
    }*/
    //-------dar kitas pvz
    /*
    public static void main(String[] args) {
// TODO Auto-generated method stub
        Integer arr[] = {1,2,3,4,5,6};
        System.out.println("Array:"+Arrays.toString(arr));
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(arr));
        arrayList.add(7);
        arr = arrayList.toArray(arr);
        System.out.println("Array after adding element: "+Arrays.toString(arr));

    }*/

    //-------trecias pvz
    /*
    public static void main(String[] args) {
        Integer arr[] = {1,2,3,4,5,6};
        int n = arr.length;
        int index = 3;
        System.out.println("Original Array: "+Arrays.toString(arr));
        Integer newArr[] = new Integer[n+1];
        int j = 0;

        for(int i = 0; i<newArr.length; i++) {
            if(i==index) {
                newArr[i] = 7;
            }else {
                newArr[i] = arr[j];
                j++;
            }
        }
        newArr[index] = 7;

        System.out.println("Array after adding value: "+Arrays.toString(newArr));
    }*/

}
