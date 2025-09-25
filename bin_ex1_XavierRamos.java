import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class bin_ex1_XavierRamos {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("secret.bin");
        FileOutputStream fos = new FileOutputStream(f);
        DataOutputStream dos = new DataOutputStream(fos);
        int randomNum = 0;
        int randomChar;

        for (int i = 0; i < 10; i++) {
            try {
                randomNum += (int)(Math.random()*3)+1;
                dos.writeInt(randomNum);
                System.out.print(randomNum);
                randomChar = (int)(Math.random()*26)+'A';
                dos.writeChar((char)randomChar);
                System.out.print((char)randomChar);
                randomChar = (int)(Math.random()*26)+'A';
                dos.writeChar((char)randomChar);
                System.out.print((char)randomChar);
                randomChar = (int)(Math.random()*26)+'A';
                dos.writeChar((char)randomChar);
                System.out.println((char)randomChar);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        try {
            fos.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}