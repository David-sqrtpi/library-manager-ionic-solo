package api;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.*;

@ApplicationPath("/api")
public class config extends Application {

    public config() throws IOException {

        try{
            FileInputStream serviceAccount =
                    new FileInputStream("C:\\Users\\David\\Downloads\\base-de-datos-a789d-firebase-adminsdk-9u2xv-b9b8ba5993.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://base-de-datos-a789d.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        }
        catch (Exception e){

            System.out.println("continue");

        }



    }

}
