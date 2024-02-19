drop table if exists public.genders;
create table public.genders(
                               id                SERIAL          NOT NULL UNIQUE PRIMARY KEY,
                               name              VARCHAR(50)     NOT NULL
);

drop table if exists public.nationalities;
create table public.nationalities(
                                     id                SERIAL          NOT NULL UNIQUE PRIMARY KEY,
                                     name              VARCHAR(50)     NOT NULL
);


drop table if exists public.users;
create table public.users(
                             id              SERIAL          NOT NULL UNIQUE PRIMARY KEY,
                             last_name       VARCHAR(50)     NOT NULL,
                             first_name      VARCHAR(50)     NOT NULL,
                             birth_name      VARCHAR(100)    NOT NULL,
                             mothers_name    VARCHAR(100)    NOT NULL,
                             gender          INT             REFERENCES public.genders(id),
                             nationality     INT             NOT NULL REFERENCES public.nationalities(id),
                             phone           VARCHAR(25)     NOT NULL,
                             tax_number      VARCHAR(25)     NOT NULL
);

drop table if exists public.addresses;
create table public.addresses(
                                 id              SERIAL          NOT NULL UNIQUE PRIMARY KEY,
                                 type            VARCHAR(15)     NOT NULL,
                                 user_id         INT             NOT NULL REFERENCES public.users(id),
                                 post_code       VARCHAR(10)     NOT NULL,
                                 city            VARCHAR(100)    NOT NULL,
                                 street          VARCHAR(100)    NOT NULL,
                                 number          VARCHAR(20)     NOT NULL
);

insert into public.genders (name) values ('Férfi');
insert into public.genders (name) values ('Nő');

insert into public.nationalities (name) values ('magyar');
insert into public.nationalities (name) values ('német');
insert into public.nationalities (name) values ('szlovák');
insert into public.nationalities (name) values ('osztrák');