package core.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class JsonFileReader<T> {
    protected abstract String getFilePath();
    protected abstract TypeReference<T> getTypeReference();

    private String readFileContent()  throws IOException {
        return Files.readString(Paths.get(getFilePath()));
    }

    protected T parseFileContent() throws IOException {
        return new ObjectMapper().readValue(readFileContent(), getTypeReference());
    }

    protected T fromJsonFile() {
        try {
            return parseFileContent();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read file");
        }
    }
}
