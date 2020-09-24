package fp;

import com.google.api.core.ApiFuture;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//firebase import
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Biblioteca {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        cloudFirestoreIn();
        //CapturaDatosService.capturarDatosAdministrador();
        //ConfiguracionBiliotecaService.modificarCantidadLibrosPrestamo(CapturaDatosService.capturaDeCantidadLibrosPrestamos());

    }

    private static void cloudFirestoreIn() throws InterruptedException, ExecutionException, IOException {

        //Credenciales
        InputStream serviceAccount = new FileInputStream("C:\\Users\\David\\Downloads\\base-de-datos-a789d-firebase-adminsdk-9u2xv-b9b8ba5993.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build();
        FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();

        //Agrega datos a la BD
        DocumentReference docRef = db.collection("users").document();
        // Add document data  with id "" using a hashmap
        Map<String, Object> data = new HashMap<>();
        data.put("first", "Ada");
        data.put("last", "Lovelace");
        data.put("born", 1815);
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);
        // ...
        // result.get() blocks on response
        System.out.println("Update time : " + result.get().getUpdateTime());

    }

}
