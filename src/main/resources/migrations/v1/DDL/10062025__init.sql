CREATE TABLE new_entity
(
    id           BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title        VARCHAR(255),
    description  TEXT,
    url          VARCHAR(512),
    published_at VARCHAR(255)
);