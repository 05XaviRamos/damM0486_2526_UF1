import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex32 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("secret.bin");
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriu el codi: ");
        int codi = sc.nextInt();
        boolean trobat = false;
        try {
            while (!trobat){
                dis.readInt();
                dis.readChar();
                if (codi == dis.readInt()) {
                    trobat = true;
                }
            }
            if (trobat)     {
                System.out.print(dis.readChar());
                System.out.print(dis.readChar());
                System.out.print(dis.readChar());
            }
            
        } catch (Exception e) {
            System.out.println("Codi no trobat");
        }
    }
}
