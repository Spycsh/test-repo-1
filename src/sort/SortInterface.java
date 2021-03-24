package sort;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SortInterface extends Remote {
    public void quickSort( int left, int right) throws RemoteException;
}
