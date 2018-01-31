insert into hibernate.mfe_user(usr_id, active, usr_firstname, usr_lastname, usr_sso)
values (hibernate_sequence.nextval, 1, 'Marko', 'Ziza', '502413934');
commit;