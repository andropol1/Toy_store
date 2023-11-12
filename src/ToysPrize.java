import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.System.in;

public class ToysPrize {
    private ArrayList<Toy> prizelist;

    public ToysPrize(ArrayList<Toy> prizelist) {
        this.prizelist = prizelist;
    }

    public ToysPrize(){
        this(new ArrayList<>());
    }

    public ArrayList<Toy> makePrizelist(ToyBox toybox) throws IOException {
        int sum_frequency = 0;
        for (Toy toy:
             toybox.getToy_list()) {
            sum_frequency += toy.getFrequency() * toy.getQuantity();
        }
        Random random = new Random();
        int selection = getPrizeQuantity();
        for (int i = 0; i < selection; i++) {
            int randomNumber = random.nextInt(sum_frequency) + 1;
            int stepOfList = 0;
            for (Toy toy:
                    toybox.getToy_list()) {
                stepOfList += toy.getFrequency();
                if (stepOfList >= randomNumber){
                    if (toy.getQuantity() > 0){
                        prizelist.add(toy);
                        toy.setQuantity(toy.getQuantity() - 1);
                        sum_frequency -= toy.getFrequency();
                    }
                    break;
                }
            }
        }
        return prizelist;

    }

    public int getPrizeQuantity() throws IOException {
        System.out.println("Сколько игрушек возьмем на розыгрыш?");
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        return Integer.parseInt(bf.readLine());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Toy toy: prizelist){
            sb.append(toy.toStringFile()).append("\n");
        }
        return sb.toString();
    }

    public void get_Toy_to_Winner() {
        Toy winnerToy = prizelist.get(0);
        prizelist.remove(0);
        saveResult(winnerToy.toStringFile());
    }

    public void clean(){
        this.prizelist = new ArrayList<>();
    }

    private void saveResult(String text) {
        File file = new File("Result.txt");
        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }
        try (FileWriter fw = new FileWriter("Result.txt", true)) {
            fw.write(text + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
