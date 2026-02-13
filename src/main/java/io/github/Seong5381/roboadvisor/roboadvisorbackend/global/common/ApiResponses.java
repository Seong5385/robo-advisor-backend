package io.github.Seong5381.roboadvisor.roboadvisorbackend.global.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponses<T> {
    private boolean success;
    private T data;
    private String error;

    public static <T> ApiResponses<T> success(T data) {
        return new ApiResponses<>(true, data, null);
    }

    public static <T> ApiResponses<T> success(T data, String error) {
        return new ApiResponses<>(false, null, error);
    }
}
