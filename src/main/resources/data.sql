--DO $$
--BEGIN
--	  IF NOT EXISTS (SELECT * FROM role  WHERE name = 'admin') THEN
--	   INSERT INTO role (id, name) VALUES (1, 'admin'), (2, 'faculty'), (3, 'student');
--	   SELECT SETVAL('role_seq',3);
--	  END IF;
--END $$



INSERT INTO role (id, name) VALUES (1, 'admin');
INSERT INTO role (id, name) VALUES (2, 'faculty');
INSERT INTO role (id, name) VALUES (3, 'student');

INSERT INTO tag (id, value) VALUES
                                                 (1, 'Information Technology (IT)'),
                                                 (2, 'Marketing and Advertising'),
                                                 (3, 'Finance and Accounting'),
                                                 (4, 'Sales and Business Development'),
                                                 (5, 'Human Resources (HR)'),
                                                 (6, 'Healthcare and Medical'),
                                                 (7, 'Education and Teaching'),
                                                 (8, 'Engineering and Technology'),
                                                 (9, 'Creative Arts and Design'),
                                                 (10, 'Customer Service and Support');
SELECT SETVAL('tag_seq',10);


SELECT SETVAL('role_seq',3);

--- insert states
INSERT INTO state (id, name)
VALUES
(1, 'Alabama'),
(2, 'Alaska'),
(3, 'Arizona'),
(4, 'Arkansas'),
(5, 'California'),
(6, 'Colorado'),
(7, 'Connecticut'),
(8, 'Delaware'),
(9, 'Florida'),
(10, 'Georgia'),
(11, 'Hawaii'),
(12, 'Idaho'),
(13, 'Illinois'),
(14, 'Indiana'),
(15, 'Iowa'),
(16, 'Kansas'),
(17, 'Kentucky'),
(18, 'Louisiana'),
(19, 'Maine'),
(20, 'Maryland'),
(21, 'Massachusetts'),
(22, 'Michigan'),
(23, 'Minnesota'),
(24, 'Mississippi'),
(25, 'Missouri'),
(26, 'Montana'),
(27, 'Nebraska'),
(28, 'Nevada'),
(29, 'New Hampshire'),
(30, 'New Jersey'),
(31, 'New Mexico'),
(32, 'New York'),
(33, 'North Carolina'),
(34, 'North Dakota'),
(35, 'Ohio'),
(36, 'Oklahoma'),
(37, 'Oregon'),
(38, 'Pennsylvania'),
(39, 'Rhode Island'),
(40, 'South Carolina'),
(41, 'South Dakota'),
(42, 'Tennessee'),
(43, 'Texas'),
(44, 'Utah'),
(45, 'Vermont'),
(46, 'Virginia'),
(47, 'Washington'),
(48, 'West Virginia'),
(49, 'Wisconsin'),
(50, 'Wyoming');

SELECT SETVAL('state_seq',3);




