create database if not exists `sotaynauan`;

create table `sotaynauan`.`monan`(
`IDmon` int auto_increment,
`Tenmon` nvarchar(30) not null,
`Cachlam` text not null,
`Image` blob null, 
`Loai` nvarchar(20) not null,
PRIMARY KEY (`IDmon`)
)ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

create table `sotaynauan`.`user`(
`idUser` int auto_increment,
`Password` varchar(20) not null unique,
`Username` varchar(25) not null,
primary key(`idUser`)
)ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

create table `sotaynauan`.`nguyenlieu`(
`IDnguyenlieu` int auto_increment ,
`Tennguyenlieu` varchar(100) not null,
`Image` blob null, 
primary key (IDnguyenlieu)
)ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

create table `sotaynauan`.`thucdon`(
`IDthucdon` int auto_increment,
`Tenthucdon` varchar(100) not null,
`Creator` varchar(20) null,
primary key(IDthucdon)
)ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

create table `sotaynauan`.`thanhphan`(
`IDmonan` int,
`IDnguyenlieu` int,
`IDthanhphan` int auto_increment,
primary key(IDthanhphan),
FOREIGN KEY (IDmonan) REFERENCES monan(Idmon),
FOREIGN KEY (IDnguyenlieu) REFERENCES nguyenlieu(IDnguyenlieu)
)ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

create table `sotaynauan`.`thucdonmonan`(
`IDmonan` int,
`IDthucdon` int,
`Loai` varchar(20),
`IDthucdonmonan` int auto_increment,
primary key(IDthucdonmonan),
FOREIGN KEY (IDmonan) REFERENCES monan(IDmon),
FOREIGN KEY (IDthucdon) REFERENCES thucdon(IDthucdon)
)ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

create table `sotaynauan`.`chitietthucdon`(
`IDthucdon` varchar(20) references 
`sotaynauan`.`thucdon`(IDthucdon),
`IDmon` varchar(20) references 
`sotaynauan`.`monan`(IDmon)
)engine = innodb;

-- create table `sotaynauan`.`buoctienhanh`(
-- `IDmon` varchar(20) not null references 
-- `sotaynauan`.`monan`(IDmon),
-- `IDbuoc` varchar(20) auto_increment primary key,
-- `Thuchien` text not null
-- )engine = innodb;




