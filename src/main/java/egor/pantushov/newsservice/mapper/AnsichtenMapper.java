package egor.pantushov.newsservice.mapper;

import egor.pantushov.newsservice.dto.response.AnsichtenResponse;
import egor.pantushov.newsservice.dto.response.EvaluationResponse;
import egor.pantushov.newsservice.entity.Ansichten;
import egor.pantushov.newsservice.entity.EvaluationArticle;
import egor.pantushov.newsservice.entity.EvaluationComment;
import egor.pantushov.newsservice.entity.Type;

import java.util.List;

public class AnsichtenMapper {
    public static AnsichtenResponse getAnsichtenResponseByArticle(List<Ansichten> ansichtens) {
                return new AnsichtenResponse(ansichtens.size());
    }

}
