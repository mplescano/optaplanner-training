************************************************************************
file with basedata            : mf41_.bas
initial value random generator: 930843763
************************************************************************
projects                      :  1
jobs (incl. supersource/sink ):  32
horizon                       :  233
RESOURCES
  - renewable                 :  2   R
  - nonrenewable              :  2   N
  - doubly constrained        :  0   D
************************************************************************
PROJECT INFORMATION:
pronr.  #jobs rel.date duedate tardcost  MPM-Time
    1     30      0       30       13       30
************************************************************************
PRECEDENCE RELATIONS:
jobnr.    #modes  #successors   successors
   1        1          3           2   3   4
   2        3          2           6  25
   3        3          1           5
   4        3          3          13  17  24
   5        3          3           7   9  18
   6        3          2          10  30
   7        3          2           8  11
   8        3          3          15  22  25
   9        3          3          20  21  26
  10        3          3          12  18  19
  11        3          1          26
  12        3          2          16  17
  13        3          3          14  15  20
  14        3          3          22  27  28
  15        3          2          21  28
  16        3          3          21  22  24
  17        3          1          23
  18        3          2          23  24
  19        3          1          29
  20        3          1          25
  21        3          1          31
  22        3          2          23  29
  23        3          1          31
  24        3          1          27
  25        3          2          29  30
  26        3          2          27  28
  27        3          1          31
  28        3          1          30
  29        3          1          32
  30        3          1          32
  31        3          1          32
  32        1          0        
************************************************************************
REQUESTS/DURATIONS:
jobnr. mode duration  R 1  R 2  N 1  N 2
------------------------------------------------------------------------
  1      1     0       0    0    0    0
  2      1     6       0    5    8    8
         2     7       7    0    8    4
         3     7       0    4    7    5
  3      1     4       0    9    2    5
         2     5       9    0    2    4
         3     7       9    0    1    3
  4      1     3       7    0    6    9
         2     3       0    6    7    9
         3     7       0    5    6    9
  5      1     5       0    6    9   10
         2     9       0    5    8    7
         3     9       5    0    9    5
  6      1     2       0    7    7    9
         2     5       9    0    6    6
         3    10       8    0    6    4
  7      1     6       7    0    5   10
         2     6       0   10    5    8
         3     8       7    0    3    8
  8      1     3       8    0   10    6
         2     5       0    7    6    6
         3     6       5    0    5    3
  9      1     2       0    3    6    2
         2     2      10    0   10    4
         3     2       0    5    5    3
 10      1     1       0   10    8    2
         2     8       0    9    7    1
         3     9       0    7    6    1
 11      1     4       0    8    5   10
         2     8       0    6    5    8
         3     9       2    0    5    6
 12      1     1       4    0    5    3
         2     7       3    0    3    3
         3     8       0    2    3    2
 13      1     6       6    0    9    8
         2     8       6    0    9    7
         3     9       5    0    9    5
 14      1     1       7    0    7    5
         2     6       0    1    7    4
         3     7       4    0    5    4
 15      1     6       0    6    6    5
         2     7       7    0    5    4
         3     9       0    6    3    4
 16      1     3       0    5    4    6
         2     3       3    0    4    6
         3     5       2    0    4    6
 17      1     3       0    8    2   10
         2     7       0    7    2    7
         3     9       0    3    1    3
 18      1     4       2    0    8   10
         2     6       2    0    3   10
         3     7       0    8    2    9
 19      1     2       6    0    4   10
         2     5       0    6    4   10
         3     9       0    4    4   10
 20      1     6       8    0   10    8
         2     9       8    0   10    7
         3    10       8    0   10    6
 21      1     1       0    8    8    5
         2     3       5    0    8    3
         3     4       0    8    8    2
 22      1     1       6    0   10    9
         2     1       0    8    9    9
         3     4       0    6    9    7
 23      1     4       0    6   10    3
         2     5       0    5    5    3
         3    10       0    5    4    3
 24      1     2       0    7    6    7
         2     3       0    4    5    6
         3     9       0    4    4    5
 25      1     1       6    0    3    6
         2     1       0    6    3    6
         3     5       0    5    3    6
 26      1     3       0    6    7    6
         2    10       8    0    5    5
         3    10       9    0    3    4
 27      1     2       9    0    7    6
         2     3       6    0    4    5
         3     8       0    7    1    5
 28      1     3       0    6    6    3
         2    10       2    0    2    3
         3    10       0    5    2    3
 29      1     6      10    0    6    5
         2     7       8    0    6    5
         3     9       6    0    3    2
 30      1     3       0    5    2    9
         2     4       4    0    2    6
         3     8       0    4    2    4
 31      1     2       7    0    3    9
         2     7       5    0    3    7
         3     9       0    7    2    6
 32      1     0       0    0    0    0
************************************************************************
RESOURCEAVAILABILITIES:
  R 1  R 2  N 1  N 2
   13   14  164  174
************************************************************************
