

insert into education_degree values (1, "Trung Cấp"),
(2, "Cao Đẳng"),
 (3, "Đại Học"),
(4, "Sau Đại Học");

insert into  positon values
 (1, "Quản Lí"),
(2, "Nhân Viên");

insert into division values(1,	"Sale-Marketing"),
(2,"Hành chính"),
(3,"Phục vụ"),
(4,"Quản lý");

insert into employee (employee_id,employee_code, employee_name,employee_birth_day,employeecmnd,employee_salary,employee_phone
,employee_email,employee_address,id_positon_position_id,id_education_degree_education_degree_id,id_division_division_id)
values
(1,"NV8989", "Nguyễn Văn An", "1970-11-07","456231786", 10000000, "0123456789", "annguyen@gmail.com", "295 Nguyễn Tất Thành, Đà Nẵng", 1, 3, 1),
(2,"NV8989", "Lê Văn Bình", "1997-04-09", "654231234", 7000000, "0984534758", "binhlv@gmail.com", "22 Yên Bái, Đà Nẵng", 1, 2, 2),
(3,"NV8989", "Hồ Thị Yến", "1995-12-12", "999231723", 14000000, "0456764542", "thiyen@gmail.com", "K234/11 Điện Biên Phủ, Gia Lai", 1, 3, 2),
(4,"NV8989", "Võ Công Toản", "1980-04-04", "123231365", 17000000, "0379853432", "toan0404@gmail.com", "77 Hoàng Diệu, Quảng Trị", 1, 4, 4),
(5,"NV8989", "Nguyễn Bỉnh Phát", "1999-12-09", "454363232", 6000000, "0902433454", "phatphat@gmail.com", "43 Yên Bái, Đà Nẵng", 2, 1, 1),
(6,"NV8989", "Khúc Nguyễn An Nghi", "2000-11-08", "964542311", 7000000, "0978650000", "annghi20@gmail.com", "294 Nguyễn Tất Thành, Đà Nẵng", 2, 2, 3),
(7,"NV8989", "Nguyễn Hữu Hà", "1993-01-01", "534323231", 8000000, "0941234553", "nhh0101@gmail.com", "4 Nguyễn Chí Thanh, Huế", 2, 3, 2),
(8,"NV8989", "Nguyễn Hà Đông", "1989-09-03", "234414123", 9000000, "0642123111", "donghanguyen@gmail.com", "11 Hùng Vương, Hà Nội", 2, 4, 4),
(9,"NV8989", "Tòng Hoang", "1982-09-03", "256781231", 6000000, "0245144444", "hoangtong@gmail.com", "213 Hàm Nghi, Đà Nẵng", 2, 4, 4),
(10,"NV8989", "Nguyễn Công Đạo", "1994-01-08", "755434343", 8000000, "0988767111", "nguỹenongdao12@gmail.com", "6 Hoà Khánh, Đồng Nai", 2, 3, 2);


insert into customer_type(customer_type_name) values 
("Diamond"),
("Platinium"),
("Gold"),
("Silver"),
("Member");


insert into customer (customer_code,customer_name,customer_birth_day,customer_gender,customercmdd,customer_phone,customer_email,customer_address, id_customer_type)
 value("KH9999","Nguyễn Thị Hào","1970-11-07",b'0',"643431213","0945423362","thihao07@gmail.com","23 Nguyễn Hoàng,Đà Nẵng",5),
