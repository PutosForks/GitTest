insert into mfe_user(usr_id, active, usr_firstname, USR_SURNAME, usr_sso)
values (hibernate_sequence.nextval, 1, 'Marko', 'Ziza', '502413934');
commit;