package api;

import java.util.concurrent.ExecutionException;

public abstract class DatabaseService {

    public abstract void saveUser(String json);

    public abstract String getUser(String json) throws ExecutionException, InterruptedException;

    public abstract void updateUser(String email);

    public abstract boolean validation(String emailJson) throws ExecutionException, InterruptedException;


}
