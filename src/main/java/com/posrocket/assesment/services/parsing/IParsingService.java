package com.posrocket.assesment.services.parsing;

import com.posrocket.assesment.exceptions.WrongFileTypeException;
import com.posrocket.assesment.model.Transaction;

import java.nio.file.Path;

public interface IParsingService {
    Transaction parseFile(Path filePath) throws Exception;
    void validateFile(Path filePath) throws WrongFileTypeException;
}
