import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import de.ndsoft.interfaces.FileInterface;

public class Source {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		final FileInterface obj = (FileInterface)Naming.lookup("//localhost:18001/FileServer");
		final byte[] filedata = obj.downloadFile("C:\\Users\\Douabalet\\Documents\\Projects\\testFileDownloaded.txt");
	}
}
