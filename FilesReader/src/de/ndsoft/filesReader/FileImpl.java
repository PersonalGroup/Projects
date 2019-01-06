package de.ndsoft.filesReader;

import java.io.*;
import java.rmi.*;

import de.ndsoft.interfaces.FileInterface;

public class FileImpl implements FileInterface, Serializable {

   private static final long serialVersionUID = -1150718288555769992L;

   private String name;

   public FileImpl (String s) throws RemoteException {
      super();
      name = s;
   }

   public byte[] downloadFile (String fileName) {
      byte[] buffer;
      fileName = name;
      try {
         File file = new File(fileName);
         buffer = new byte[(int)file.length()];
         BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName));
         input.read(buffer,0,buffer.length);
         input.close();
      }
      catch(Exception e) {
         System.out.println("FileImpl: "+e.getMessage());
         e.printStackTrace();
         buffer = null;
      }
      return(buffer);
   }
}
