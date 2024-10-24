package co.edu.uniquindio.preparcil2.restaurante.utils;

import co.edu.uniquindio.preparcil2.restaurante.model.Costumer;
import co.edu.uniquindio.preparcil2.restaurante.model.Order;
import co.edu.uniquindio.preparcil2.restaurante.model.Product;
import co.edu.uniquindio.preparcil2.restaurante.model.Restaurant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Persistence {
    public static final String pathProperties = "persistence/db_properties.txt";
    public static final String pathProducts = "persistence/products.txt";
    public static final String pathCostumers= "persistence/costumers.txt";
    public static final String pathOrderXML= "persistence/order.xml";

    public static void loadData(Restaurant restaurant) throws FileNotFoundException, IOException {
        //cargar archivo de Usuarios
        List<Costumer> loadCostumers = loadCostumers();
        List<Product> loadProducts = loadProducts();
        if(loadCostumers.size() > 0)
            restaurant.getCostumers().addAll(loadCostumers);
        if (loadProducts.size() > 0)
            restaurant.getProducts().addAll(loadProducts);
    }

    public static List<Costumer> loadCostumers() throws FileNotFoundException, IOException
    {
        List<Costumer> costumers =new ArrayList<>();
        List<String> content = ArchivoUtil.leerArchivo(pathCostumers);
        String line="";
        for (int i = 0; i < content.size(); i++) {
            line = content.get(i);//1;juan;uni1@;12454;Armenia;125444
            Costumer costumer = new Costumer();
            costumer.setCode(Integer.parseInt(line.split("@")[0]));
            costumer.setId(line.split("@")[1]);
            costumer.setIdentificationType(line.split("@")[2]);
            costumer.setName(line.split("@")[3]);
            costumer.setLastName(line.split("@")[4]);
            costumer.setPhone(line.split("@")[5]);
            costumers.add(costumer);
        }
        return costumers;
    }
    public static List<Product> loadProducts() throws FileNotFoundException, IOException
    {
        List<Product> products =new ArrayList<>();
        List<String> content = ArchivoUtil.leerArchivo(pathProducts);
        String line="";
        for (int i = 0; i < content.size(); i++) {
            line = content.get(i);//1;juan;uni1@;12454;Armenia;125444
            Product product = new Product();
            product.setCode(Integer.parseInt(line.split("#")[0]));
            product.setName(line.split("#")[1]);
            product.setPrice(Double.parseDouble(line.split("#")[2]));
            products.add(product);
        }
        return products;
    }

    public static boolean validation(String user, String password) {
        Properties properties = new Properties();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathProperties))) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (properties.getProperty("user").equals(user) && properties.getProperty("password").equals(password)) {
            return true;
        }
        return false;
    }
    public static void saveResourceWalletXML(Restaurant restaurant) {

        try {
            // Obtener la lista de pedidos del restaurant
            List<Order> pedidos = restaurant.getOrders();

            // Guardar solo los pedidos en XML
            ArchivoUtil.salvarRecursoSerializadoXML(pathOrderXML, pedidos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
