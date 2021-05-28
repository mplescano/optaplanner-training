************************************************************************
file with basedata            : mm37_.bas
initial value random generator: 642775701
************************************************************************
projects                      :  1
jobs (incl. supersource/sink ):  12
horizon                       :  85
RESOURCES
  - renewable                 :  2   R
  - nonrenewable              :  2   N
  - doubly constrained        :  0   D
************************************************************************
PROJECT INFORMATION:
pronr.  #jobs rel.date duedate tardcost  MPM-Time
    1     10      0       11        6       11
************************************************************************
PRECEDENCE RELATIONS:
jobnr.    #modes  #successors   successors
   1        1          3           2   3   4
   2        3          3           5   6   7
   3        3          1           8
   4        3          1           9
   5        3          1           9
   6        3          2          10  11
   7        3          1          11
   8        3          3           9  10  11
   9        3          1          12
  10        3          1          12
  11        3          1          12
  12        1          0        
************************************************************************
REQUESTS/DURATIONS:
jobnr. mode duration  R 1  R 2  N 1  N 2
------------------------------------------------------------------------
  1      1     0       0    0    0    0
  2      1     3       6    7    8    4
         2     5       6    3    8    1
         3     5       5    2    8    4
  3      1     6       4    8   10    5
         2     7       3    8    9    4
         3     9       1    7    9    3
  4      1     1      10    6    4    9
         2     1       8    6    4   10
         3     9       7    4    4    8
  5      1     1       9   10    5    5
         2     7       5    9    4    5
         3     9       5    9    4    4
  6      1     2       4    3   10    9
         2     3       3    2    7    9
         3     4       2    2    6    8
  7      1     3       7    7    9    9
         2     4       7    4    8    7
         3     9       4    4    6    2
  8      1     1       7    6    6    8
         2     3       6    5    6    8
         3    10       1    5    6    6
  9      1     4       7   10    4    4
         2     8       5    8    3    3
         3    10       4    5    2    3
 10      1     2       8    6    4    7
         2     9       5    6    2    5
         3    10       4    5    1    4
 11      1     4       5    5    8    7
         2     7       5    4    7    7
         3    10       4    3    5    6
 12      1     0       0    0    0    0
************************************************************************
RESOURCEAVAILABILITIES:
  R 1  R 2  N 1  N 2
   10   13   54   50
************************************************************************
