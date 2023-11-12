import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class Menu {
    private ToyBox toybox;
    private ToysPrize prizelist;

    public Menu(ToyBox toybox, ToysPrize prizelist) {
        this.toybox = toybox;
        this.prizelist = prizelist;
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("""
                    1 - Посмотреть список игрушек в магазине
                    2 - Посмотреть список игрушек для розыграша
                    3 - Добавить игрушки в магазин
                    4 - Изменить "вес" игрушки
                    5 - Сформировать список игрушек для розыгрыша
                    6 - Выдать приз и сохранить результат в файл
                    7 - Опустошить призовую коробку
                    8 - Выход
                    """);
            int selection = scanner.nextInt();
            switch (selection){
                case 1:
                    System.out.println(toybox.toString());;
                    break;
                case 2:
                    System.out.println(prizelist.toString());
                    break;
                case 3:
                    toybox.addToy(new Toy());
                    break;
                case 4:
                    toybox.editFrequency();
                    break;
                case 5:
                    prizelist.makePrizelist(toybox);
                    break;
                case 6:
                    prizelist.get_Toy_to_Winner();
                    break;
                case 7:
                    prizelist.clean();
                    break;
                case 8:
                    System.exit(0);
                    break;

            }
        }

    }
}
