import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ex41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriu el nom d'usuari: ");
        String nom = sc.nextLine();
        
        try {
            File f = new File(nom+".usr");
            if (f.exists()){
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));   
                User u = (User) ois.readObject(); 
                System.out.print("Escriu la contrasenya: ");
                String pass = sc.nextLine();            
                if (u.pass.equals(pass)) {
                    System.out.println("Accés correcte al sistema");
                } else {
                    System.out.println("Accés no concedit: La contrasenya no és correcta");
                } 
                ois.close();               
            } else {               
                System.out.print("No s'ha trobat l'usuari, vols registrar-te? ");
                String option = sc.nextLine();
                if (option.equalsIgnoreCase("si")) {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                    System.out.print("Escriu la contrasenya: ");
                    String pass = sc.nextLine();
                    oos.writeObject(new User(nom, pass));
                    oos.close();
                } else {
                    System.out.println("Programa finalitzat");
                }
            }            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
