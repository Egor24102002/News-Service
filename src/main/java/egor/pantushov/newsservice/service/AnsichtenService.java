package egor.pantushov.newsservice.service;

import egor.pantushov.newsservice.dto.response.AnsichtenResponse;
import egor.pantushov.newsservice.dto.response.ArticleResponse;

import java.security.Principal;

public interface AnsichtenService {
    ArticleResponse addAnsichten(Long articleId, Principal principal);
}
