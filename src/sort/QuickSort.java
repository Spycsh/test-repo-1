package sort;

import test.Test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class QuickSort extends UnicastRemoteObject implements SortInterface
{

    public QuickSort() throws RemoteException{

    }
   int array[];
//    public static void main(String[] args){
//        array = new int[]{2,4,5,1,3};
//        quickSort(0,array.length-1);
//
//        System.out.println(Arrays.toString(array));
//    }
    public void quickSort( int left, int right) throws RemoteException {
//        if(left > right) return;
//        int i = left;
//        int j = right;
//        int pivot = array[left];
//        while(i <j){
//            while(i<j && array[j] >= pivot){
//                j--;
//            }
//            if(i<j) array[i++] = array[j];
//
//            while(i<j && array[i] < pivot){
//                i++;
//            }
//            if(i<j) array[j--] = array[i];
//
//            System.out.println(Arrays.toString(array));
//        }
//        array[i] = pivot;
//        quickSort(left, i-1);
//        quickSort(i+1, right);
        System.out.println("quicksort");
        Test test = new Test();
        test.print();
    }
}
