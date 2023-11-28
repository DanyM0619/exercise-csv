package Services;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import Model.Product;
import Model.RemoveToString;

public class ReaderMavenCSV {

    public void readerMavenCSV(){
    //1. Instanciar la clase productServicetos para poder llamar la lista
    ProductServices productService = new ProductServices();
    //2.Obtener la lista de productos que se encuentra en el objeto productService
    List<Product> productList = productService.getProductList();

        try {
        //3.leer el archivo CSV
            FileReader fileReader = new FileReader("C:\\Users\\Daniel M\\IdeaProjects\\exercise-csv\\resources\\inventory.csv");
            CSVParser readerCSV = new CSVParser(fileReader, CSVFormat.DEFAULT);

            boolean primeraFila = true;

            for (CSVRecord csvRecord : readerCSV) {
                if (primeraFila) {
                    primeraFila = false;
                    continue;
                }
                //Solo se muestra los campos a través del archivo csv
                int codigo = Integer.parseInt(csvRecord.get(0));
                String nombre = csvRecord.get(1);
                String descripcion = csvRecord.get(2);
                String categoria = csvRecord.get(3);
                String etiqueta = csvRecord.get(4);
                double precio = Double.parseDouble(csvRecord.get(5));
                String url = csvRecord.get(6);

                Product producto = new Product(codigo, nombre, descripcion, categoria, etiqueta, precio, url);
                productList.add(producto);

                RemoveToString remove = new RemoveToString(codigo, nombre, descripcion, categoria, etiqueta, precio, url);
                System.out.println(remove);
            }
        } catch(IOException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

