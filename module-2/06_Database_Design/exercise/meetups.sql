--Add 8 members.

INSERT INTO member(last_name, first_name, email_address, phone_number, birthday, wants_reminders)
VALUES (
	'Bosh',
	'Tyler',
	'tylerbosh@gmail.com',
	'4847058041',
	'19941029',
	false
);

INSERT INTO member(last_name, first_name, email_address, phone_number, birthday, wants_reminders)
VALUES (
	'Shmoe',
	'Joe',
	'josephshmoeseph@gmail.com',
	'5134885001',
	'19991122',
	true
);

INSERT INTO member(last_name, first_name, email_address, phone_number, birthday, wants_reminders)
VALUES (
	'Doe',
	'Jane',
	'unknownaddress@gmail.com',
	'0000000000',
	'19000101',
	true
);

INSERT INTO member(last_name, first_name, email_address, phone_number, birthday, wants_reminders)
VALUES (
	'Franklin',
	'Benjamin',
	'onehundreddollar@gmail.com',
	'1000011001',
	'19200115',
	false
);

INSERT INTO member(last_name, first_name, email_address, phone_number, birthday, wants_reminders)
VALUES (
	'Sam',
	'Toucan',
	'frootloops@gmail.com',
	'8909919019',
	'18001028',
	false
);

INSERT INTO member(last_name, first_name, email_address, phone_number, birthday, wants_reminders)
VALUES (
	'Kent',
	'Clark',
	'notsuperman@gmail.com',
	'1156108820',
	'00010101',
	true
);

INSERT INTO member(last_name, first_name, email_address, phone_number, birthday, wants_reminders)
VALUES (
	'Voldemort',
	'Lord',
	'tonmriddle@gmail.com',
	'8104446017',
	'19850602',
	false
);

INSERT INTO member(last_name, first_name, email_address, phone_number, birthday, wants_reminders)
VALUES (
	'Skywalker',
	'Luke',
	'moisturefarmer@gmail.com',
	'4847089999',
	'00010506',
	true
);

--Add three groups.

INSERT INTO interest_group(name, members)
VALUES (
	'History Fanatics',
	0
);

INSERT INTO interest_group(name, members)
VALUES (
	'Evil People',
	0
);

INSERT INTO interest_group(name, members)
VALUES (
	'Magic Mushrooms FTW',
	0
);

--Add four events.

INSERT INTO event (name, description, start_date_time, duration, group_host, members)
VALUES (
	'A Look at Modern Futurism',
	'A brief lecture about who knows?',
	'2022-04-20 17:00:00',
	120,
	'History Fanatics',
	0
);

INSERT INTO event (name, description, start_date_time, duration, group_host, members)
VALUES (
	'Dominating Third World Countries',
	'Its a secret to everyone.',
	'2022-06-15 14:30:00',
	60,
	'Evil People',
	0
);

INSERT INTO event (name, description, start_date_time, duration, group_host, members)
VALUES (
	'Tripping Time',
	'You know what time it is...',
	'2022-04-20 12:00:00',
	240,
	'Magic Mushrooms FTW',
	0
);

INSERT INTO event (name, description, start_date_time, duration, group_host, members)
VALUES (
	'Taking Candy From Children',
	'We are going to steal candy from children.',
	'2022-12-24 10:05:00',
	360,
	'Evil People',
	0
);

--Add at least 2 members to each group.

INSERT INTO group_member (member_number, interest_group)
VALUES (
	(SELECT member_number FROM member WHERE last_name = 'Bosh'),
	'Magic Mushrooms FTW'
);

INSERT INTO group_member (member_number, interest_group)
VALUES (
	(SELECT member_number FROM member WHERE last_name = 'Sam'),
	'Magic Mushrooms FTW'
);

INSERT INTO group_member (member_number, interest_group)
VALUES (
	(SELECT member_number FROM member WHERE last_name = 'Voldemort'),
	'Evil People'
);

INSERT INTO group_member (member_number, interest_group)
VALUES (
	(SELECT member_number FROM member WHERE last_name = 'Shmoe'),
	'Evil People'
);

INSERT INTO group_member (member_number, interest_group)
VALUES (
	(SELECT member_number FROM member WHERE last_name = 'Skywalker'),
	'History Fanatics'
);

INSERT INTO group_member (member_number, interest_group)
VALUES (
	(SELECT member_number FROM member WHERE last_name = 'Franklin'),
	'History Fanatics'
);

--Update groups with new members.

UPDATE interest_group 
SET members = (
	SELECT COUNT(member_number) 
	FROM group_member 
	WHERE interest_group = 'Magic Mushrooms FTW')
WHERE name = 'Magic Mushrooms FTW';

UPDATE interest_group 
SET members = (
	SELECT COUNT(member_number) 
	FROM group_member 
	WHERE interest_group = 'Evil People')
WHERE name = 'Evil People';

UPDATE interest_group 
SET members = (
	SELECT COUNT(member_number) 
	FROM group_member 
	WHERE interest_group = 'History Fanatics')
WHERE name = 'History Fanatics';

--Add at least 1 member to each event. 

INSERT INTO event_member (member_number, event_number)
VALUES (
	(SELECT member_number FROM member WHERE last_name = 'Bosh'),
	(SELECT event_number FROM event WHERE name = 'Tripping Time')
);

INSERT INTO event_member (member_number, event_number)
VALUES (
	(SELECT member_number FROM member WHERE last_name = 'Voldemort'),
	(SELECT event_number FROM event WHERE name = 'Taking Candy From Children')
);

INSERT INTO event_member (member_number, event_number)
VALUES (
	(SELECT member_number FROM member WHERE last_name = 'Shmoe'),
	(SELECT event_number FROM event WHERE name = 'Dominating Third World Countries')
);

INSERT INTO event_member (member_number, event_number)
VALUES (
	(SELECT member_number FROM member WHERE last_name = 'Kent'),
	(SELECT event_number FROM event WHERE name = 'A Look at Modern Futurism')
);

--Update events with new attendees.

UPDATE event 
SET members = (
	SELECT COUNT(member_number) 
	FROM event_member 
	WHERE event_number = (SELECT event_number FROM event WHERE name = 'Tripping Time')
)
WHERE name = 'Tripping Time';

UPDATE event 
SET members = (
	SELECT COUNT(member_number) 
	FROM event_member 
	WHERE event_number = (SELECT event_number FROM event WHERE name = 'Taking Candy From Children')
)
WHERE name = 'Taking Candy From Children';

UPDATE event 
SET members = (
	SELECT COUNT(member_number) 
	FROM event_member 
	WHERE event_number = (SELECT event_number FROM event WHERE name = 'Dominating Third World Countries')
)
WHERE name = 'Dominating Third World Countries';

UPDATE event 
SET members = (
	SELECT COUNT(member_number) 
	FROM event_member 
	WHERE event_number = (SELECT event_number FROM event WHERE name = 'A Look at Modern Futurism')
)
WHERE name = 'A Look at Modern Futurism';
