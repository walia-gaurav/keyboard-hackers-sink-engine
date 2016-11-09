/* Drop any previous instances of the database */
DROP DATABASE sink_engine;

/* Creates a fresh database */
CREATE DATABASE sink_engine;

/* Switching to the newly created database. */
USE sink_engine;

/* Creating the DEVICE table */
CREATE TABLE `sink_engine`.`Device` (
  `idDevice` VARCHAR(64) NOT NULL ,
  `installationDate` DATETIME NOT NULL,
  `deleteDate` DATETIME NULL,
  `token` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDevice`));

/* Creating the MESSAGE table */
CREATE TABLE `sink_engine`.`Message` (
  `idMessage` INT NOT NULL AUTO_INCREMENT,
  `appName` VARCHAR(45) NULL,
  `content` BLOB NULL,
  `timestamp` DATETIME NULL,
  `idDevice` VARCHAR(45) NULL,
  PRIMARY KEY (`idMessage`),
  INDEX `idDeviceFK_idx` (`idDevice` ASC),
  CONSTRAINT `idDeviceFK`
    FOREIGN KEY (`idDevice`)
    REFERENCES `sink_engine`.`Device` (`idDevice`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);