("KH9999","Phạm Xuân Diệu","1992-08-08",b'1',"865342123","0954333333","xuandieu92@gmail.com","K77/22 Thái Phiên, Quảng Trị",3),
("KH9999","Trương Đình Nghệ","1990-02-27",b'1',"488645199","0373213122","nghenhan2702@gmail.com","K323/12 Ông Ích Khiêm, Vinh",1),
("KH9999","Dương Văn Quan","1981-07-08",b'1',"543432111","0490039241","duongquan@gmail.com","K453/12 Lê Lợi, Đà Nẵng",1),
("KH9999","Hoàng Trần Nhi Nhi","1995-12-09",b'0',"795453345","0312345678","nhinhi123@gmail.com","224 Lý Thái Tổ, Gia Lai",4),
("KH9999","Tôn Nữ Mộc Châu","2005-12-06",b'0',"732434215","0988888844","tonnuchau@gmail.com","37 Yên Thế, Đà Nẵng",4),
("KH9999","Nguyễn Mỹ Kim","1984-04-08",b'0',"856453123","0912345698","kimcuong84@gmail.com","K123/45 Lê Lợi, Hồ Chí Minh",1),
("KH9999","Nguyễn Thị Hào","1999-04-08",b'0',"965656433","0763212345","haohao99@gmail.com","55 Nguyễn Văn Linh, Kon Tum",3),
("KH9999","Trần Đại Danh","1994-07-01",b'1',"432341235","0643343433","danhhai99@gmail.com","24 Lý Thường Kiệt, Quảng Ngãi",1),
("KH9999","Nguyễn Tâm Đắc","1989-07-01",b'1',"344343432","0987654321","tdactam@gmail.com","22 Ngô Quyền, Đà Nẵng",2);


insert into rent_type(rent_type_id, rent_type_name) values
(1,'year'),
(2,'month'),
(3,'day'),
(4,'hour');


insert into service_type(service_type_id,service_type_name) values
(1,"Villa"),
(2,'House'),
(3,'Room');

-- , , , , , , , , 
-- , service_type_id, , , rent_id

insert into service(service_name, service_area, service_cost, service_max_people,standard_room,description_other_convernience
,pool_area,number_off_floors,rent_type_service_rent_type_id,rent_type)
 value("Villa Beach Front","25000",10000000,10,"vip","Có hồ bơi",500,4,3,1),
("House Princess 01","14000",5000000,7,"vip","Có thêm bếp nướng",null,3,2,2),
("Room Twin 01","5000",1000000,2,"vip","Có tivi",null,null,4,3),
("Villa No Beach Front","22000",9000000,8,"normal","Có hồ bơi",300,3,3,1),
("House Princess 02","10000",4000000,5,"normal","Có thêm bếp nướng",null,2,3,2),
("Room Twin 02","3000",900000,2,"normal","Có tivi",null,null,4,3);


insert into contract(contract_id, contract_start_day, contract_end_day ,contract_to_tal_money,id_employee_employee_id,id_customer_customer_id,id_service_service_id)
value (1,"2020-12-08","2020-12-08",0,3,1,3),
(2,"2020-07-14","2020-07-21",200000,7,3,1),
(3,"2021-03-15","2021-03-17",50000,7,3,1),
(4,"2021-01-14","2021-01-18",100000,7,5,5),
(5,"2021-01-14","2021-01-15",0,7,2,6),
(6,"2021-06-01","2021-06-03",0,7,7,6),
(7,"2021-06-01","2021-06-05",100000,7,4,4),
(8,"2021-06-17","2021-06-18",150000,3,4,1),
(9,"2020-11-19","2020-11-19",0,3,4,3),
(10,"2021-04-12","2021-04-14",0,10,3,5),
(11,"2021-04-25","2021-04-25",0,2,2,1),
(12,"2021-05-25","2021-05-25",0,7,10,1);


insert into attach_service(attach_service_id,attach_service_name,attach_service_cost, attach_service_unit,attach_service_status)
 value (1,"massage",10000,"giờ","tiện nghi" ),
		(2,"karaoke",5000,"giờ","tiện nghi, hiện tại" ),
        (3,"thức ăn",15000,"suất","đầy đủ đồ ăn, tráng miệng"),
        (4,"nước uống",7000,"chai","đầy đủ đồ uống"),
        (5,"thuê xe",50000,"chiếc","hỏng 1 chiếc");


insert into contract_detail(contract_detail_id,quantity,contract_contract_id,id_attach_service_attach_service_id)
values(1,5, 2, 4),
(2,8, 2, 5),
(3,15, 2, 5),
(4,1, 3, 1),
(5,11, 3, 2),
(6,1, 1, 3),
(7,2, 1, 2),
(8,2, 12, 2);


