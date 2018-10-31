/*Table structure for table account */
DROP TABLE account;

CREATE TABLE account (
  accountid int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  name varchar(255) NOT NULL,
  balance int NOT NULL,
  pin int NOT NULL,
  PRIMARY KEY (accountid)
);
/*Data for the table account */
INSERT INTO account ("NAME", BALANCE, PIN)  VALUES ('tubtim',10,1),('pla',10,2);



/*Table structure for table history */
DROP TABLE history;

CREATE TABLE history (
  historyid int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  accountid int NOT NULL,
  method varchar(45) NOT NULL,
  amount int NOT NULL,
  time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  balance int NOT NULL,
  PRIMARY KEY (historyid),
  CONSTRAINT accountid_history FOREIGN KEY (accountid) REFERENCES account (accountid) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;

/*Data for the table history */
INSERT INTO history (ACCOUNTID, "METHOD", AMOUNT, "TIME", BALANCE)  VALUES (1,'deposit',50000,'2018-07-15 01:00:01',60000);