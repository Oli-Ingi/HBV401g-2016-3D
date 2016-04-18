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

CREATE TABLE Tours (
        Name VARCHAR(50) PRIMARY KEY,
        Description 	TEXT,
        SeatsAvailable 	INT,
        Date 		DATE,
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
	Name,Description,SeatsAvailable,Date,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1)
	VALUES(
	'SnowMobile Adventure','We ride snowmobiles up on Vatnajokull.
We will take you ther on a specialized mountain truck
and let you ride on your own snowmobile. 

At noon we will all eat lunch together which we 
provide for you.',16,'2016-06-22',10,4.5,55,24000,'Vatnajokull','Vik','Adventure',0, 'Anna Sigga');

INSERT INTO Tours(
	Name,Description,SeatsAvailable,Date,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1)
	VALUES(
	'Silfra scuba diving','We dive into Silfra',8,'2016-07-12',7,4.2,45,17000,'Silfra','Reykjavik','Adventure',1,'Siggi Steinn');

INSERT INTO Tours(
	Name,Description,SeatsAvailable,Date,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1)
	VALUES(
	'Vikings of Thingvellir','We will be walking through Thingvellir where we will see remnants
of the oldest parliament in the world. This is where the Vikings
of Iceland decided laws and passed judgements for crimes.

This is a must see for any Vikings tv-show fan.',30,'2016-06-24',8,3.7,14,12000,'Thingvellir','Reykjavik','Adventure',0,'Siggi Steinn');

INSERT INTO Tours(
	Name,Description,SeatsAvailable,Date,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1)
	VALUES(
	'Geysers gone wild','We take a bus to see Geysir the famous Geyser which all Geysers
are named after. Bring a rain coat because we are going in!',23,'2016-07-12',10,4.6,32,15000,'Geysir','Reykjavik','Golden Circle',1,'Anna Sigga');


INSERT INTO Tours(
	Name,Description,SeatsAvailable,Date,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1)
	VALUES(
	'Whale killahs!','This isnt your regular whale watching tour. Oh no.. 
First we find them, and then we watch them play for a while, 
and then..WE KILL THEM!
We will be gunning for whales on our badass whale killing 
seaMonster (our ship) and when we have caught a whale, 
we eat it.. raw..

Afterwards we will have a kids festival on the peer where 
we will eat marshmallows.',14,'2016-08-06',14,2.2,43,32000,'The Ocean','Husavik','Adventure',0,'Halli Icefit');

INSERT INTO Tours(
	Name,Description,SeatsAvailable,Date,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1)
	VALUES(
	'Blue lagoon Day Out','Have a nice day out with friends or family 
enjoying this world famous attraction, the blue lagoon.
The tour starts with a van picking you up at your hotel, and driving
you to your destination. Enjoy the blue waters, healthy masks and bar
then end the day dinning on one of icelands best restaurants, 
before being driven back to your hotel',10,'2016-07-06',8,4.3,231,18000,'Blue Lagoon','Reykjavik','Nature',1,'Villi Siggs');

INSERT INTO Tours(
	Name,Description,SeatsAvailable,Date,Duration,Rating,NumberOfRatings,Price,Destination,Departure,Type,HotelPickup,Guide1)
	VALUES(
	'Sky on Fire ','Come with us to see the magnificence of the night sky in Iceland.
We will be riding a bus into the wilderness until we see some 
spectacular sights in the sky, in which case we will step out
and eat some sheeps heads together.

Disclaimer: The likelihood of finding any northern lights is 
slim to none. We therefore do not guarantee finding any.',26,'2017-02-12',14,3.6,201,23000,'Depends on weather','Reykjavik','Northern Lights',1,'Halli Icefit');
