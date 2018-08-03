DROP TABLE leave_table;
CREATE TABLE leave_table (
	id INT(10) PRIMARY KEY AUTO_INCREMENT,
	uid VARCHAR(20) NOT NULL,
	uname VARCHAR(20) NOT NULL,
	upost VARCHAR(50) NOT NULL,
	usys VARCHAR(50) NOT NULL,
	leavetype VARCHAR(10) NOT NULL,
	reason VARCHAR(50) NOT NULL,
	leavetime VARCHAR(50)NULL,
	backtime VARCHAR(50)NULL,
	leavedays VARCHAR(20) NOT NULL,
	state VARCHAR(10) NULL,
	processInstance VARCHAR(10),
	createtime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
);
SELECT * FROM leave_table;

SELECT * FROM leave_table WHERE leavetype = "年假" AND reason LIKE "%第%";