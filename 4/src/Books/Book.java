package Books;

import java.io.*;

public class Book {
    private  static String path = "D://учеба//ОООП//lab4//Books.doc";    //путь к файлу

    private String name;
    private boolean hasIllustration;
    private int price;

    public Book() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "utf-8"));

        System.out.printf("\nВведите название: ");
        this.name = input.readLine();
        System.out.printf("Введите наличие иллюстраций. 1 - есть, 0 - нет: ");
        this.hasIllustration = Integer.parseInt(input.readLine()) == 1  ? true : false;   //тренарный оператор - это короткая запись if
        System.out.printf("Введите цену: ");
        this.price = Integer.parseInt(input.readLine());
    }

    //Getters
    public String getName() { //метод возвращает строку, которая установлена с помощью вызова setName
        return name;
    }

    public boolean hasIllustration() { //аналогично
        return hasIllustration;
    }

    public int getPrice() { //аналогично
        return price;
    }

    public void Input() throws IOException {        //Метод для записи в файл
        File f1 = new File(path);

        try {
            boolean file = f1.createNewFile();            //создание нового файла
            if(file) {
                System.out.printf("File created successfuly!");
            }
        } catch (IOException ex) {
            System.out.printf("Error!\n Mistake is" + ex.getMessage());   //если была ошибка при создании файла
        }

        FileWriter writer = new FileWriter(f1, true);              //объект для записи в файл

        writer.append("\nНазвание: '" + getName() + "';\nИллюстрации: " +
                hasIllustration() + ";\nЦена: " + getPrice() + ";\n");

        writer.flush();        //очистка буфера
        writer.close();        //закрытие файла
    }

    public static void Output() throws IOException {        //метод вывода из файла на консоль
        File f2 = new File(path);

        FileReader reader = new FileReader(f2);        //объект для чтения из файла
        char buf[];
        int num;
        buf = new char[1];

        do {
            num = reader.read(buf);       //чтение в буфер
            System.out.print(buf[0]);
        } while(num != -1);               //пока не закончится файл

        reader.close();
    }

    public static void priceSum(Book[] books) throws IOException {
        int sum = 0;

        for(int i = 0; i < books.length; i++) {
            sum += books[i].getPrice();
        }

        File f1 = new File(path);
        FileWriter writer = new FileWriter(f1, true);

        writer.append("\nОбщая цена: " + sum + "\n");

        writer.flush();
        writer.close();
    }

    public static void illustrationsCount(Book[] books) throws IOException{
        int ill = 0;

        for(int i = 0; i < books.length; i++) {
            if(books[i].hasIllustration()) {
                ill++;
            }
        }

        File f1 = new File(path);
        FileWriter writer = new FileWriter(f1, true);

        writer.append("\nКоличество иллюстраций: " + ill + "\n");

        writer.flush();
        writer.close();
    }
}
