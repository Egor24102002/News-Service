INSERT INTO public.users (username, "password", "role", firstname, lastname, user_id)
VALUES ('egor.pantiuschov@yandex.ru', '123', 'ADMIN', 'Егор', 'Пантюшов', 1);
INSERT INTO public.users (username, "password", "role", firstname, lastname, user_id)
VALUES ('andrey.kitaev@yandex.ru', '123', 'USER', 'Андрей', 'Китаев', 3);
INSERT INTO public.users (username, "password", "role", firstname, lastname, user_id)
VALUES ('oleg.duhnov@tandex.ru', '123', 'USER', 'Олег', 'Духнов', 4);
INSERT INTO public.users (username, "password", "role", firstname, lastname, user_id)
VALUES ('egor.markin@yandex.ru', '123', 'USER', 'Егор', 'Маркин', 6);
INSERT INTO public.users (username, "password", "role", firstname, lastname, user_id)
VALUES ('denis.priroda@yandex.ru', '123', 'EDITOR', 'Денис', 'Природа', 5);
INSERT INTO public.users (username, "password", "role", firstname, lastname, user_id)
VALUES ('ivan.novikov@yandex.ru', '123456', 'EDITOR', 'Иван', 'Новиков', 2);

INSERT INTO public.articles (article_id, title, "content", author_id, category, date_of_create, status)
VALUES (7, 'Байден высказался о возможности ударов ВСУ по России', 'ВАШИНГТОН, 11 сен - РИА Новости. В США прорабатывается вопрос о том, чтобы разрешить Украине использовать дальнобойное оружие для ударов вглубь России, заявил американский президент Джо Байден.
«
"Мы работаем над этим прямо сейчас", — сказал он журналистам в ответ на соответствующий вопрос.
Во вторник госсекретарь США Энтони Блинкен допустил, что Вашингтон разрешит Киеву наносить удары по России американскими ракетами ATACMS.Западные СМИ ранее писали, что США могут разрешить Киеву удары вглубь России в ближайшее время. В американской администрации, согласно публикациям, есть те, кто занял такую позицию, теперь они стараются убедить Байдена.',
        1, 'Global', '2024-09-11 01:23:20.000', 'PUBLICATION');
INSERT INTO public.articles (article_id, title, "content", author_id, category, date_of_create, status)
VALUES (8, 'Мебельная фабрика на Кубани увеличила производство на четверть', 'КРАСНОДАР, 11 сен - РИА Новости. Мебельная фабрика из Белореченска в Краснодарском крае на 25% увеличила производство шкафов благодаря внедрению бережливых технологий в рамках нацпроекта "Производительность труда", сообщили в пресс-службе администрации региона.
«
"Компания "Е1-Юг" оптимизировала пилотный поток в рамках национального проекта "Производительность труда". Благодаря бережливым технологиям здесь на 25% сократили время производства шкафов и на 22% – количество запасов, на 25% увеличили выработку", - говорится в сообщении.
Уточняется, что компания специализируется на выпуске шкафов-купе, поставляет продукцию в крупные торговые сети России и за рубеж. Общая площадь производственных помещений в Белореченске составляет 30 тысяч квадратных метров. У компании 22 склада в регионах России.
По данным властей, вступить в нацпроект "Производительность труда" могут региональные предприятия базовых несырьевых отраслей экономики: обрабатывающее производство, сельское хозяйство, строительство, транспорт, торговля, а также организации туристической индустрии.',
        1, 'Other', '2024-09-11 01:23:56.000', 'PUBLICATION');
INSERT INTO public.articles (article_id, title, "content", author_id, category, date_of_create, status)
VALUES (9, 'Чехия-Украина', 'Сборная Чехии одолела национальную команду Украины в матче второго тура группового этапа Лиги наций.

Встреча состоялась на стадионе «Фортуна Арена» в Праге и завершилась с результатом 3:2.

Чехия открыла счет в матче: на 21-й минуте отличился Павел Шульц, ему ассистировал Вацлав Черны. Украина сравняла на 37-й минуте: гол оформил Владислав Ванат с передачи Николая Шапаренко. На второй компенсированной ко второму тайму минуте Шульц оформил дубль. На 80-й минуте чех Томаш Соучек реализовал пенальти, а через четыре минуты Георгий Судаков с передачи Виктора Цыганкова отыграл один мяч.

«Газета.Ru» провела текстовую онлайн-трансляцию поединка.

Сборные Чехии и Украины выступают в Лиге B в группе 1 вместе национальными командами Грузии и Албании. В первом туре чешские футболисты потерпели поражение от соперников из Грузии. Встреча завершилась со счетом 1:4. Украинская команда также проиграла, поединок с Албанией завершился со счетом 1:2.

В третьем туре группового этапа турнира сборная Чехии сразится с Албанией. Игра состоится 11 октября, стартовый свисток для футболистов прозвучит в 21:45 по московскому времени. Украина в этот же день проведет поединок против грузинских футболистов. Этот матч начнется также в 21:45 мск.',
        1, 'Sport', '2024-09-11 01:25:07.000', 'PUBLICATION');
