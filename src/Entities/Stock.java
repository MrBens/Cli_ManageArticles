package Entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Stock {
    private ArrayList<Article> stock;

    public Stock(){
        this.stock = new ArrayList<>();
    }

    public void addToStock(Scanner scanner) {
        Article article = new Article();
        System.out.println("Entrez la reference l'article :");
        article.setReference(Integer.parseInt(scanner.nextLine()));
        System.out.println("Entrez le nom de l'article :");
        article.setName(scanner.nextLine().trim().toLowerCase());
        System.out.println("Entrez le prix de l'article :");
        article.setPrice(Float.parseFloat(scanner.nextLine()));


        if (this.stock.stream().noneMatch(x -> x.getReference() == article.getReference())){
            this.stock.add(article);
        }else{
            System.out.println("ERROR : This ref already exist");
            addToStock(scanner);
        }
    }

    public Article getByRef(Integer reference) {

        for (Article article : this.stock) {
            if (article.getReference() == reference){
                return article;
            }
        }
        return null;
    }

    public Article getByName(String name) {

        for (Article article : this.stock) {
            if (article.getName().equals(name)){
                return article;
            }
        }
        return null;
    }

    public void getByPriceInRange(float priceMin, float priceMax) {
        this.stock.stream().filter(x -> x.getPrice() < priceMax && x.getPrice() > priceMin).forEach(System.out::println);
    }

    public void deleteByRef(Integer reference) {
        if (this.stock.stream().anyMatch(x -> x.getReference() == reference)){
            this.stock.remove(this.stock.stream().filter(x -> x.getReference() == reference).findAny().get());
        }else{
            System.out.println("ERROR : Nothing to delete");
        }
    }

    public void editByRef(Scanner scanner, Integer reference) {
        String answer = "";

        if (this.stock.stream().anyMatch(x -> x.getReference() == reference)){
            Article article = this.stock.stream().filter(x -> x.getReference() == reference).findAny().get();

            System.out.println("Entrez le nouveau nom de l'article : (Enter to keep old value)");
            answer = scanner.nextLine();
            if (!answer.isEmpty()){
                article.setName(answer);
            }

            System.out.println("Entrez le nouveau prix de l'article : (Enter to keep old value)");
            answer = scanner.nextLine();
            if (!answer.isEmpty()){
                article.setPrice(Float.parseFloat(answer));
            }

        }else{
            System.out.println("ERROR : can't edit");
        }
    }

    public void getAllArticles() {
        if (this.stock.size() > 0){
            for (Article article : this.stock) {
                System.out.println(article.toString());
            }
        }else {
            System.out.println("Il n'y a aucun article pour le moment");
        }
    }


}
