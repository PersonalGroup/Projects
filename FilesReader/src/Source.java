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
		// Open port 1099, 19001 and 18001 on the firewall.
		final Remote obj = new FileImpl("c:\\myFile.txt");
		final Remote remoteStub = UnicastRemoteObject.exportObject(obj, 19001);
		// Starts RMI Registry into the program.
		final Registry registry = LocateRegistry.createRegistry (18001);
		Naming.rebind ("//localhost:18001/FileServer", remoteStub);
		
		String resp = "";
		while (!resp.contentEquals("quit")) {
			System.out.println("write \"quit\" to terminate the program: ");
			Scanner s = new Scanner(System.in);
			resp = s.nextLine();
			System.out.println("you are writen: " + resp);
			//s.close();
		}
		
		Naming.unbind ("//localhost:18001/FileServer");
		
		// Stops RMI Registry.
		UnicastRemoteObject.unexportObject (registry, true);
		
		System.out.println("Program end.");
		System.exit(0);
	}

}
