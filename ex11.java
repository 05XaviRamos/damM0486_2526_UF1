import java.io.File;

public class ex11 {
    public static void main(String[] args) {
        String ruta = args[0];
        File path = new File(ruta);

        File[] files = path.listFiles();

        for (File file : files) {
            String resultat = "";
            if (file.isDirectory()){
                resultat += "d";
            } else if (file.isFile()){
                resultat += "-";                
            }
            if (file.canRead()){
                resultat += "r";
            } else {
                resultat += "-";
            }
            if (file.canWrite()){
                resultat += "w";
            } else {
                resultat += "-";
            }
            if (file.canExecute()){
                resultat += "x";
            } else {
                resultat += "-";
            }
            System.out.println(resultat + " " + file.getName());
        }
    }
}
