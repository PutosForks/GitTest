create or replace trigger CON_TEMPLATE_VER_STATUS_TRI
before insert on CON_TEMPLATE_VER_STATUS
for each row
begin
if :new.id is null then
:new.id:= hibernate_sequence.nextval;
end if;
end;
/

create or replace trigger CON_TEMPLATE_STATUS_TRI
before insert on CON_TEMPLATE_STATUS
for each row
begin
:new.id_template_status := hibernate_sequence.nextval;
end;
/
