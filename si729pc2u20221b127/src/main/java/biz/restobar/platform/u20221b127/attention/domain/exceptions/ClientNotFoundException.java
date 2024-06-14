package biz.restobar.platform.u20221b127.attention.domain.exceptions;

/**
 * This exception is thrown when a client is not found in the system.
 * @see RuntimeException
 * @author Salvador Salinas
 * @version 1.0
 */
public class ClientNotFoundException extends RuntimeException {
    /**
     * Constructor that receives a message to be shown when the exception is thrown.
     * @param id Id of the client that was not found.
     * */
    public ClientNotFoundException(Long id) {
        super("Client with id " + id + " was not found");
    }
}
