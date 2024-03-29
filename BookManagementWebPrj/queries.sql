
create table LOGIN_MST (user_id number(5) primary key,
login_id Varchar2(10) not null,
password Varchar2(15) not null,
user_name Varchar2(15),
user_type Varchar2(15) not null,
constraint user_type_check check(user_type in ('Admin', 'Member'))
);

select * from LOGIN_MST;

create table  TOUR_PLAN_MST (tour_id NUMBER(2) GENERATED BY DEFAULT AS IDENTITY,
tour_name Varchar(15) not null,
starting_location varchar(20),
places_included varchar(20) not null,
tour_cost number(10) not null,
Discount_per number(10),
tour_days number(10) not null,
 
);

select * from TOUR_PLAN_MST;

create table REGISTRATION_DETAILS (tour_booking_id NUMBER(5)primary key,
member_name varchar(20) not null,
no_of_passengers NUMBER(5) default 0,
amount_paid NUMBER(10) not null,
journey_start_date DATE not null,
tour_id NUMBER(5) not null,
isActive NUMBER(2),
Remarks varchar(50),
constraint fk_key foreign key (tour_id) references  TOUR_PLAN_MST(tour_id),
constraint isActive_check check(isActive in (0,1))
);

select * from REGISTRATION_DETAILS;

create table TBL_Booking (BookingID NUMBER(5) GENERATED BY DEFAULT AS IDENTITY,
Customername varchar(20),
LicenseNo varchar(10),
VehicleMake varchar(10),
ProposedDate DATE DEFAULT (sysdate)
);

alter table TBL_Booking
add constraint pk_cnstrt primary key (BookingID);

select * from TBL_Booking;




