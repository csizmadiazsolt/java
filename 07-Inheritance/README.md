# 07-Inheritance

## Usage
```
$ java -jar Inheritance.jar
```
## How to build
To build and execute checks use the following command
```
$ gradle check
```
To create an executable jar-file into the root directory of the project use the following command
```
$ gradle jar
```
### Expected output
```
Manpower costs: #
CEO tells the vision.
Manager-0 tells the direction.
.
. where max = 10
.
Manager-m tells the direction.
Secretary-0 orders stuff.
.
. where s max = 2
.
Secretary-s orders stuff.
Java Developer-0 develops JAVA.
.
. where j max = 4
.
Java Developer-j develops JAVA.
CPP Developer-0 develops C++.
.
. where c max = 5
.
CPP Developer-c develops C++.
Java Developer-0 <-- CEO
.
.
.
Java Developer-j <-- Manager-#
CPP Developer-0 <-- CEO
.
.
.
CPP Developer-c <-- Manager-#

```