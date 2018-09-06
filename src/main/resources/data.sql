insert into role (role_id, role) values(1,'ADMIN');
insert into role (role_id, role) values(2,'EDITOR');
insert into role (role_id, role) values(3,'GUEST');

Insert into users (`id`, `username`, `password`, `enabled` )values ( 1, 'bubu', '$2a$10$/3J0dSgO0d/acwbeZJ0aAOIdhqtETsWAfvHNOv3aRYRy3cukE/q0i', 1);
Insert into user_role values (1,2);
