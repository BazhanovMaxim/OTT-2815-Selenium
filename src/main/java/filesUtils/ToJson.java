package filesUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class ToJson {

    public void serialize(HashMap<String, String> mapToJson, String nameFile){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String test = gson.toJson(mapToJson);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("target\\TestsFiles\\" + nameFile, true), StandardCharsets.UTF_8));
            writer.write(test);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
