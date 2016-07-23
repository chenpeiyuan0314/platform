-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `station` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `station` DEFAULT CHARACTER SET utf8 ;
USE `station` ;

-- -----------------------------------------------------
-- Table `client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `client` ;

CREATE TABLE IF NOT EXISTS `client` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) NULL,
  `password` CHAR(40) NOT NULL,
  `phone` CHAR(11) NOT NULL,
  `create_date` VARCHAR(23) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `token` ;

CREATE TABLE IF NOT EXISTS `token` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `client_id` INT UNSIGNED NOT NULL,
  `code` CHAR(32) NOT NULL,
  `create_date` VARCHAR(23) NOT NULL,
  `abade_date` VARCHAR(23) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_token_client_idx` (`client_id` ASC),
  CONSTRAINT `fk_token_client`
    FOREIGN KEY (`client_id`)
    REFERENCES `client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `genre`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genre` ;

CREATE TABLE IF NOT EXISTS `genre` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `genre_id` INT UNSIGNED NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_genre_genre1_idx` (`genre_id` ASC),
  CONSTRAINT `fk_genre_genre1`
    FOREIGN KEY (`genre_id`)
    REFERENCES `genre` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product` ;

CREATE TABLE IF NOT EXISTS `product` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `genre_id` INT UNSIGNED NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `price` INT UNSIGNED NOT NULL,
  `detail` TEXT NOT NULL,
  `create_date` CHAR(23) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_genre1_idx` (`genre_id` ASC),
  CONSTRAINT `fk_product_genre1`
    FOREIGN KEY (`genre_id`)
    REFERENCES `genre` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;