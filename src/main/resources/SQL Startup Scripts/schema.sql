
DROP TABLE IF EXISTS Notes;

CREATE TABLE keepNotes(
    note_id int(11) NOT NULL AUTO_INCREMENT,
    note_title varchar(45) default null,
    note_content varchar(300) default null,
    note_status varchar(20) default 'To Start',
    creation_date timestamp default current_timestamp,
    primary key(note_id))
engine=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=UTF8;