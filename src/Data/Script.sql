create database if not exists pizzeria;
create table pizzaer (
	PizzaID int not null auto_increment,
    Pizzanavn varchar(255) default null,
    Ingredienser varchar(255) default null,
    Pris double default null,
    primary key(PizzaID)
    )engine=InnoDB default charset=utf8;
insert into pizzaer(Pizzanavn,Ingredienser,Pris)
values ('Vesuvio','tomatsauce,ost,skinke og oregano',57);

create table bestillinger (
BestillingsID int not null auto_increment,
Afhentning time default null,
primary key(BestillingsID)
)engine=InnoDB default charset=utf8;
insert into bestillinger(afhentning)
values(122200);

create table pizzabestillinger (
BestillingsID int not null,
PizzaID int not null,
foreign key(PizzaID) references pizzaer(PizzaID),
foreign key(BestillingsID) references bestillinger(BestillingsID)
)engine=InnoDB default charset=utf8;