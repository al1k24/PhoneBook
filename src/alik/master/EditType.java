package alik.master;

public enum EditType {
    ET_NONE,

    ET_NAME,
    ET_SURNAME,
    ET_PHONE;

    public static void showInfo() {
        System.out.println("Выберите действие над пользователем:");

        showMessage(ET_NAME);
        showMessage(ET_SURNAME);
        showMessage(ET_PHONE);
        showMessage(ET_NONE);

        System.out.print("Мой выбор = ");
    }

    public static EditType getEditType(int id) {
        switch (id) {
            case 1: return ET_NAME;
            case 2: return ET_SURNAME;
            case 3: return ET_PHONE;
        }
        return ET_NONE;
    }

    private static void showMessage(EditType type) {
        switch (type) {
            case ET_NAME:
                System.out.println("1: Изменить имя"); break;
            case ET_SURNAME:
                System.out.println("2: Изменить фамилию"); break;
            case ET_PHONE:
                System.out.println("3: Изменить мобильный"); break;
            default:
                System.out.println("0: Выход"); break;
        }
    }
}