-- cities
INSERT INTO city (id, state_id, name)
VALUES
(1, 1, 'Birmingham'),
(2, 1, 'Montgomery'),
(3, 1, 'Huntsville'),
(4, 1, 'Mobile'),
(5, 1, 'Tuscaloosa'),
(6, 2, 'Juneau'),
(7, 2, 'Anchorage'),
(8, 2, 'Fairbanks'),
(9, 2, 'Wasilla'),
(10, 2, 'Sitka'),
(11, 3, 'Phoenix'),
(12, 3, 'Tucson'),
(13, 3, 'Mesa'),
(14, 3, 'Chandler'),
(15, 3, 'Glendale'),
(16, 4, 'Little Rock'),
(17, 4, 'Fort Smith'),
(18, 4, 'Fayetteville'),
(19, 4, 'Springdale'),
(20, 4, 'Jonesboro'),
(21, 5, 'Sacramento'),
(22, 5, 'Los Angeles'),
(23, 5, 'San Diego'),
(24, 5, 'San Jose'),
(25, 5, 'Fresno'),
(26, 6, 'Denver'),
(27, 6, 'Colorado Springs'),
(28, 6, 'Aurora'),
(29, 6, 'Fort Collins'),
(30, 6, 'Pueblo'),
(31, 7, 'Hartford'),
(32, 7, 'Bridgeport'),
(33, 7, 'New Haven'),
(34, 7, 'Stamford'),
(35, 7, 'Waterbury'),
(36, 8, 'Tallahassee'),
(37, 8, 'Jacksonville'),
(38, 8, 'Miami'),
(39, 8, 'Orlando'),
(40, 8, 'Fort Lauderdale'),
(41, 9, 'Atlanta'),
(42, 9, 'Augusta'),
(43, 9, 'Columbus'),
(44, 9, 'Savannah'),
(45, 9, 'Macon'),
(46, 10, 'Honolulu'),
(47, 10, 'Pearl City'),
(48, 10, 'Hilo'),
(49, 10, 'Kailua'),
(50, 10, 'Waipahu'),
(51, 11, 'Boise'),
(52, 11, 'Nampa'),
(53, 11, 'Meridian'),
(54, 11, 'Idaho Falls'),
(55, 11, 'Pocatello'),
(56, 12, 'Springfield'),
(57, 12, 'Chicago'),
(58, 12, 'Aurora'),
(59, 12, 'Joliet'),
(60, 12, 'Naperville'),
(61, 13, 'Indianapolis'),
(62, 13, 'Fort Wayne'),
(63, 13, 'South Bend'),
(64, 13, 'Evansville'),
(65, 13, 'Carmel'),
(66, 14, 'Topeka'),
(67, 14, 'Wichita'),
(68, 14, 'Overland Park'),
(69, 14, 'Lawrence'),
(70, 14, 'Olathe'),
(71, 15, 'Louisville'),
(72, 15, 'Lexington'),
(73, 15, 'Bowling Green'),
(74, 15, 'Owensboro'),
(75, 15, 'Covington'),
(76, 16, 'Concord'),
(77, 16, 'Manchester'),
(78, 16, 'Nashua'),
(79, 16, 'Dover'),
(80, 16, 'Rochester'),
(81, 17, 'Augusta'),
(82, 17, 'Portland'),
(83, 17, 'Lewiston'),
(84, 17, 'Bangor'),
(85, 17, 'Waterville'),
(86, 18, 'Hartford'),
(87, 18, 'Bridgeport'),
(88, 18, 'New Haven'),
(89, 18, 'Stamford'),
(90, 18, 'Waterbury'),
(91, 19, 'Dover'),
(92, 19, 'Wilmington'),
(93, 19, 'Newark'),
(94, 19, 'Portsmouth'),
(95, 19, 'Milford'),
(96, 20, 'Columbus'),
(97, 20, 'Cleveland'),
(98, 20, 'Cincinnati'),
(99, 20, 'Toledo'),
(100, 20, 'Akron'),
(101, 21, 'Dover'),
(102, 21, 'Wilmington'),
(103, 21, 'Newark'),
(104, 21, 'Portsmouth'),
(105, 21, 'Milford'),
(106, 22, 'Raleigh'),
(107, 22, 'Charlotte'),
(108, 22, 'Greensboro'),
(109, 22, 'Winston-Salem'),
(110, 22, 'Durham'),
(111, 23, 'Pierre'),
(112, 23, 'Rapid City'),
(113, 23, 'Sioux Falls'),
(114, 23, 'Aberdeen'),
(115, 23, 'Watertown'),
(116, 24, 'Hartford'),
(117, 24, 'Bridgeport'),
(118, 24, 'New Haven'),
(119, 24, 'Stamford'),
(120, 24, 'Waterbury'),
(121, 25, 'Montpelier'),
(122, 25, 'Burlington'),
(123, 25, 'Rutland'),
(124, 25, 'Brattleboro'),
(125, 25, 'Winooski'),
(126, 26, 'Charleston'),
(127, 26, 'Huntington'),
(128, 26, 'Parkersburg'),
(129, 26, 'Morgantown'),
(130, 26, 'Wheeling'),
(131, 27, 'Columbus'),
(132, 27, 'Cleveland'),
(133, 27, 'Cincinnati'),
(134, 27, 'Toledo'),
(135, 27, 'Akron'),
(136, 28, 'Oklahoma City'),
(137, 28, 'Tulsa'),
(138, 28, 'Lawton'),
(139, 28, 'Enid'),
(140, 28, 'Stillwater'),
(141, 29, 'Salem'),
(142, 29, 'Portland'),
(143, 29, 'Eugene'),
(144, 29, 'Bend'),
(145, 29, 'Medford'),
(146, 30, 'Harrisburg'),
(147, 30, 'Pittsburgh'),
(148, 30, 'Philadelphia'),
(149, 30, 'Allentown'),
(150, 30, 'Erie'),
(151, 31, 'Providence'),
(152, 31, 'Warwick'),
(153, 31, 'Cranston'),
(154, 31, 'Pawtucket'),
(155, 31, 'Newport'),
(156, 32,  'Montpelier'),
(157, 32,  'Burlington'),
(158, 32,  'Rutland'),
(159, 32,  'Brattleboro'),
(160, 32,  'Winooski'),
(161, 33, 'Richmond'),
(162, 33, 'Virginia Beach'),
(163, 33, 'Norfolk'),
(164, 33, 'Chesapeake'),
(165, 33, 'Hampton'),
(166, 34,  'Olympia'),
(167, 34,  'Tacoma'),
(168, 34,  'Seattle'),
(169, 34,  'Everett'),
(170, 34,  'Spokane'),
(171, 35,  'Charleston'),
(172, 35,  'Huntington'),
(173, 35,  'Parkersburg'),
(174, 35,  'Morgantown'),
(175, 35,  'Wheeling'),
(176, 36,  'Madison'),
(177, 36,  'Milwaukee'),
(178, 36,  'Green Bay'),
(179, 36,  'Kenosha'),
(180, 36,  'Racine'),
(181, 37,  'Little Rock'),
(182, 37,  'Fort Smith'),
(183, 37,  'Fayetteville'),
(184, 37,  'Springdale'),
(185, 37,  'Jonesboro'),
(186, 38,  'Sacramento'),
(187, 38,  'Los Angeles'),
(188, 38,  'San Diego'),
(189, 38,  'San Jose'),
(190, 38,  'Fresno'),
(191, 39,  'Denver'),
(192, 39,  'Colorado Springs'),
(193, 39,  'Aurora'),
(194, 39,  'Fort Collins'),
(195, 39,  'Pueblo'),
(196, 40,  'Hartford'),
(197, 40,  'Bridgeport'),
(198, 40,  'New Haven'),
(199, 40,  'Stamford'),
(200, 40,  'Waterbury'),
(201, 41,  'Honolulu'),
(202, 41,  'Pearl City'),
(203, 41,  'Hilo'),
(204, 41,  'Kailua'),
(205, 41,  'Waipahu'),
(206, 42,  'Montpelier'),
(207, 42,  'Burlington'),
(208, 42,  'Rutland'),
(209, 42,  'Brattleboro'),
(210, 42,  'Winooski'),
(211, 43,  'Cheyenne'),
(212, 43,  'Casper'),
(213, 43,  'Laramie'),
(214, 43,  'Rock Springs'),
(215, 43,  'Green River'),
(216, 44,  'Raleigh'),
(217, 44,  'Charlotte'),
(218, 44,  'Greensboro'),
(219, 44,  'Winston-Salem'),
(220, 44,  'Durham'),
(221, 45,  'Pierre'),
(222, 45,  'Rapid City'),
(223, 45,  'Sioux Falls'),
(224, 45,  'Aberdeen'),
(225, 45,  'Watertown'),
(226, 46,  'Frankfort'),
(227, 46,  'Louisville'),
(228, 46,  'Lexington'),
(229, 46,  'Bowling Green'),
(230, 46,  'Owensboro'),
(231, 47,  'Augusta'),
(232, 47,  'Portland'),
(233, 47,  'Lewiston'),
(234, 47,  'Bangor'),
(235, 47,  'Waterville'),
(236, 48,  'Hartford'),
(237, 48,  'Bridgeport'),
(238, 48,  'New Haven'),
(239, 48,  'Stamford'),
(240, 48,  'Waterbury'),
(241, 49,  'Dover'),
(242, 49,  'Wilmington'),
(243, 49,  'Newark'),
(244, 49,  'Portsmouth'),
(245, 49,  'Milford'),
(246, 50,  'Columbus'),
(247, 50,  'Cleveland'),
(248, 50,  'Cincinnati'),
(249, 50,  'Toledo'),
(250, 50,  'Akron');

INSERT INTO tag (value, id) VALUES ('Information Technology (IT)', 1);
INSERT INTO tag (value, id) VALUES ('Marketing and Advertising', 2);
INSERT INTO tag (value, id) VALUES ('Finance and Accounting', 3);
INSERT INTO tag (value, id) VALUES ('Sales and Business Development', 4);
INSERT INTO tag (value, id) VALUES ('Human Resources (HR)', 5);
INSERT INTO tag (value, id) VALUES ('Healthcare and Medical', 6);
INSERT INTO tag (value, id) VALUES ('Education and Teaching', 7);
INSERT INTO tag (value, id) VALUES ('Engineering and Technology', 8);
INSERT INTO tag (value, id) VALUES ('Creative Arts and Design', 9);
INSERT INTO tag (value, id) VALUES ('Customer Service and Support', 10);

