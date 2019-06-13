INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_ADMIN', 1);
INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_USER', 2);

INSERT INTO `user` (`id`, `username`, `password`, `date_created`, `email`) VALUES (1,'devel','$2a$10$vaFSgXEULxxJCGheBfG6j.pVzbf5GbPoQh1kskOismOKfhwtT2MGG','2019-06-10 10:00:00', 'jsg_sanchez@hotmail.com');

INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (1, 1);
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (2, 1);

