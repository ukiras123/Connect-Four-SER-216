
package connect.four.board;


@SuppressWarnings("serial")
public class ColumnFullException extends IndexOutOfBoundsException {
    public ColumnFullException(String message) {
	super(message);
    }
    public ColumnFullException() {
	super("Played in a full column.");
    }
}
