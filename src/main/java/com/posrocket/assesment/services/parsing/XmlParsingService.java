package com.posrocket.assesment.services.parsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.posrocket.assesment.Constants;
import com.posrocket.assesment.exceptions.WrongFileTypeException;
import com.posrocket.assesment.model.Transaction;
import com.posrocket.assesment.utils.FileUtil;

import java.nio.file.Files;
import java.nio.file.Path;

public class XmlParsingService implements IParsingService {
    private final ObjectMapper mapper;

    public XmlParsingService() {
        mapper = new XmlMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

    }

    @Override
    public Transaction parseFile(Path filePath) throws Exception {
        validateFile(filePath);
        return mapper.readValue(Files.newBufferedReader(filePath), Transaction.class);
    }

    @Override
    public void validateFile(Path filePath) throws WrongFileTypeException {
        String extension = FileUtil.getFileExtension(filePath);
        if (!Constants.Extensions.XML.equals(extension)) {
            throw new WrongFileTypeException(
                    String.format("%s file extension %s doesn't match service extension %s", XmlParsingService.class, extension, Constants.Extensions.XML)
            );
        }
    }
}
