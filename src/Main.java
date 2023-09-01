import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        //System.out.println(getInfo());
        createFileInfo(getInfo());
    }

    public static List<Human> getInfo() {
        Scanner scanner = new Scanner(System.in);
        List<Human> hm = new ArrayList<>();
        while (true) {
            System.out.println("Введите данные через пробел(0-выход) - Фамилия Имя Отчество Телефон:");
            try {
                String info = scanner.nextLine();
                if (info.equals("0")) break;

                String[] arrInfo = info.split(" ");
                if (arrInfo.length != 4) throw new NotFullInfoException();

                String s = "";
                if (!isOnlyCharacters(arrInfo[0])) s += " Фамилия ";
                if (!isOnlyCharacters(arrInfo[1])) s += " Имя ";
                if (!isOnlyCharacters(arrInfo[2])) s += " Отчество ";
                if (s != "") throw new NotOnlyCharactersException(s);

                long phoneNumber = Long.parseLong(arrInfo[3].trim());

                hm.add(new Human(arrInfo[0], arrInfo[1], arrInfo[2], phoneNumber));
            } catch (NotFullInfoException | NotOnlyCharactersException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Введен неверный формат телефона. Попробуйте еще раз.");
            } catch (Exception e) {
                System.out.println("Что-то пошло не так. Попробуйте еще раз.");
            }
        }
        return hm;
    }

    private static boolean isOnlyCharacters(String str) {
        return str.matches("^[a-zA-Zа-яА-Я]*$");
    }

    public static void createFileInfo(List<Human> humans) {
        if (!humans.isEmpty()) {
            for (Human hm : humans
            ) {
                try (FileWriter wr = new FileWriter(new File(hm.getSurname() + ".txt"), true)) {
                    wr.append(String.format("<%s> <%s> <%s> <%s>", hm.getSurname(), hm.getName(), hm.getPatronymic(), hm.getPhoneNumber()));
                    wr.append('\n');
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }


}