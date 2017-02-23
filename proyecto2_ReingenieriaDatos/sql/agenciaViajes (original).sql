-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema AgenciaViajes
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema AgenciaViajes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AgenciaViajes` DEFAULT CHARACTER SET latin1 ;
USE `AgenciaViajes` ;

-- -----------------------------------------------------
-- Table `AgenciaViajes`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgenciaViajes`.`Cliente` (
  `idCliente` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgenciaViajes`.`Agencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgenciaViajes`.`Agencia` (
  `idAgencia` INT NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`idAgencia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgenciaViajes`.`Hotel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgenciaViajes`.`Hotel` (
  `idHotel` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `ciudad` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `numPlazas` INT NULL,
  `Agencia_idAgencia` INT NOT NULL,
  PRIMARY KEY (`idHotel`),
  INDEX `fk_Hotel_Agencia1_idx` (`Agencia_idAgencia` ASC),
  CONSTRAINT `fk_Hotel_Agencia1`
    FOREIGN KEY (`Agencia_idAgencia`)
    REFERENCES `AgenciaViajes`.`Agencia` (`idAgencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgenciaViajes`.`Vuelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgenciaViajes`.`Vuelo` (
  `idVuleo` INT NOT NULL,
  `fecha` DATETIME NULL,
  `origen` VARCHAR(45) NULL,
  `destino` VARCHAR(45) NULL,
  `plazasTotal` INT NULL,
  `plazasTurista` INT NULL,
  `Agencia_idAgencia` INT NOT NULL,
  PRIMARY KEY (`idVuleo`),
  INDEX `fk_Vuleo_Agencia1_idx` (`Agencia_idAgencia` ASC),
  CONSTRAINT `fk_Vuleo_Agencia1`
    FOREIGN KEY (`Agencia_idAgencia`)
    REFERENCES `AgenciaViajes`.`Agencia` (`idAgencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AgenciaViajes`.`Atiende`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgenciaViajes`.`Atiende` (
  `Cliente_idCliente` INT NOT NULL,
  `Agencia_idAgencia` INT NOT NULL,
  `fecha` DATETIME NOT NULL,
  PRIMARY KEY (`Cliente_idCliente`, `Agencia_idAgencia`, `fecha`),
  INDEX `fk_Cliente_has_Agencia_Agencia1_idx` (`Agencia_idAgencia` ASC),
  INDEX `fk_Cliente_has_Agencia_Cliente1_idx` (`Cliente_idCliente` ASC),
  CONSTRAINT `fk_Cliente_has_Agencia_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `AgenciaViajes`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cliente_has_Agencia_Agencia1`
    FOREIGN KEY (`Agencia_idAgencia`)
    REFERENCES `AgenciaViajes`.`Agencia` (`idAgencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
