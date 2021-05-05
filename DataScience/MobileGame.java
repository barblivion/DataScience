/*
colunas: rank (int), title (String), totalRatings (int), installs (String), averageRating (double), growth30Days (double), growth60Days (double), price (double), category (String), starRatings5 (int), starRatings4 (int), starRatings3 (int), starRatings2 (int), starRatings1 (int), paid (String)
local do arquivo: "./archive/android-games.csv"
separador: ","
objetivo: fazer um programa que pegue os 100 jogos mais populares, visualize suas categorias e as compare para ver quais as categorias mais populares
item a ser considerado: número de avaliações
maior número de avaliação vai pro início da array
*/

import java.io.*;
import java.util.*;

class MobileGame {
    // declaração de atributos
    private String title, category, paid, installs;
    private int rank, totalRatings, starRatings5, starRatings4, starRatings3, starRatings2, starRatings1;
    private double averageRating, growth30Days, growth60Days, price;

    // construtor default
    public MobileGame() {
        this.setTitle("");
        this.setCategory("");
        this.setPaid("");
        this.setInstalls("");
        this.setRank(0);
        this.setTotalRatings(0);
        this.setStarRatings5(0);
        this.setStarRatings4(0);
        this.setStarRatings3(0);
        this.setStarRatings2(0);
        this.setStarRatings1(0);
        this.setAverageRating(0.0);
        this.setGrowth30Days(0.0);
        this.setGrowth60Days(0.0);
        this.setPrice(0.0);
    }

    // construtor parâmetrizado
    public MobileGame(
    String title, 
    String category,
    String paid,
    String installs,
    int rank,
    int totalRatings,
    int starRatings5,
    int starRatings4,
    int starRatings3,
    int starRatings2,
    int starRatings1,
    double averageRating,
    double growth30Days,
    double growth60Days,
    double price) {
        this.title = title;
        this.category = category;
        this.paid = paid;
        this.installs = installs;
        this.rank = rank;
        this.totalRatings = totalRatings;
        this.starRatings5 = starRatings5;
        this.starRatings4 = starRatings4;
        this.starRatings3 = starRatings3;
        this.starRatings2 = starRatings2;
        this.starRatings1 = starRatings1;
        this.averageRating = averageRating;
        this.growth30Days = growth30Days;
        this.growth60Days = growth60Days;
        this.price = price;
    }

    // gets
    public String getTitle() {
        return this.title;
    }
    public String getCategory() {
        return this.category;
    }
    public String getPaid() {
        return this.paid;
    }
    public String getInstalls() {
        return this.installs;
    }
    public int getRank() {
        return this.rank;
    }
    public int getTotalRatings() {
        return this.totalRatings;
    }
    public int getStarRatings5() {
        return this.starRatings5;
    }
    public int getStarRatings4() {
        return this.starRatings4;
    }
    public int getStarRatings3() {
        return this.starRatings3;
    }
    public int getStarRatings2() {
        return this.starRatings2;
    }
    public int getStarRatings1() {
        return this.starRatings1;
    }
    public double getAverageRating() {
        return this.averageRating;
    }
    public double getGrowth30Days() {
        return this.growth30Days;
    }
    public double getGrowth60Days() {
        return this.growth60Days;
    }
    public double getPrice() {
        return this.price;
    }

