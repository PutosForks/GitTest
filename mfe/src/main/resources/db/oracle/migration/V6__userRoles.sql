
delete from MFE_USER2ROLE;
commit;
delete from MFE_USER;
commit;
delete from MFE_ROLE;
commit;
insert into MFE_ROLE (name, title)
values ('admin', 'Administrátor');
insert into MFE_ROLE (name, title)
values ('risk', 'Risk');
insert into MFE_ROLE (name, title)
values ('sales', 'Sales');
insert into MFE_ROLE (name, title)
values ('logs', 'Logy');
commit;
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (1, '501756091', 'Michal', 'Èervený', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (2, '110030072', 'Monika', 'Pessrová', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (3, '501654631', 'Jiøí', 'Jura', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (4, '110028438', 'Mirka', 'Scheerová', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (5, '123001677', 'Pavel', 'Kuèera', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (6, '110028801', 'Vladimír', 'Trejbal', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (7, '123003365', 'František', 'Karlík', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (8, '110028892', 'Jan', 'Kamenický', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (9, '110028823', 'Dana', 'Šrajerová', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (10, '123046057', 'Pavel', 'Vychodil', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (11, '123026235', 'Michal', 'Novák', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (12, '110032962', 'Lenka', 'Hinková', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (13, '501789706', 'Petr', 'Èesák', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (14, '501790085', 'Pavel', 'Èížek', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (15, '501697763', 'Ondøej', 'Korouš', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (16, '501680253', 'Jan', 'Klas', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (17, '123059337', 'Lenka', 'Klimešová', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (18, '110029686', 'Jiøí', 'Hornický', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (19, '110028747', 'Martina', 'Svobodová', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (20, '123008900', 'Markéta', 'Košíèková', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (22, '123045192', 'Pavel', 'Poznar', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (23, '123059430', 'Josef', 'Bradáè', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (24, '123064802', 'Vladimíra', 'Poláková', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (25, '123064815', 'Marta', 'Urbanová', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (26, '110028440', 'Libuše', 'Mesteková', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (27, '123009906', 'Petra', 'Svobodová', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (28, '110028365', 'Lada', 'Troblová', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (29, '123055237', 'Tomáš', 'Port', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (30, '502168707', 'Tomáš', 'Dlouhý', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (31, '501891415', 'Jiøí', 'Divoký', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (32, '502413934', 'Marko', 'Žiža', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (33, '502012049', 'Vojtìch', 'Kubánek', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (34, '501943396', 'Martin', 'Dobeš', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (35, '502086529', 'Tomáš', 'Zemanec', 1);
insert into MFE_USER (usr_id, usr_sso, usr_firstname, usr_surname, active)
values (36, '501903543', 'Lukas', 'Fulin', 1);
commit;
insert into MFE_USER2ROLE (user_, role, access_type)
values (1, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (2, 'risk', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (3, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (4, 'risk', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (5, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (6, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (7, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (8, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (9, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (10, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (11, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (12, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (13, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (14, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (15, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (16, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (17, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (18, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (19, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (20, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (22, 'admin', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (23, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (24, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (25, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (26, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (27, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (28, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (29, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (30, 'risk', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (30, 'sales', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (30, 'admin', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (31, 'risk', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (31, 'sales', 'read');
insert into MFE_USER2ROLE (user_, role, access_type)
values (32, 'risk', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (32, 'sales', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (32, 'admin', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (33, 'risk', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (33, 'sales', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (33, 'admin', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (34, 'risk', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (34, 'sales', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (34, 'admin', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (35, 'risk', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (35, 'sales', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (35, 'admin', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (36, 'risk', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (36, 'sales', 'write');
insert into MFE_USER2ROLE (user_, role, access_type)
values (36, 'admin', 'write');
commit;
