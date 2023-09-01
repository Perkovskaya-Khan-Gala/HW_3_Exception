public class NotOnlyCharactersException extends RuntimeException{
    public NotOnlyCharactersException(String infoName) {
        super(String.format("Поле <%s> может содержать только буквы. Попробуйте еще раз", infoName));
    }
}