    // sets
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPaid(String paid) {
        this.paid = paid;
    }
    public void setInstalls(String installs) {
        this.installs = installs;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }
    public void setStarRatings5(int starRatings5) {
        this.starRatings5 = starRatings5;
    }
    public void setStarRatings4(int starRatings4) {
        this.starRatings4 = starRatings4;
    }
    public void setStarRatings3(int starRatings3) {
        this.starRatings3 = starRatings3;
    }
    public void setStarRatings2(int starRatings2) {
        this.starRatings2 = starRatings2;
    }
    public void setStarRatings1(int starRatings1) {
        this.starRatings1 = starRatings1;
    }
    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
    public void setGrowth30Days(double growth30Days) {
        this.growth30Days = growth30Days;
    }
    public void setGrowth60Days(double growth60Days) {
        this.growth60Days = growth60Days;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    // main
    public static void main (String [] args) throws FileNotFoundException {
        File arquivoCSV = new File("./archive/android-games.csv");
        ArrayList<MobileGame> listaGames = new ArrayList<>();
        ArrayList<MobileGame> topPopulares = new ArrayList<>();

        try {
            Scanner entradaArquivo = new Scanner(arquivoCSV);
            String linhasArquivo = new String();
            entradaArquivo.nextLine();

            while(entradaArquivo.hasNext()) {
                linhasArquivo = entradaArquivo.nextLine();
                String[] valoresEntreVirgula = linhasArquivo.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                MobileGame games = new MobileGame();
                games.setRank(Integer.parseInt(valoresEntreVirgula[0]));
                games.setTitle(valoresEntreVirgula[1]);
                games.setTotalRatings(Integer.parseInt(valoresEntreVirgula[2]));
                games.setInstalls((valoresEntreVirgula[3]));
                games.setAverageRating(Double.parseDouble(valoresEntreVirgula[4]));
                games.setGrowth30Days(Double.parseDouble(valoresEntreVirgula[5]));
                games.setGrowth60Days(Double.parseDouble(valoresEntreVirgula[6]));
                games.setPrice(Double.parseDouble(valoresEntreVirgula[7]));
                games.setCategory(valoresEntreVirgula[8]);
                games.setStarRatings5(Integer.parseInt(valoresEntreVirgula[9]));
                games.setStarRatings4(Integer.parseInt(valoresEntreVirgula[10]));
                games.setStarRatings3(Integer.parseInt(valoresEntreVirgula[11]));
                games.setStarRatings2(Integer.parseInt(valoresEntreVirgula[12]));
                games.setStarRatings1(Integer.parseInt(valoresEntreVirgula[13]));
                games.setPaid(valoresEntreVirgula[14]);

                listaGames.add(games);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        // adiciona jogos da ArrayList listaGames em topPopulares
        for(int i = 0; i < listaGames.size(); i++) {
            topPopulares.add(listaGames.get(i));
        }

        // ordena eles de acordo com a popularidade (totalRatings)
        int s, p;
        ArrayList<MobileGame> tmp = new ArrayList<MobileGame>(topPopulares);
        for(s = 1; s < topPopulares.size(); s++) {
            tmp.set(s, topPopulares.get(s));
            for(p = s - 1; p >= 0 && tmp.get(s).getTotalRatings() > topPopulares.get(p).getTotalRatings(); p--) {
                topPopulares.set(p + 1, topPopulares.get(p));
            }
            topPopulares.set(p + 1, tmp.get(s));
        }

        // mostra na tela o top 100 jogos
        int x = 1,
        gameAction = 0,
        gameStrategy = 0,
        gameArcade = 0,
        gameCasual = 0,
        gameAdventure = 0,
        gameSports = 0,
        gameRacing = 0,
        gameSimulation = 0,
        gameTrivia = 0,
        gameBoard = 0,
        gamePuzzle = 0;

        // cria arquivo .csv
        FileOutputStream fos = new FileOutputStream("top_jogos.csv", true);
        PrintWriter pw = new PrintWriter(fos);
        
        // escreve no arquivo
        pw.println("Name, Category");

        for(int i = 0; i < 100; i++) {
            // escreve informações dos jogos no arquivo
            pw.println(topPopulares.get(i).getTitle() + ", " + topPopulares.get(i).getCategory());

            // mostra título, categoria e quantidade de avaliações
            System.out.println(
                x + ". " + topPopulares.get(i).getTitle() + " (" + topPopulares.get(i).getCategory() + ")" + " (" + topPopulares.get(i).getTotalRatings() + ")"
            );
            x++;

            // soma quantidade de jogos em determinada categoria no top 100
            if(topPopulares.get(i).getCategory().equals("GAME ACTION")) {
                gameAction++;
            } else if(topPopulares.get(i).getCategory().equals("GAME STRATEGY")) {
                gameStrategy++;
            } else if(topPopulares.get(i).getCategory().equals("GAME ARCADE")) {
                gameArcade++;
            } else if(topPopulares.get(i).getCategory().equals("GAME CASUAL")) {
                gameCasual++;
            } else if(topPopulares.get(i).getCategory().equals("GAME ADVENTURE")) {
                gameAdventure++;
            } else if(topPopulares.get(i).getCategory().equals("GAME SPORTS")) {
                gameSports++;
            } else if(topPopulares.get(i).getCategory().equals("GAME RACING")) {
                gameRacing++;
            } else if(topPopulares.get(i).getCategory().equals("GAME SIMULATION")) {
                gameSimulation++;
            } else if(topPopulares.get(i).getCategory().equals("GAME TRIVIA")) {
                gameTrivia++;
            } else if(topPopulares.get(i).getCategory().equals("GAME BOARD")) {
                gameBoard++;
            } else if(topPopulares.get(i).getCategory().equals("GAME PUZZLE")) {
                gamePuzzle++;
            }
        }

        // mostra na tela quantos jogos de cada categoria estão na lista
        System.out.println("\n" + 
            "GAME ACTION: " + gameAction + "\n" +
            "GAME STRATEGY: " + gameStrategy + "\n" +
            "GAME ARCADE: " + gameArcade + "\n" +
            "GAME CASUAL: " + gameCasual + "\n" +
            "GAME ADVENTURE: " + gameAdventure + "\n" +
            "GAME SPORTS: " + gameSports + "\n" +
            "GAME RACING: " + gameRacing + "\n" +
            "GAME SIMULATION: " + gameSimulation + "\n" +
            "GAME TRIVIA: " + gameTrivia + "\n" +
            "GAME BOARD: " + gameBoard + "\n" +
            "GAME PUZZLE: " + gamePuzzle
        );

        // fecha o arquivo
        pw.close();
        System.out.println("Arquivo .csv criado com sucesso.");
    }
}