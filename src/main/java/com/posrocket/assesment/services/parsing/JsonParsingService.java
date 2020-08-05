package com.posrocket.assesment.services.parsing;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import com.posrocket.assesment.Constants;
import com.posrocket.assesment.exceptions.WrongFileTypeException;
import com.posrocket.assesment.model.Transaction;
import com.posrocket.assesment.utils.FileUtil;

import java.nio.file.Files;
import java.nio.file.Path;

public class JsonParsingService implements IParsingService {
    private final Gson gson;

    public JsonParsingService() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Override
    public Transaction parseFile(Path filePath) throws Exception {
        validateFile(filePath);
        return gson.fromJson(Files.newBufferedReader(filePath), Transaction.class);
    }

    @Override
    public void validateFile(Path filePath) throws WrongFileTypeException {
        String extension = FileUtil.getFileExtension(filePath);
        if (!Constants.Extensions.JSON.equals(extension)) {
            throw new WrongFileTypeException(
                    String.format("%s file extension %s doesn't match service extension %s", JsonParsingService.class, extension, Constants.Extensions.JSON)
            );
        }
    }
}
