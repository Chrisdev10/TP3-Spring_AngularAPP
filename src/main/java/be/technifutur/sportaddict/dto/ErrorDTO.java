package be.technifutur.sportaddict.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    private String message;
    private HttpStatus status;
    private String uri;
    private HttpMethod method;
    private String classElement;
    private final Map<String, Object> infos = new HashMap<>();
}
