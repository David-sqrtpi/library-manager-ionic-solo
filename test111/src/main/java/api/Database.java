package api;

import java.util.concurrent.ExecutionException;

public interface Database {

    void saveUser(String json);

    String getUser(String email) throws ExecutionException, InterruptedException;

    void updateUser(String email);

    void test(String json);

}
