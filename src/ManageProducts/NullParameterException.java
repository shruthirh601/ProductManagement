package ManageProducts;

public class NullParameterException extends Exception {
    public NullParameterException(String message) {
        super(message);
    }
}

class EmptyListException extends Exception {
    public EmptyListException(String message) {
        super(message);
    }
}

class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}