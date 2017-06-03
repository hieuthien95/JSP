package read_write_obj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Program {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
//	
//		Member m = new Member("Tuan", 17);
//		
//		FileOutputStream fos = new FileOutputStream("data.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		
//		oos.writeObject(m);
//		
//		oos.close();
//		fos.close();
		
		FileInputStream fis = new FileInputStream("D:/data.txt");
		ObjectInputStream ios = new ObjectInputStream(fis);
		
		Member m = (Member) ios.readObject();
		
		System.out.println(m);
		fis.close();
		ios.close();
		 
		
		
	}

}
