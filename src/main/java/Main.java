import java.util.Scanner;
import Services.ReaderMavenCSV;
import Services.ProductServices;

public class Main {

    public static void main(String[] args) {
        ProductServices productServic = new ProductServices();
        ReaderMavenCSV readerMavenCSV = new ReaderMavenCSV();
        Scanner sc= new Scanner(System.in);
        // Cargar productos desde un archivo CSV
        System.out.println("Seleciona por favor que va realizar");
        System.out.println("1.Ver Productos");
        System.out.println("2.Añadir");
        System.out.println("3.remover");
        System.out.println("4.ReaderCSV\n");

        int seleccion = 0;
        while (seleccion!=4) {
            seleccion = sc.nextInt();
            switch (seleccion) {

                case 1-> productServic.cargarProductosDesdeCSV("C:\\Users\\acer\\IdeaProjects\\readerCSV\\csv-product-exercise-java\\resources\\inventory.csv");
                case 2-> productServic.add();
                case 3-> productServic.remove();
                case 4-> readerMavenCSV.readerMavenCSV();
            }

        }
    }
}
