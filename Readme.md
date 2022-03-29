# Java Practicals

MCA 1 (2021-22)

---

#### Practical - 1 ✅

#### Practical - 2 ✅

#### Practical - 3 ✅

#### Practical - 4 ✅

#### Practical - 5 ✅

#### Practical - 6 ✅

#### Practical - 7 ✅

#### Practical - 8 ✅

#### Practical - 9 ✅

#### Practical - 10 ✅

#### Practical - 11 ✅

#### Practical - 12 ✅

#### Practical - 13 ✅

#### Practical - 14 ✅

#### Practical - 15 👨‍💻

#### Practical - 16

#### Practical - 17

#### Practical - 18

#### Practical - 19

#### Practical - 20

#### Practical - 21

#### Practical - 22

#### Practical - 23

#### Practical - 24

#### Practical - 25

---

Run java code with JDBC

```
javac Driver.java && java -cp "../lib/mysql-connector.jar;" Driver
```

---

Create Stored Procedure

```
DELIMITER //

CREATE PROCEDURE getTotalEmployees(OUT TOTAL_EMPLOYEES INT)
BEGIN
	SELECT COUNT(id) INTO TOTAL_EMPLOYEES FROM employees;
END //

DELIMITER ;
```
