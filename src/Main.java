import Entities.Article;
import Entities.Stock;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Stock stock = new Stock();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        selectOption(scanner, "menu");

    }

    public static void selectOption(Scanner scanner, String selectedOption){
        switch (selectedOption){
            case "menu", "m" -> showMenu(scanner);
            case "new", "n" -> {
                stock.addToStock(scanner);
                showMenu(scanner);
            }
            case "edit", "e" -> {
                stock.getAllArticles();
                System.out.println("Quel article souhaitez vous modifier ? (Entre la reference)");
                stock.editByRef(scanner, Integer.parseInt(scanner.nextLine()));
                showMenu(scanner);
            }
            case "all", "a" -> {
                stock.getAllArticles();
                showMenu(scanner);
            }
            case "searchname", "sn" ->{
                System.out.println("Entrez le nom recherché :");
                Article article = stock.getByName(scanner.nextLine().trim().toLowerCase());

                if (article != null){
                    System.out.println(article);
                }else{
                    System.out.println("Aucun article ne porte ce nom");
                }

                showMenu(scanner);
            }
            case "searchref", "sr" ->{
                System.out.println("Entrez la reference recherché :");
                Article article = stock.getByRef(Integer.parseInt(scanner.nextLine()));

                if (article != null){
                    System.out.println(article);
                }else{
                    System.out.println("Aucun article ne possede cette reference");
                }

                showMenu(scanner);
            }
            case "searchprice", "sp" ->{
                System.out.println("Entrez le prix min recherché :");
                float priceMin = Float.parseFloat(scanner.nextLine());
                System.out.println("Entrez le prix max recherché :");
                float priceMax = Float.parseFloat(scanner.nextLine());
                stock.getByPriceInRange(priceMin, priceMax);

                showMenu(scanner);
            }
            case "delete", "d" -> {
                stock.getAllArticles();
                System.out.println("\nQuel article souhaitez-vous supprimer ? (Entrez la reference)");
                stock.deleteByRef(Integer.parseInt(scanner.nextLine()));
                showMenu(scanner);
            }
            case "quit", "q" -> {
                return;
            }
        }
    }

    private static void showMenu(Scanner scanner) {
        String[] menuOptions = new String[]{
                "--> new (n)  : Add new article",
                "--> edit (e)  : Edit article",
                "--> all (a)  : Show all articles",
                "--> searchname (sn)  : Search article by name",
                "--> searchref (sr)  : Search article by ref",
                "--> searchprice (sp)  : Search article by range of price",
                "--> delete (d)  : Delete article",
                "--> quit (q) : Exit"
        };

        System.out.println("\n==========================");
        System.out.println("========== MENU ==========");
        System.out.println("==========================");

        Arrays.stream(menuOptions).toList().forEach(System.out::println);

        System.out.println("\nQue voulez-vous faire ?");
        selectOption(scanner, scanner.nextLine().trim().toLowerCase());
    }
}