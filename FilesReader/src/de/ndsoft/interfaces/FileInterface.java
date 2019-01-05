package de.ndsoft.interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileInterface extends Remote {

   byte[] downloadFile (String fileName) throws RemoteException;

}
