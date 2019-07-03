CREATE SCHEMA IF NOT EXISTS products (
    id          BIGINT NOT NULL AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    price       DECIMAL(40) NULL,
    category    VARCHAR(100) NULL,
    discount    DECIMAL (40) NULL,
    description VARCHAR(100) NULL,
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
    )

    ENGINE = InnoDB
    AUTO_INCREMENT = 1002;