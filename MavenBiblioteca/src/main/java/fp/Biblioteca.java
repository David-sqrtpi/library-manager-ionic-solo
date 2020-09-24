package fp;

import java.io.IOException;

//firebase import
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.InputStream;

public class Biblioteca {

    public static void main(String[] args) throws IOException {

        cloudFirestoreConfig();
        //CapturaDatosService.capturarDatosAdministrador(db);
        //ConfiguracionBiliotecaService.modificarCantidadLibrosPrestamo(CapturaDatosService.capturaDeCantidadLibrosPrestamos());

    }

    private static void cloudFirestoreConfig() throws IOException {

        //Credenciales
        InputStream serviceAccount = new FileInputStream("C:\\Users\\David\\Downloads\\base-de-datos-a789d-firebase-adminsdk-9u2xv-b9b8ba5993.json");
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build();
        FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();

        CapturaDatosService.capturarDatosAdministrador(db);

    }

}
