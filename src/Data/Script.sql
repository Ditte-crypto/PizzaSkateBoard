USE pizzeria;

create table pizzaer (
PizzaID int not null auto_increment,
Pizzanavn varchar(255) default null,
Ingredienser varchar(255) default null,
Pris double default null,
primary key(PizzaID)
)engine=InnoDB default charset=utf8;
insert into pizzaer(Pizzanavn,Ingredienser,Pris)
values ('Vesuvio','tomatsauce,ost,skinke og oregano',57);

insert into pizzaer(Pizzanavn,Ingredienser,Pris)
values ('Margarita','tomatsauce,ost,skinke og oregano',57);


insert into pizzaer(Pizzanavn,Ingredienser,Pris)
values ('Pineapple','tomatsauce,ost,skinke og oregano',57);

create table bestillinger (
BestillingsID int not null auto_increment,
Afhentning TIME,
primary key(BestillingsID)
)engine=InnoDB default charset=utf8;
insert into bestillinger(Afhentning)
values(`11:22:00`);

INSERT INTO bestillinger(Afhentning)
VALUES('11:04:30');

INSERT INTO bestillinger(Afhentning)
VALUES(`14:30:00`);

create table pizzabestillinger (
BestillingsID int not null,
PizzaID int not null,
foreign key(PizzaID) references pizzaer(PizzaID),
foreign key(BestillingsID) references bestillinger(BestillingsID)
)engine=InnoDB default charset=utf8;

INSERT INTO pizzabestillinger (BestillingsID, PizzaID)
VALUES(1,3),(1,2),(2,1);

insert into pizzabestillinger(BestillingsID, PizzaID) values (24,1);insert into pizzabestillinger(BestillingsID, PizzaID) values (24,2);