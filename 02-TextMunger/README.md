# 02-TextMunger

## Description
```
Solve the text munger kata: http://rubyquiz.com/quiz76.html

How to use the application:

$ java -jar text_munger.jar "some text for example"
smoe txet for elpmaxe
$

Do not bother with '" in the texts, but consider the punctuation marks!
```
## Usage
```
$ java -jar TextMunger.jar "some text for example"
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
smoe txet for elpmaxe
```