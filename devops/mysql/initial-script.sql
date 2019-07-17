CREATE SCHEMA IF NOT EXISTS shoppinglist DEFAULT CHARACTER SET utf8 ;
create table IF not exists product(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    price       DECIMAL(40) NULL,
    category    VARCHAR(100) NULL,
    discount    DECIMAL (40) NULL,
    description VARCHAR(100) NULL,
    shoppingCart_id BIGINT NULL,
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
    )

    ENGINE = InnoDB
    AUTO_INCREMENT = 1002;

CREATE TABLE IF NOT EXISTS shoppingCarts (
                                     id BIGINT NOT NULL AUTO_INCREMENT,
                                     name VARCHAR(100) NOT NULL,
                                     description VARCHAR(100) NOT NULL,
                                     created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     PRIMARY KEY (id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1002;

ALTER TABLE product ADD CONSTRAINT shoppingCarts_product_fk FOREIGN KEY (shoppingCart_id) REFERENCES shoppingCarts(id);