INSERT INTO public.articles (article_id, title, "content", author_id, category, date_of_create, status)
VALUES (10, 'В Екатеринбурге утвердила место для установки памятника ', '"Перед киностудией установят памятник Алексею Балабанову", – написал Сергин на своей странице в "ВКонтакте" об итогах заседания комиссии.
Монумент появится перед зданием Свердловской киностудии, где в 1990-х Балабанов начинал свою карьеру, работая ассистентом режиссера. Ранее глава Екатеринбурга Алексей Орлов принял решение об открытии памятника Алексею Балабанову в столице Урала, предполагалось, что это будет приурочено к объявлению 2026 года годом уральского рока.Российский кинорежиссер, сценарист и продюсер Алексей Балабанов родился в 1959 году в Свердловске (ныне Екатеринбург). Балабанов известен по фильмам "Жмурки", "Мне не больно", "Груз 200" и культовой серии картин "Брат". Балабанов умер в 2013 году от острой сердечной недостаточности, ему было 54 года.',
        2, 'Culture', '2024-09-11 01:28:02.000', 'VERIFICATION');
INSERT INTO public.articles (article_id, title, "content", author_id, category, date_of_create, status)
VALUES (11, 'Яна Поплавская обвинила Лолиту ', 'Актриса Яна Поплавская осудила певицу Лолиту Милявскую за исполнение песни рэпера Алишера Моргенштерна* на одном из ее концертов. Об этом она написала в своем Telegram-канале.

В июле Лолита в ходе одного из своих выступлений в Санкт-Петербурге исполнила песню «Cadillac» Моргенштерна. Она подчеркнула, что теперь дети и подростки получают все тот же контент, но в другом исполнении.

Комментируя произошедшее, Поплавская задалась вопросом, знает ли Лолита, что Моргенштерн признан иноагентом, а она сама воспроизводит «иноагентские» тексты.

«Звучит сатанинский смех упырей, которые это творят, что стоят за спинами Лолиты, Моргенштерна и прочих, которые со сцены разрушают молодежь и наше будущее», – написала актриса.

Ранее в прокуратуре Москвы сообщили, что в отношении Алишера Моргенштерна завели уголовное дело за неисполнение обязанностей, предусмотренных законодательством РФ об иностранных агентах. В случае возвращения в Россию ему грозит до двух лет лишения свободы.',
        2, 'Culture', '2024-09-11 01:28:35.000', 'PUBLICATION');
INSERT INTO public.articles (article_id, title, "content", author_id, category, date_of_create, status)
VALUES (12, 'ВС РФ уничтожают сразу обе бригады «Азова»', 'На Торецком направлении в ДНР Вооруженные силы РФ уничтожают сразу обе бригады «Азова»*.

Данные некрологов, опубликованные в соцсетях, говорят о том, что под Торецком находится как 3-я отдельная штурмовая бригада ВСУ, так и 12-я бригада спецназначения Нацгвардии Украины. Эти не связанные друг с другом подразделения были основаны в 2023 году из «азовцев» и используют эмблему нацбата в виде руны «вольфсангель» (волчий крюк).

По данным портала TrackANaziMerc, который отслеживает потери украинской стороны, в составе 3-й штурмовой бригады под Торецком в сентябре были ликвидированы боевики с позывными «Шеврон», «Золтон», «Тед», «Брокi», «Скорпiон», «Лiнг», «Смайл». Речь идет только о тех потерях, информация о которых появилась в соцсетях.',
        5, 'War', '2024-09-11 01:30:10.000', 'PUBLICATION');

