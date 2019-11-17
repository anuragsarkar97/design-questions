package io.gojek.parkinglot.executor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileExecutor implements ExecutorInterface<String, BufferedReader> {

    public BufferedReader execute(String fileName) throws FileNotFoundException {
        BufferedReader bufferReader;
        try {
             bufferReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            //TODO:: Handle file not found exception
            throw e;
        }
        return bufferReader;

    }
}
