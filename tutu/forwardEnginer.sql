-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema PI_test
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema PI_test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PI_test` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `PI_test` ;

-- -----------------------------------------------------
-- Table `PI_test`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PI_test`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `id_pedido` INT NOT NULL,
  `nombre_cliente` VARCHAR(45) NOT NULL,
  `apellido_cliente` VARCHAR(45) NOT NULL,
  `direccion_cliente` VARCHAR(45) NOT NULL,
  `telefono_cliente` VARCHAR(20) NOT NULL,
  `contrasena` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PI_test`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PI_test`.`pedido` (
  `id_pedido` INT NOT NULL AUTO_INCREMENT,
  `fecha_pedido` VARCHAR(20) NOT NULL,
  `factura_pedido` VARCHAR(20) NOT NULL,
  `direccion_cliente` VARCHAR(35) NOT NULL,
  `telefono_cliente` VARCHAR(45) NOT NULL,
  `fecha_pago` DATE NOT NULL,
  `fecha_envio` VARCHAR(45) NOT NULL,
  `cliente_idcliente` INT NOT NULL,
  `iva_producto` FLOAT NOT NULL,
  `subtotal_producto` FLOAT NOT NULL,
  `total_producto` FLOAT NOT NULL,
  PRIMARY KEY (`id_pedido`, `cliente_idcliente`),
  INDEX `fk_pedido_cliente_idx` (`cliente_idcliente` ASC) VISIBLE,
  CONSTRAINT `fk_pedido_cliente`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `PI_test`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PI_test`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PI_test`.`categoria` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,
  `nombre_categoria` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_categoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PI_test`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PI_test`.`productos` (
  `id_productos` INT NOT NULL AUTO_INCREMENT,
  `id_pedido` INT NOT NULL,
  `icantidad_productos` INT NOT NULL,
  `nombre_producto` VARCHAR(15) NOT NULL,
  `descripcion_producto` VARCHAR(60) NOT NULL,
  `precio_producto` DOUBLE NOT NULL,
  `pedido_id_pedido` INT NOT NULL,
  `pedido_cliente_idcliente` INT NOT NULL,
  `categoria_id_categoria` INT NOT NULL,
  PRIMARY KEY (`id_productos`, `pedido_id_pedido`, `pedido_cliente_idcliente`, `categoria_id_categoria`),
  INDEX `fk_productos_categoria1_idx` (`categoria_id_categoria` ASC) VISIBLE,
  CONSTRAINT `fk_productos_categoria1`
    FOREIGN KEY (`categoria_id_categoria`)
    REFERENCES `PI_test`.`categoria` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PI_test`.`detella_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PI_test`.`detella_pedido` (
  `iddetella_pedido` INT NOT NULL AUTO_INCREMENT,
  `cantidad_pedidocol` INT NOT NULL,
  `precio_unitario` FLOAT NULL,
  PRIMARY KEY (`iddetella_pedido`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PI_test`.`detalle_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PI_test`.`detalle_pedido` (
  `iddetalle_pedido` INT NOT NULL AUTO_INCREMENT,
  `cantidad_pedidocol` INT NOT NULL,
  `precio_unitario` FLOAT NOT NULL,
  `pedido_id_pedido` INT NOT NULL,
  `productos_id_productos` INT NOT NULL,
  PRIMARY KEY (`iddetalle_pedido`, `pedido_id_pedido`, `productos_id_productos`),
  INDEX `fk_detalle_pedido_pedido1_idx` (`pedido_id_pedido` ASC) VISIBLE,
  INDEX `fk_detalle_pedido_productos1_idx` (`productos_id_productos` ASC) VISIBLE,
  CONSTRAINT `fk_detalle_pedido_pedido1`
    FOREIGN KEY (`pedido_id_pedido`)
    REFERENCES `PI_test`.`pedido` (`id_pedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_pedido_productos1`
    FOREIGN KEY (`productos_id_productos`)
    REFERENCES `PI_test`.`productos` (`id_productos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
