# 08-DependencyInjection

## Description
```
Take your text munger application, and separate the println logic and transformation logic into a separate class, and use dependency injection to "put" your classes and objects together. Moreover you may want to consider to mock out the random generator as well.

* update your test structure accordingly
* use mocks - mockito
* do not use any DI framework
```
## Usage
```
$ java -jar DependencyInjection.jar "some text for example"
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