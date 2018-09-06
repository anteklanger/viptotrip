insert into role (role_id, role)
values (1, 'ADMIN');
insert into role (role_id, role)
values (2, 'EDITOR');
insert into role (role_id, role)
values (3, 'GUEST');

Insert into users (`id`, `username`, `password`, `enabled`, `admin_vip`)
values (1, 'bubu', '$2a$10$/3J0dSgO0d/acwbeZJ0aAOIdhqtETsWAfvHNOv3aRYRy3cukE/q0i', 1, true);
Insert into users (`id`, `username`, `password`, `enabled`, `editor_vip`)
values (2, 'test', '$2a$10$GItMgw5DJRvhkVACOKLuPuA37b38iw9Jj3qInKXA7kMwCg4XTniIW', 1, true);
Insert into users (`id`, `username`, `password`, `enabled`, `guest_vip`)
values (3, 'user', '$2a$10$DjKVi75bDlY7ffkQzu0ujeMNdwzY1EyEtU3VjNcDGh/Y9o1bqC/1a', 1, true);

Insert into user_role
values (1, 1);
Insert into user_role
values (2, 2);
Insert into user_role
values (3, 3);

