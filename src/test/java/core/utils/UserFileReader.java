package core.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

public class UserFileReader extends JsonFileReader<List<UserFileReader.Account>> {

    private List<Account> accountList;

    @Override
    protected String getFilePath() {
        ConfigReader configReader = new ConfigReader();
        return configReader.getCredentialsPath();
    }

    @Override
    protected TypeReference<List<Account>> getTypeReference() {
        return new TypeReference<List<Account>>(){};
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Account {
        private String id;
        private String username;
        private String password;
    }

    public static Account getAccountById(String id) {
        return new UserFileReader().fromJsonFile().stream()
                .filter(account -> account.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
