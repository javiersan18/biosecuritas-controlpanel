INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_ADMIN', 1);
INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_USER', 2);

INSERT INTO authority(name, id) VALUES ('ROLE_ADMIN', 1);
INSERT INTO authority(name, id) VALUES ('ROLE_USER', 2);

INSERT INTO `user` (`id`, `username`, `password`, `creation_date`, `email`, `name`, `surname1`, `surname2`) VALUES (1,'devel','$2a$10$vaFSgXEULxxJCGheBfG6j.pVzbf5GbPoQh1kskOismOKfhwtT2MGG','2019-06-10 10:00:00', 'jsg_sanchez@hotmail.com', 'devel', '', '');
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (1, 1);
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (2, 1);

INSERT INTO user (id, username, password, creation_date, email, name, surname1, surname2) VALUES (1,'devel','$2a$10$vaFSgXEULxxJCGheBfG6j.pVzbf5GbPoQh1kskOismOKfhwtT2MGG','2019-06-10 10:00:00', 'jsg_sanchez@hotmail.com', 'devel', '', '');
INSERT INTO user_authority(authority_id, user_id) VALUES (1, 1);
INSERT INTO user_authority(authority_id, user_id) VALUES (2, 1);

INSERT INTO `user` (`id`, `username`, `password`, `creation_date`, `email`, `name`, `surname1`, `surname2`) VALUES (2,'alvaro.perez','$2a$10$vaFSgXEULxxJCGheBfG6j.pVzbf5GbPoQh1kskOismOKfhwtT2MGG','2019-06-10 10:00:00', 'poncho@hotmail.com', 'Álvaro', 'Pérez', 'Muñoz');
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (1, 2);
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (2, 2);

INSERT INTO "user" (id, username, password, creation_date, email, name, surname1, surname2) VALUES (2,'alvaro.perez','$2a$10$vaFSgXEULxxJCGheBfG6j.pVzbf5GbPoQh1kskOismOKfhwtT2MGG','2019-06-10 10:00:00', 'poncho@hotmail.com', 'Álvaro', 'Pérez', 'Muñoz');
INSERT INTO user_authority(authority_id, user_id) VALUES (1, 2);
INSERT INTO user_authority(authority_id, user_id) VALUES (2, 2);

