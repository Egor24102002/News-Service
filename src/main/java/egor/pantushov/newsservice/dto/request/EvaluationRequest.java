package egor.pantushov.newsservice.dto.request;

import egor.pantushov.newsservice.enums.Type;
import lombok.Value;

@Value
public class EvaluationRequest {
    Type type;
}
