import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        // использована перевернутая очередь
        PriorityQueue<Toy> toyPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        List<Toy> prizeList = new ArrayList<>();
        FileCreate fileCreate = new FileCreate();
        try {
            input(toyPriorityQueue); // создать призовые игрушки и добавить в коллекцию
            addPrizeList(prizeList, toyPriorityQueue); // добавить в список
            System.out.println(prizeList);

            fileCreate.createFile(prizeList); // добавить игрушки в файл в порядке их выпадения

            finishMethod(prizeList);
        }catch (Exception e){
            System.out.println("Список игрушек не удалось заполнить.");
        }
    }
    public static PriorityQueue input(PriorityQueue<Toy> toyPriorityQueue){
        try {
            Boolean flag = true;
            Scanner scanner = new Scanner(System.in);
            while (flag) {
                System.out.println("Введите id игрушки: ");
                String id = scanner.nextLine();

                System.out.println("Введите название игрушки: ");
                String name = scanner.nextLine();

                System.out.println("Введите количество данных игрушек: ");
                String count = scanner.nextLine();

                System.out.println("Введите частоту выподения: ");
                String frequency = scanner.nextLine();

                toyPriorityQueue.add(
                        new Toy(Integer.parseInt(id), name, Integer.parseInt(count), Integer.parseInt(frequency)));

                System.out.println("Добавить еще? Если хотите завершить работу, введите - n");
                String action = scanner.nextLine();

                if (action.equals("n")) {
                    flag = false;
                    System.out.println("Игрушки добавлены!\n");
                    return toyPriorityQueue;
                }
            }
            System.out.println("Игрушки добавлены!\n");
            return toyPriorityQueue;
        }catch (Exception E) {
            System.out.println("Введите id, частоту выпадения и количество в цифровом фортате.");
            return null;
        }
    }
    public static void addPrizeList(List<Toy> prizeList, PriorityQueue<Toy> toyPriorityQueue){
        for (int i = 0; i <= toyPriorityQueue.size() + 1; i++) {
            prizeList.add(toyPriorityQueue.remove());
        }

    }
    public static Toy getPrizeToy(List<Toy> toyList){
        Toy prizeToy = toyList.get(0);
        toyList.remove(prizeToy);
        return prizeToy;
    }
    public static void finishMethod(List prizeList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Получить призовую игрушку? (y/n)");
        String action = scanner.nextLine();
        if (action.equals("y")){
            Boolean flag = true;
            while (flag){
                System.out.println("Призовая игрушка: ");
                System.out.println(getPrizeToy(prizeList));
                System.out.println("Получить еще призовую игрушку? (y/n)");
                String getPrize = scanner.nextLine();
                if (getPrize.equals("n")){
                    System.out.println("Finish");
                    flag = false;
                }
            }
        }else System.out.println("Finish");
    }
}