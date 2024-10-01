CREATE TABLE `customer_service`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `custName` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `mobile` VARCHAR(45) NULL,
  `dob` DATE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `custName_UNIQUE` (`custName` ASC));