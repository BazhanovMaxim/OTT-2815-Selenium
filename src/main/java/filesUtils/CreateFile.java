package filesUtils;

import io.restassured.response.ResponseBody;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CreateFile {

    private DeleteFile deleteFile;

    // Проверка файла, если он создан, то удаляем и создаём новый
    public void checkFile(String text, String nameFile){
        deleteFile = new DeleteFile();
        File file = new File("target\\TestsFiles\\" + nameFile);
        if (file.exists() && file.isFile())
        {
            deleteFile.deleteFile(nameFile);
            createFile(text, nameFile);
        }
        createFile(text, nameFile);
    }

    // Создание файла
    private void createFile(String text, String nameFile){
        try {
            File file = new File("target\\TestsFiles\\" + nameFile);
            file.getParentFile().mkdirs();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("target\\TestsFiles\\" + nameFile, true), StandardCharsets.UTF_8));
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Запись в файл ответ запроса
    public void writeToFileResponse(ResponseBody responseBody, String nameFile){
        checkFile(responseBody.asString(), nameFile);
    }
}
