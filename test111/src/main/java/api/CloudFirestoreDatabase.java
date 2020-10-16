package api;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class CloudFirestoreDatabase implements Database{

    public Firestore db = FirestoreClient.getFirestore();

    Gson gson = new Gson();

    public void saveUser(String json) {

        DocumentReference docRef = db.collection("usersFinal").document();

        Map<String, Object> data = new HashMap<>();

        data = (Map<String, Object>) gson.fromJson(json, data.getClass());

        docRef.set(data);
        
    }

    public String getUser(String email) throws ExecutionException, InterruptedException {

        DocumentReference docRef = db.collection("usersFinal").document(email);

        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();

        String test = gson.toJson(document.getData());

        return test;

    }

    public void updateUser(String email) {



    }

    public void test(String json){

        DocumentReference docRef = db.collection("usersFinal").document();

        Map<String, Object> data = new HashMap<>();

        data = (Map<String, Object>) gson.fromJson(json, data.getClass());

        docRef.set(data);

    }

    public String getId(Map data){

        return data.toString();

    }

}
