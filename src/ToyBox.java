import java.util.*;

public class ToyBox {
    private ArrayList<Toy> toy_list;

    public ToyBox(ArrayList<Toy> toy_list) {
        this.toy_list = toy_list;
    }

    public ToyBox() {
        this(new ArrayList<>());
    }

    public void addToy(Toy toy){
        boolean flag = true;
        for (Toy el:
             toy_list) {
            if (el.getName().equals(toy.getName())){
                el.setQuantity(toy.getQuantity());
                flag = false;
                break;
            }
        }
        if (flag) {
            toy_list.add(toy);
        }
    }

    public List<Toy> getToy_list() {
        return toy_list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Toy toy: toy_list){
            sb.append(toy.toString()).append("\n");
        }
        return sb.toString();
    }

    public void editFrequency() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите ID игрушки: ");
        int selectedId = scan.nextInt();
        if (selectedId >= 0 && selectedId < toy_list.size()) {
            System.out.println("Игрушка " + toy_list.get(selectedId).getName() +
                        " имеет следующую частоту побед " + toy_list.get(selectedId).getFrequency());
            System.out.print("Введите новый шанс выпадения: ");
            int newFrequency = scan.nextInt();
            toy_list.get(selectedId).setFrequency(newFrequency);
            System.out.println("Шанс выпадения был изменен.");
            } else {
                System.out.println("В призовом фонде нет ни одной игрушки с таким ID.");
            }
    }
}
