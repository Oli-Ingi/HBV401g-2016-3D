PRAGMA FOREIGN_KEYS=ON;
BEGIN TRANSACTION;

DROP TABLE IF EXISTS TourDates;
DROP TABLE IF EXISTS GuideReviews;
DROP TABLE IF EXISTS TourReviews;
DROP TABLE IF EXISTS Tours;
DROP TABLE IF EXISTS Guides;

CREATE TABLE Guides (
	Name		VARCHAR(50) PRIMARY KEY,
	Nickname	VARCHAR(30) UNIQUE,
	Age		INT,
	Gender		VARCHAR(6),
	Profile		TEXT
);

INSERT INTO Guides(Name,Nickname,Age,Gender,Profile) VALUES('Sigurdur Steinn Gislason','Siggi Steinn',41,'Male',
'Siggi has been a tourguide since he was 5 years old,
when he first dragged his grandmother into the woods
to show her where the rabbits lived.

He started guiding professionally at the age of 18
and his first tour was a walk upon Hekla.

He has a passion for the outdoors and loves to show
other people just how beautiful nature can be.');

INSERT INTO Guides(Name,Nickname,Age,Gender,Profile) VALUES('Anna Sigridur Melbrock','Anna Sigga',34,'Female',
'Anna loves the snow in Iceland. Her favourite
activities are snowmobile riding, skiing and 
computer games (Winter-sports games she plays  
during summer). 

Anna has been a tourguide for the past 6 years
and she has lead people up on Vatnajokull and 
Icelands other great glaciers aswell.');


INSERT INTO Guides(Name,Nickname,Age,Gender,Profile) VALUES('Haraldur Olafsson','Halli Icefit',39,'Male',
'Halli is the best when it comes to whale hunting.
He loves to kill those giant sea beasts and eat
them raw. 
Halli isnt much of a guide but more of a whale
killing enthusiasts. Watching him do what he
does is a fascinating sight but dont expect 
him to know a lot of things or answer any
questions for that matter.');

INSERT INTO Guides(Name,Nickname,Age,Gender,Profile) VALUES('Vilhjalmur Sigmundsson','Villi Siggs',22,'Male',
'Newcomer to the tourguiding world, he is very
energetic and fun. He will make you more interested
in icelands nature and history than you ever thought
you could. ');
	
CREATE TABLE Tours (
        Name VARCHAR(50) PRIMARY KEY,
        Description 	TEXT,
        Duration 	INT,
        Rating 		FLOAT,
	NumberOfRatings INT,
	Price 		INT,
	Destination 	VARCHAR(50),
	Departure 	VARCHAR(50),
	Type 		VARCHAR(50),
	HotelPickup 	BOOLEAN,
	Guide1		VARCHAR(50) REFERENCES Guides(Nickname),
	Guide2		VARCHAR(50) REFERENCES Guides(Nickname),
	Guide3		VARCHAR(50) REFERENCES Guides(Nickname)
);

INSERT INTO Tours(
	Name,Description,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1)
	VALUES(
	'SnowMobile Adventure','We ride snowmobiles up on Vatnajokull.
We will take you ther on a specialized mountain truck
and let you ride on your own snowmobile. 

At noon we will all eat lunch together which we 
provide for you.',10,4.5,55,24000,'Vatnajokull','Vik','Adventure',0, 'Anna Sigga');

INSERT INTO Tours(
	Name,Description,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1)
	VALUES(
	'Silfra scuba diving','We dive into Silfra',7,4.2,45,17000,'Silfra','Reykjavik','Adventure',1,'Siggi Steinn');

INSERT INTO Tours(
	Name,Description,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1)
	VALUES(
	'Vikings of Thingvellir','We will be walking through Thingvellir where we will see remnants
of the oldest parliament in the world. This is where the Vikings
of Iceland decided laws and passed judgements for crimes.

This is a must see for any Vikings tv-show fan.',8,3.7,14,12000,'Thingvellir','Reykjavik','Adventure',0,'Siggi Steinn');

INSERT INTO Tours(
	Name,Description,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1)
	VALUES(
	'Geysers gone wild','We take a bus to see Geysir the famous Geyser which all Geysers
are named after. Bring a rain coat because we are going in!',10,4.6,32,15000,'Geysir','Reykjavik','Golden Circle',1,'Anna Sigga');


INSERT INTO Tours(
	Name,Description,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1)
	VALUES(
	'Whale killahs!','This isnt your regular whale watching tour. Oh no.. 
First we find them, and then we watch them play for a while, 
and then..WE KILL THEM!
We will be gunning for whales on our badass whale killing 
seaMonster (our ship) and when we have caught a whale, 
we eat it.. raw..

Afterwards we will have a kids festival on the peer where 
we will eat marshmallows.',14,2.2,43,32000,'The Ocean','Husavik','Adventure',0,'Halli Icefit');

INSERT INTO Tours(
	Name,Description,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1)
	VALUES(
	'Blue lagoon Day Out','Have a nice day out with friends or family 
enjoying this world famous attraction, the blue lagoon.
The tour starts with a van picking you up at your hotel, and driving
you to your destination. Enjoy the blue waters, healthy masks and 
bar then end the day dinning on one of icelands best restaurants, 
before being driven back to your hotel',8,4.3,231,18000,'Blue Lagoon','Reykjavik','Nature',1,'Villi Siggs');

INSERT INTO Tours(
	Name,Description,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1,Guide2)
	VALUES(
	'Sky on Fire','Come with us to see the magnificent night sky in Iceland.
We will be riding a bus into the wilderness until we see some 
spectacular sights in the sky, in which case we will step out
and eat some sheeps heads together.

Disclaimer: The likelihood of finding any northern lights is 
slim to none. We therefore do not guarantee finding any.',14,3.6,201,23000,'Not decided','Reykjavik','Northern Lights',1,'Halli Icefit','Anna Sigga');

INSERT INTO Tours(
	Name,Description,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1)
	VALUES(
	'Reykjavik Walk','Come with us to see the magnificence of Reykjavik.
We will be walking into reykjavik most epic sceneries and 
spectacular sights.',3,1.2,4,4000,'Reykjavik sights','Downtown Reykjavik','Reykjavik',0,'Villi Siggs');

Create TABLE GuideReviews(
	Name 			VARCHAR(50) REFERENCES Guides(Name),
	ReviewTitle 	VARCHAR(150),
	ReviewTxt 	TEXT,
	Writer			VARCHAR(50),
	WrittenDate 	DATE
);

INSERT INTO GuideReviews(Name,ReviewTitle,ReviewTxt,Writer,WrittenDate) VALUES('Vilhjalmur Sigmundsson','This man is a terrible human being!',
'He is a horrible guide. We went with him ona whale killing
tour and he didnt find any whales for the first part.
He also didnt bring any food for people and he didnt
warn us that it was going to be freezing out there on 
the ocean.. He also didnt talk to anyone or answer any
questions .... asshole', 'Johnny Mormon', '2015-10-22');

Create TABLE TourReviews(
	Name 			VARCHAR(50) REFERENCES Tours(Name) ,
	ReviewTitle 	VARCHAR(50),
	ReviewTxt 	TEXT,
	Writer 			VARCHAR(50),
	WrittenDate 	DATE
);

INSERT INTO TourReviews(Name,ReviewTitle,ReviewTxt,Writer,WrittenDate) VALUES('Whale killahs!','Oh my god.. This was terrible!!',
'This tour is the worst thing I have ever experienced!
We didnt find any whales to eat and there was
nothing else provided to eat so we were just starving
while we sailed the seas in freezing weather.. and
it was snowing because, you know, its Iceland..!','Johnny Mormon','23-04-2015'); 


Create Table TourDates (
	Name 				VARCHAR(50)  REFERENCES Tours(Name),
	Date 				DATE,
	SeatsAvailable 	INT
);

INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES("SnowMobile Adventure", '2016-06-22',23);
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES("SnowMobile Adventure", '2016-07-22',28);	
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES("SnowMobile Adventure", '2016-08-22',30);
	
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES("Silfra scuba diving", '2016-07-12',11);
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES("Silfra scuba diving", '2016-07-15',16);
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES("Silfra scuba diving", '2016-07-17',19);	
	
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES('Vikings of Thingvellir', '2016-06-24',21);
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES('Vikings of Thingvellir', '2016-06-28',4);
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES('Vikings of Thingvellir', '2016-07-01',34);
	
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES('Geysers gone wild', '2016-07-12',12);
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES('Geysers gone wild', '2016-07-13',21);
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES('Geysers gone wild', '2016-07-14',22);
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES('Geysers gone wild', '2016-07-15',27);
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES('Geysers gone wild', '2016-07-16',35);
	
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES('Whale killahs!', '2016-08-06',6);
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES('Whale killahs!', '2016-10-08',9);
	
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES('Blue lagoon Day Out', '2016-05-01',22);
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES('Blue lagoon Day Out', '2016-05-05',27);
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES('Blue lagoon Day Out', '2016-05-09',33);
	
INSERT INTO TourDates(Name, Date,SeatsAvailable)
	VALUES('Sky on Fire', '2017-02-12',33);

COMMIT;