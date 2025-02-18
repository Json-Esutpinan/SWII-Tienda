-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Tienda
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Tienda
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Tienda` DEFAULT CHARACTER SET utf8 ;
USE `Tienda` ;

-- -----------------------------------------------------
-- Table `Tienda`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tienda`.`Cliente` (
  `idCliente` VARCHAR(20) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tienda`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tienda`.`Pedido` (
  `idPedido` VARCHAR(20) NOT NULL,
  `fecha` VARCHAR(20) NULL,
  `Cliente_idCliente` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `fk_Pedido_Cliente_idx` (`Cliente_idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Pedido_Cliente`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `Tienda`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tienda`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tienda`.`Producto` (
  `idProducto` VARCHAR(20) NOT NULL,
  `descripcion` VARCHAR(115) NOT NULL,
  `precio` VARCHAR(45) NOT NULL,
  `Productocol` DOUBLE(16,2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tienda`.`descripcionPedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tienda`.`descripcionPedido` (
  `Producto_idProducto` VARCHAR(20) NOT NULL,
  `Pedido_idPedido` VARCHAR(20) NOT NULL,
  INDEX `fk_Producto_has_Pedido_Pedido1_idx` (`Pedido_idPedido` ASC) VISIBLE,
  INDEX `fk_Producto_has_Pedido_Producto1_idx` (`Producto_idProducto` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_has_Pedido_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `Tienda`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Pedido_Pedido1`
    FOREIGN KEY (`Pedido_idPedido`)
    REFERENCES `Tienda`.`Pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
