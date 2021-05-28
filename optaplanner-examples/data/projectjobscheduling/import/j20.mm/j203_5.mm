************************************************************************
file with basedata            : md323_.bas
initial value random generator: 977920114
************************************************************************
projects                      :  1
jobs (incl. supersource/sink ):  22
horizon                       :  161
RESOURCES
  - renewable                 :  2   R
  - nonrenewable              :  2   N
  - doubly constrained        :  0   D
************************************************************************
PROJECT INFORMATION:
pronr.  #jobs rel.date duedate tardcost  MPM-Time
    1     20      0       13       16       13
************************************************************************
PRECEDENCE RELATIONS:
jobnr.    #modes  #successors   successors
   1        1          3           2   3   4
   2        3          3           7  11  17
   3        3          3           6   9  13
   4        3          3           5   9  19
   5        3          3           6  10  16
   6        3          2          12  18
   7        3          2           8  14
   8        3          1          18
   9        3          3          12  14  15
  10        3          2          11  15
  11        3          2          12  21
  12        3          1          20
  13        3          2          16  17
  14        3          1          16
  15        3          2          18  21
  16        3          2          20  21
  17        3          1          19
  18        3          1          20
  19        3          1          22
  20        3          1          22
  21        3          1          22
  22        1          0        
************************************************************************
REQUESTS/DURATIONS:
jobnr. mode duration  R 1  R 2  N 1  N 2
------------------------------------------------------------------------
  1      1     0       0    0    0    0
  2      1     4       2    0    9    0
         2     4       0    9    9    0
         3     7       0    7    9    0
  3      1     1       4    0    0    8
         2     3       0    2    0    6
         3     8       2    0    0    4
  4      1     2       0    5    9    0
         2     2       0    5    0    9
         3     5       6    0    0    4
  5      1     2       0    7    0    8
         2     6      10    0    0    6
         3     8       0    2    0    5
  6      1     1       0    4    8    0
         2     3       0    4    0    6
         3    10       0    4    0    4
  7      1     1       0    9    0    6
         2     2       0    6    0    4
         3     5       0    5    0    3
  8      1     5       9    0    0    6
         2     7       0    3    5    0
         3     9       0    3    4    0
  9      1     5       0    9    0    3
         2     7       3    0    0    2
         3     9       0    8    8    0
 10      1     2       0   10    8    0
         2     6       7    0    0    5
         3    10       0    8    0    5
 11      1     1       6    0    2    0
         2     9       5    0    1    0
         3    10       5    0    0    7
 12      1     1       0    9    6    0
         2     6       3    0    6    0
         3     8       0    7    2    0
 13      1     1       0    4    0    4
         2     3       0    3    7    0
         3     7       3    0    0    4
 14      1     1       0    7    0    9
         2     5       1    0    0    7
         3     7       0    4    1    0
 15      1     1       7    0    0    7
         2     2       7    0    8    0
         3     8       4    0    5    0
 16      1     1       7    0    5    0
         2     2       7    0    0    2
         3     7       3    0    0    2
 17      1     1       0    6    8    0
         2     4       6    0    6    0
         3    10       4    0    3    0
 18      1     1       0    5    0    7
         2     2       0    4    0    2
         3     8       0    3    8    0
 19      1     1       0    5    0    3
         2     1       3    0    6    0
         3     8       0    5    6    0
 20      1     2       0    6    0   10
         2     4       8    0    0    6
         3     7       0    4    0    4
 21      1     1       3    0    0    8
         2     7       3    0    0    4
         3    10       3    0    0    2
 22      1     0       0    0    0    0
************************************************************************
RESOURCEAVAILABILITIES:
  R 1  R 2  N 1  N 2
   22   30   35   41
************************************************************************
