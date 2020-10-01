package fp;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Administrador {

    private String nombre;
    private String apellido;
    private int edad;
    private String detalles;
    private String telefono;
    private String correo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo, Firestore db) {
        //Agrega datos a la BD
        this.correo = correo;
        DocumentReference docRef = db.collection("usuarios").document(correo);
        // Add document data  with id "" using a hashmap
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre, Firestore db) throws ExecutionException, InterruptedException {
        //Agrega datos a la BD
        DocumentReference docRef = db.collection("users").document(this.getCorreo());
        // Add document data  with id "" using a hashmap
        Map<String, Object> data = new HashMap<>();
        data.put("nombre", nombre);
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);
        // ...
        // result.get() blocks on response
        System.out.println("Update time : " + result.get().getUpdateTime());
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido, Firestore db) throws ExecutionException, InterruptedException {
        //Agrega datos a la BD
        DocumentReference docRef = db.collection("users").document(this.getCorreo());
        // Add document data  with id "" using a hashmap
        Map<String, Object> data = new HashMap<>();
        docRef.update("apellido", apellido);
        //asynchronously write data
        //ApiFuture<WriteResult> result = docRef.set(data);
        // ...
        // result.get() blocks on response
        //System.out.println("Update time : " + result.get().getUpdateTime());
        //Hola estoy escribiendo esto mientras estoy en clase para ver como responde la pc y parece que este IDE es más condescendiente con mi querida PC
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
