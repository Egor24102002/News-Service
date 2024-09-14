CREATE TABLE public.users
(
    username   varchar(64) NOT NULL,
    "password" varchar(64) NOT NULL,
    "role"     varchar(32) NOT NULL,
    firstname  varchar(64) NOT NULL,
    lastname   varchar(64) NOT NULL,
    user_id    serial4     NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (user_id)
);



CREATE TABLE public.articles
(
    article_id     int4 DEFAULT nextval('users_user_id_seq'::regclass) NOT NULL,
    title          varchar(64)                                         NOT NULL,
    "content"      varchar                                             NOT NULL,
    author_id      int4                                                NOT NULL,
    category       varchar(32)                                         NOT NULL,
    date_of_create timestamp(0)                                        NOT NULL,
    status         varchar(32)                                         NOT NULL,
    CONSTRAINT article_pk PRIMARY KEY (article_id),
    CONSTRAINT article_users_fk FOREIGN KEY (author_id) REFERENCES public.users (user_id)
);



CREATE TABLE public."comments"
(
    comment_id      int4 DEFAULT nextval('users_user_id_seq'::regclass) NOT NULL,
    article_id      int4                                                NOT NULL,
    user_id         int4                                                NOT NULL,
    date_of_comment timestamp(0)                                        NOT NULL,
    "text"          varchar(255)                                        NOT NULL,
    is_deleted      bool DEFAULT false                                  NOT NULL,
    CONSTRAINT comment_pk PRIMARY KEY (comment_id),
    CONSTRAINT comment_article_fk FOREIGN KEY (article_id) REFERENCES public.articles (article_id)
);



CREATE TABLE public.evaluations_articles
(
    "type"                varchar(32)                                         NOT NULL,
    user_id               int4                                                NOT NULL,
    article_id            int4                                                NOT NULL,
    evaluation_article_id int4 DEFAULT nextval('users_user_id_seq'::regclass) NOT NULL,
    CONSTRAINT evaluations_articles_pk PRIMARY KEY (evaluation_article_id),
    CONSTRAINT evaluation_article_id_articles_fk FOREIGN KEY (article_id) REFERENCES public.articles (article_id),
    CONSTRAINT evaluation_article_id_users_fk FOREIGN KEY (user_id) REFERENCES public.users (user_id)
);



CREATE TABLE public.evaluations_comments
(
    evaluation_comment_id int4 DEFAULT nextval('users_user_id_seq'::regclass) NOT NULL,
    "type"                varchar(32)                                         NOT NULL,
    user_id               int4                                                NOT NULL,
    comment_id            int4                                                NOT NULL,
    CONSTRAINT evaluations_pk PRIMARY KEY (evaluation_comment_id),
    CONSTRAINT evaluations_comments_comments_fk FOREIGN KEY (comment_id) REFERENCES public."comments" (comment_id),
    CONSTRAINT evaluations_comments_users_fk FOREIGN KEY (user_id) REFERENCES public.users (user_id)
);



CREATE TABLE public.ansichtens
(
    user_id      int4    NOT NULL,
    article_id   int4    NOT NULL,
    ansichten_id serial4 NOT NULL,
    CONSTRAINT ansichtens_pk PRIMARY KEY (ansichten_id),
    CONSTRAINT ansichtens_articles_fk FOREIGN KEY (article_id) REFERENCES public.articles (article_id),
    CONSTRAINT ansichtens_users_fk FOREIGN KEY (user_id) REFERENCES public.users (user_id)
);