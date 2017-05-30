package son_guyen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SoNguyen {

	
	
	private static BufferedReader br;

	public static void main(String []args){
		ArrayList<Integer> ds = new ArrayList<Integer>();
		String s;
		try (FileReader fr = new FileReader("D:\\in.txt")) {
            br = new BufferedReader(fr);
            //�?�?c từng dòng văn bản!
            while ((s = br.readLine()) != null) {
                //System.out.println(s);
                for(int i=0; i<s.length(); i=i+2){
        			ds.add((int)s.charAt(i)-48);     
                }
            }
        }catch(IOException e){
            System.out.println("�?ã có lỗi xảy ra!");
        }
		
		Collections.sort(ds);
		
		for(int i:ds)
			System.out.println(i);
				
	}

}
