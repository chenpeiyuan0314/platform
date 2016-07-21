-- -----------------------------------------------------
-- Schema station
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `station` ;

-- -----------------------------------------------------
-- Schema station
-- -----------------------------------------------------
CREATE SCHEMA `station` DEFAULT CHARACTER SET utf8 ;
USE `station` ;

-- -----------------------------------------------------
-- Table `client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `client` ;

CREATE TABLE `client` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) NULL,
  `password` CHAR(41) NOT NULL,
  `phone` CHAR(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `token` ;

CREATE TABLE `token` (
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
