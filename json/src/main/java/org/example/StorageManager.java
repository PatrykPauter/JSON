import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class StorageManager {

    private static final String FILE_NAME = "profile.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void save(UserProfile profile) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(FILE_NAME), profile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserProfile load() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return null;

            return mapper.readValue(file, UserProfile.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}