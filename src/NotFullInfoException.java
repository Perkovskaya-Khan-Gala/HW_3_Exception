public class NotFullInfoException extends RuntimeException {
    public NotFullInfoException() {
        super("Введены не все данные или не соблюдены пробелы. Попробуйте еще раз.");
    }
}
