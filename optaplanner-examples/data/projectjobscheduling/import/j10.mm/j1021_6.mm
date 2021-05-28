************************************************************************
file with basedata            : mm21_.bas
initial value random generator: 937650945
************************************************************************
projects                      :  1
jobs (incl. supersource/sink ):  12
horizon                       :  78
RESOURCES
  - renewable                 :  2   R
  - nonrenewable              :  2   N
  - doubly constrained        :  0   D
************************************************************************
PROJECT INFORMATION:
pronr.  #jobs rel.date duedate tardcost  MPM-Time
    1     10      0       14        4       14
************************************************************************
PRECEDENCE RELATIONS:
jobnr.    #modes  #successors   successors
   1        1          3           2   3   4
   2        3          1           5
   3        3          2           8  10
   4        3          3           9  10  11
   5        3          2           6   9
   6        3          2           7  10
   7        3          1           8
   8        3          1          11
   9        3          1          12
  10        3          1          12
  11        3          1          12
  12        1          0        
************************************************************************
REQUESTS/DURATIONS:
jobnr. mode duration  R 1  R 2  N 1  N 2
------------------------------------------------------------------------
  1      1     0       0    0    0    0
  2      1     2       0    4    8    3
         2     3       0    3    6    3
         3     9       8    0    5    3
  3      1     1       0    2    8    9
         2     2       0    2    7    8
         3     2       8    0    8    9
  4      1     3       0    8    7    7
         2     6       0    6    6    5
         3     9       4    0    3    4
  5      1     2       9    0    6    4
         2     5       0    7    5    4
         3     8       0    4    4    2
  6      1     3       5    0    9    9
         2     6       0    8    9    6
         3     6       3    0    9    6
  7      1     1       6    0    6    4
         2     6       0    9    3    4
         3    10       5    0    2    4
  8      1     2       0    6    7    8
         2     2       0    6    5    9
         3     6       0    3    5    4
  9      1     1       9    0    4    8
         2     4       9    0    3    8
         3    10       8    0    3    7
 10      1     4       0    9    9    6
         2     6       4    0    8    5
         3     9       0    9    5    4
 11      1     4       4    0    8    5
         2     6       2    0    7    5
         3     9       0   10    6    5
 12      1     0       0    0    0    0
************************************************************************
RESOURCEAVAILABILITIES:
  R 1  R 2  N 1  N 2
   16   13   54   50
************************************************************************