INSERT INTO public."comments" (comment_id, article_id, user_id, date_of_comment, "text", is_deleted)
VALUES (14, 8, 1, '2024-09-11 01:40:01.000', 'Удивительно,очень интересно', false);
INSERT INTO public."comments" (comment_id, article_id, user_id, date_of_comment, "text", is_deleted)
VALUES (15, 7, 1, '2024-09-11 01:40:17.000', 'Понятно.Но можете о чём нибудь другом писать?', false);
INSERT INTO public."comments" (comment_id, article_id, user_id, date_of_comment, "text", is_deleted)
VALUES (19, 11, 3, '2024-09-11 01:42:44.000', 'Классно', false);
INSERT INTO public."comments" (comment_id, article_id, user_id, date_of_comment, "text", is_deleted)
VALUES (21, 9, 3, '2024-09-11 01:43:11.000', 'Без Ярмоленко уже не то', false);
INSERT INTO public."comments" (comment_id, article_id, user_id, date_of_comment, "text", is_deleted)
VALUES (23, 9, 4, '2024-09-11 01:43:30.000', 'Ждём матч с Испанией', false);
INSERT INTO public."comments" (comment_id, article_id, user_id, date_of_comment, "text", is_deleted)
VALUES (25, 7, 4, '2024-09-11 01:43:39.000', 'Интересно', false);
INSERT INTO public."comments" (comment_id, article_id, user_id, date_of_comment, "text", is_deleted)
VALUES (31, 9, 6, '2024-09-11 01:44:44.000', 'Классный матч был', false);

INSERT INTO public.ansichtens (user_id, article_id, ansichten_id)
VALUES (1, 8, 1);
INSERT INTO public.ansichtens (user_id, article_id, ansichten_id)
VALUES (1, 7, 2);
INSERT INTO public.ansichtens (user_id, article_id, ansichten_id)
VALUES (3, 7, 3);
INSERT INTO public.ansichtens (user_id, article_id, ansichten_id)
VALUES (3, 12, 4);
INSERT INTO public.ansichtens (user_id, article_id, ansichten_id)
VALUES (3, 11, 5);
INSERT INTO public.ansichtens (user_id, article_id, ansichten_id)
VALUES (3, 9, 6);
INSERT INTO public.ansichtens (user_id, article_id, ansichten_id)
VALUES (4, 8, 7);
INSERT INTO public.ansichtens (user_id, article_id, ansichten_id)
VALUES (4, 9, 8);
INSERT INTO public.ansichtens (user_id, article_id, ansichten_id)
VALUES (4, 7, 9);
INSERT INTO public.ansichtens (user_id, article_id, ansichten_id)
VALUES (1, 9, 10);
INSERT INTO public.ansichtens (user_id, article_id, ansichten_id)
VALUES (6, 9, 11);

INSERT INTO public.evaluations_articles ("type", user_id, article_id, evaluation_article_id)
VALUES ('LIKE', 1, 8, 13);
INSERT INTO public.evaluations_articles ("type", user_id, article_id, evaluation_article_id)
VALUES ('DISLIKE', 1, 7, 17);
INSERT INTO public.evaluations_articles ("type", user_id, article_id, evaluation_article_id)
VALUES ('LIKE', 3, 12, 18);
INSERT INTO public.evaluations_articles ("type", user_id, article_id, evaluation_article_id)
VALUES ('DISLIKE', 3, 9, 20);
INSERT INTO public.evaluations_articles ("type", user_id, article_id, evaluation_article_id)
VALUES ('DISLIKE', 4, 9, 24);
INSERT INTO public.evaluations_articles ("type", user_id, article_id, evaluation_article_id)
VALUES ('LIKE', 1, 9, 27);

INSERT INTO public.evaluations_comments (evaluation_comment_id, "type", user_id, comment_id)
VALUES (16, 'LIKE', 1, 15);
INSERT INTO public.evaluations_comments (evaluation_comment_id, "type", user_id, comment_id)
VALUES (22, 'LIKE', 4, 21);
INSERT INTO public.evaluations_comments (evaluation_comment_id, "type", user_id, comment_id)
VALUES (26, 'LIKE', 4, 25);
INSERT INTO public.evaluations_comments (evaluation_comment_id, "type", user_id, comment_id)
VALUES (28, 'LIKE', 1, 21);
INSERT INTO public.evaluations_comments (evaluation_comment_id, "type", user_id, comment_id)
VALUES (30, 'DISLIKE', 6, 21);