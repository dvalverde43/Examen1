import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int f,c;
        System.out.println("Digite la cantidad de filas: ");
        f = scanner.nextInt();
        System.out.println("Digite la cantidad de columnas: ");
        c = scanner.nextInt();
        Interfaz i = new Interfaz(f,c);
    }
}