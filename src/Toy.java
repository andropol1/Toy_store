import java.util.UUID;

public class Toy {
    private final UUID id;
    private final String name;
    private int frequency;
    private int quantity;

    public Toy() {
        this.id = UUID.randomUUID();
        this.name = KeyScanner.getText("Название игрушки: ");
        this.frequency = Integer.parseInt(KeyScanner.getText("вес в выдаче %: "));
        this.quantity = Integer.parseInt(KeyScanner.getText("количество: "));
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setFrequency(int frequency){
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public String toStringFile() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", frequency=" + frequency +
                '}';
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", frequency=" + frequency +
                ", quantity=" + quantity +
                '}';
    }
}
