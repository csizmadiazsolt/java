# 03-QuickSort

## Description
```
Implement the quick sort algorithm: https://en.wikipedia.org/wiki/Quicksort

How to use it:

$ java -jar quick_sort.jar "1 6 8 2 3 3 7 8"
1 2 3 3 6 7 8 8
$

The app should return an error message if the list contains a letter or a punctuation mark.
```
## Usage
```
$ java -jar QuickSort.jar "1 6 8 2 3 3 7 8"
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
1 2 3 3 6 7 8 8
```