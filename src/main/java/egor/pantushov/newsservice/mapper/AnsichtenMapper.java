package egor.pantushov.newsservice.mapper;

import egor.pantushov.newsservice.dto.response.AnsichtenResponse;
import egor.pantushov.newsservice.entity.Ansichten;

import java.util.List;

public class AnsichtenMapper {
    public static AnsichtenResponse getAnsichtenResponseByArticle(List<Ansichten> ansichtens) {
        return new AnsichtenResponse(ansichtens.size());
    }

}
