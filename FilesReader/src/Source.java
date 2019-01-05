import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import de.ndsoft.filesReader.FileImpl;

public class Source {

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		final Remote obj = new FileImpl("c:\\myFile.txt");
		final Remote remoteStub = UnicastRemoteObject.exportObject(obj, 19001);
		// Starts RMI Registry into the program.
		final Registry registry = LocateRegistry.createRegistry (18001);
		Naming.rebind ("//localhost:18001/FileServer", remoteStub);
		Naming.unbind ("//localhost:18001/FileServer");
		
		String resp = "";
		while (resp != "quit") {
			Scanner s = new Scanner(System.in);
			resp = s.nextLine();
		}
		
		// Stops RMI Registry.
		UnicastRemoteObject.unexportObject (registry, true);
	}

}
