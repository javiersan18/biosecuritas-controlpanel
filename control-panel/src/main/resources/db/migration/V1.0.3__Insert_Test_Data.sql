INSERT INTO `client` (`client_code`,`cc`,`cif`,`dni`,`t`,`address`,`province`,`city`,`postal_code`,`country`,`date_fin`,`date_ini`,`f_address`,`f_city`,`f_country`,`f_postal_code`,`f_province`,`name`,`numc`,`rega`,`representative`,`surname`) VALUES (1,'ES63-0081-0380-4600-0156-8261','J22193932','18023071H',5,'CTRA Valle de Aran, 5', 'Capella','Huesca',22480,'ESP',TO_DATE( '14/JUN/2016', 'DD/MON/YYYY' ),TO_DATE('14/JUN/2021','DD/MON/YYYY'),'a','b','c',28011,'d','AGROPECUARIA EL TORMILLO, S.L.',16,'ES222130000181, ES222130000180, ES222130000182, ES222130000179','Mazana, Puyal, Manuel','');
INSERT INTO `PUBLIC`.`FARM`(`ADDRESS`,`CITY`,`CONTACT_NAME`,`CONTACT_PHONE`,`COUNTRY`,`NUM_SANDACH`,`POSTAL_CODE`,`PREFIX`,`PROVINCE`,`CLIENT_ID_CLIENT_CODE`) VALUES('POLG 1 PARC 114 - 115','Huesca','Alfredo','686574620','ESP',28011,'+34','Capella','ES220800000081',1)