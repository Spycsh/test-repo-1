package test;

import sort.QuickSort;

import java.rmi.RemoteException;

public class Test {


    public void print(){
        System.out.println("here i am");
    }

    public Test() throws RemoteException {
        QuickSort s1 = new QuickSort();
    }

    public static void main (String [] argv) throws RemoteException {
        QuickSort s2 = new QuickSort();
        s2.quickSort(0,1);
        System.out.println("hi");

    }
}
