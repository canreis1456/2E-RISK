package sample;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
public class ResourceManager {
    public static void save(Serializable game, String name) throws Exception{
        try(ObjectOutputStream outSave = new ObjectOutputStream(Files.newOutputStream(Paths.get(name)))){
            outSave.writeObject(game);
        }
    }

    public static Object load(String game) throws Exception{
        try( ObjectInputStream inLoad = new ObjectInputStream(Files.newInputStream(Paths.get(game)))){
            return inLoad.readObject();
        }
    }
}
