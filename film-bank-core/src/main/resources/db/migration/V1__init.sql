CREATE TABLE film
(
  id           BIGINT PRIMARY KEY NOT NULL,
  name         VARCHAR(255)       NOT NULL,
  release_date TIMESTAMP          NOT NULL,
  director_id  BIGINT    NOT NULL,
  genre_id     BIGINT    NOT NULL
);
CREATE TABLE actor
(
  id              BIGINT PRIMARY KEY NOT NULL,
  first_name      VARCHAR(255)       NOT NULL,
  second_name     VARCHAR(255)       NOT NULL,
  birthday        TIMESTAMP          NOT NULL
);

CREATE TABLE genre
(
  id              BIGINT PRIMARY KEY NOT NULL,
  genre_type      VARCHAR(20)
);
--
CREATE TABLE director
(
  id              BIGINT PRIMARY KEY NOT NULL,
  first_name      VARCHAR(255)       NOT NULL,
  second_name     VARCHAR(255)       NOT NULL
);

ALTER TABLE film
  ADD FOREIGN KEY (director_id) REFERENCES director (id);
ALTER TABLE film
  ADD FOREIGN KEY (genre_id) REFERENCES genre (id);

CREATE TABLE film_actor (
    film_id BIGINT NOT NULL,
    actor_id BIGINT NOT NULL,
    PRIMARY KEY (film_id, actor_id),
    CONSTRAINT FK_film FOREIGN KEY (film_id) REFERENCES film (id),
    CONSTRAINT FK_actor FOREIGN KEY (actor_id) REFERENCES actor (id)
);
