public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String s) {
        super("This player is not registered!");
    }
}
