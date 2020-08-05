package com.posrocket.assesment;

import com.posrocket.assesment.exceptions.WrongFileTypeException;
import com.posrocket.assesment.model.Transaction;
import com.posrocket.assesment.services.parsing.IParsingService;
import com.posrocket.assesment.services.validation.IValidationService;
import com.posrocket.assesment.services.validation.ValidationService;
import com.posrocket.assesment.utils.ConfigurationUtil;
import com.posrocket.assesment.utils.FileUtil;

import java.lang.reflect.Constructor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(args));
        if (args.length != 1) {
            throw new RuntimeException("wrong number of args");
        }
        Path filePath = Paths.get(args[0]);
        String extension = FileUtil.getFileExtension(filePath);
        String parser = ConfigurationUtil.getConfig(extension);

        if (parser == null) {
            throw new WrongFileTypeException("this format is not supported");
        }

        Class<?> klass = Class.forName(parser);
        Constructor<?> constructor = klass.getConstructor();
        IParsingService parsingService = (IParsingService) constructor.newInstance();
        Transaction transaction = parsingService.parseFile(filePath);
        IValidationService validationService = new ValidationService();
        boolean result = validationService.validate(transaction);
        if (result) {
            System.out.println("transaction is valid");
        } else {
            System.out.println("transaction is not valid");
        }
    }
}
