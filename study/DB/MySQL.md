
# install mysql
```
$ sudo apt install mysql-server
$ sudo service mysql start
```
on Mac
```
$ brew install mysql 
$ brew services start mysql

```
# how to set localhost account information
```
// refer the 'config/DBOption.json' for id and password
$ mysql -u ${ID} -p
Enter password: 
mysql> alter user '${ID}'@'[%|localhost]' identified with mysql_native_password by '${PASSWORD}';
```

## mysql cli

# simple mysql cli

* use ${DB_NAME};  
select the database as current context.
```
mysql> use db;
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
```
* show tables;  
display the table list of the database.
```
mysql> show tables;
+-----------------------------+
| Tables_in_ilps_gw_migration |
+-----------------------------+
| table_1                     |
| table_2                     |
| table_3                     |
+-----------------------------+
5 rows in set (0.00 sec)
```
* desc ${DB_TABLE_NAME}  
display the details of columns
```
mysql> desc table_name;
+-------------------+-------------+------+-----+---------+-------+
| Field             | Type        | Null | Key | Default | Extra |
+-------------------+-------------+------+-----+---------+-------+
| column1           | varchar(6)  | NO   | PRI | NULL    |       |
| column2           | varchar(20) | NO   | PRI | NULL    |       |
| column3           | blob        | NO   |     | NULL    |       |
+-------------------+-------------+------+-----+---------+-------+
16 rows in set (0.00 sec)
```

## 출처
https://changun516.tistory.com/55 [하루의 쉼터]
