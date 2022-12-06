# Probabilistic-Model

Once upon a time there lived a baby ghost named Casper. He was very adorable, playful and
surprisingly friendly towards humans. One day he was flying over a city when he noticed a
group of small children playing hide and seek in an abandoned warehouse. He too wanted to
play with them. But when he was descending he broke a tree branch that scared off the
children. Feeling disheartened he started roaming in the warehouse. He went to one room
from another and saw stockpiles of different goods creating obstacles in his movement. To
make things worse, he got lost in one such room. He was roaming around in the room but
could not find a way out. Feeling afraid, he started crying. Now, you thought of helping him
by escorting outside. But you need to locate him since he is invisible to humans. You went to
the room where Casper got lost, with a ghost sensor. The details of the sensor is described
later. Your job is to find Casper and help him get his way back.

###Environment Description

Assume the room is an n X m grid with k obstacles. You should take n, m, k and the positions
of k obstacles as input. Initially, every empty cell (i.e., without any obstacle) of the grid is
equally likely for Casper to be in. He can move to any adjacent cell (that shares an edge or a
corner) or stay in the same cell at any particular time unit. But it is more likely that he moves
to a cell that shares an edge with previous cell (e.g. say this cumulative probability is P=0.9)
and moving to any of these options is equally likely. The same is true for the remaining cells
for a cumulative probability of 1-P. Note that, you may have to calculate the exact values
probability of moving from one cell to another based on the obstacles in the adjacent cells.

##Ghost Sensor Specification

The ghost sensor is a sophisticated device. When it is placed in a grid cell, it can detect if
Casper is in the same cell or in any adjacent cell (sharing an edge or corner) by blinking a red
light (although it cannot pinpoint his location). However, the sensor may sometimes show
false reading, but you can assume its reading is mostly correct (say 85% times on average).
At each time step, you can only take sensor reading at exactly one grid cell. Please note,
presence of obstacles does not impact the ghost sensing capability of the sensor.
##Task

I had to model the aforementioned problem using HMM. At each time step, I
showed the probability of Casper being in a cell for every grid cell both before and after I
detected his presence in a cell with the sensor.
