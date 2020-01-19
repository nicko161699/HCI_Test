CREATE TABLE `hci`.`module` (
  `id` INT NOT NULL,
  `module_name` VARCHAR(45) NOT NULL,
  `module_order` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `hci`.`users` (
  `id` INT NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `hci`.`users` (`id`, `user_id`) VALUES ('1', 'userA');
INSERT INTO `hci`.`users` (`id`, `user_id`) VALUES ('2', 'userB');
INSERT INTO `hci`.`users` (`id`, `user_id`) VALUES ('3', 'userC');

INSERT INTO `hci`.`module` (`id`, `module_name`) VALUES ('1', 'PromoCard');
INSERT INTO `hci`.`module` (`id`, `module_name`) VALUES ('2', 'CategoryCard');
INSERT INTO `hci`.`module` (`id`, `module_name`) VALUES ('3', 'FlashSaleCard');
INSERT INTO `hci`.`module` (`id`, `module_name`) VALUES ('4', 'HistoryCard');
INSERT INTO `hci`.`module` (`id`, `module_name`) VALUES ('5', 'NewsCard');

CREATE TABLE `hci`.`order` (
  `user_id` INT NOT NULL,
  `module_id` INT NOT NULL,
  `module_order` INT NOT NULL,
  PRIMARY KEY (`user_id`, `module_id`),
  INDEX `module_id_idx` (`module_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `hci`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `module_id`
    FOREIGN KEY (`module_id`)
    REFERENCES `hci`.`module` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
