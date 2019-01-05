import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import de.ndsoft.filesReader.FileImpl;

public class Source {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		// TODO Auto-generated method stub
		final Remote obj = new FileImpl("c:\\myFile.txt");
		final Remote remoteStub = UnicastRemoteObject.exportObject(obj, 19001);
		Naming.rebind ("//localhost/FileServer", remoteStub);
	}

}
