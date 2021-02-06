package api;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;
import entity.Usuario;

import java.util.concurrent.ExecutionException;

public class CloudFirestoreDatabase extends DatabaseService {

    public Firestore db = FirestoreClient.getFirestore();

    Gson gson = new Gson();

    @Override
    public void saveUser(String json) {

        Usuario usuario = gson.fromJson(json, Usuario.class);

        System.out.println(usuario.getEmail());
        System.out.println(usuario.getApellido());

        DocumentReference docRef = db.collection("usersFinal").document(usuario.getEmail());

        docRef.set(usuario);

    }

    @Override
    public String getUser(String email) throws ExecutionException, InterruptedException {

        DocumentReference docRef = db.collection("usersFinal").document(email);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();

        return gson.toJson(document.getData());

    }

    @Override
    public void updateUser(String email) {

    }

    @Override
    public boolean validation(String emailJson) throws ExecutionException, InterruptedException {

        Usuario usuario = gson.fromJson(emailJson, Usuario.class);

        System.out.println(usuario.getEmail());

        DocumentReference docRef = db.collection("usersFinal").document(usuario.getEmail());
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();

        return document.exists();

    }
}
