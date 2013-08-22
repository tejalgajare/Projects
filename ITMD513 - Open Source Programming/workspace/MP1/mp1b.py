'''
Created on Jun 15, 2013

@author: tejalgajare
'''

import random
import math

# Created 3 Lists of 100 Random Coordinates for x, y, z with range 250 to -250...

xL = [random.randint(-250, 250) for i in range(0, 100)]
yL = [random.randint(-250, 250) for i in range(0, 100)]
zL = [random.randint(-250, 250) for i in range(0, 100)]

threeSpace = zip(xL, yL, zL)

# Lists of tuples sorted in ascending order...

xSortedSpace = sorted(threeSpace, key=lambda coordinate: coordinate[0])
ySortedSpace = sorted(threeSpace, key=lambda coordinate: coordinate[1])
zSortedSpace = sorted(threeSpace, key=lambda coordinate: coordinate[2])

# Stored sorted list in a dictionary...
sortedDict = {"xSorted": xSortedSpace, "ySorted": ySortedSpace, "zSorted": zSortedSpace}

# Using Distance Formula...
def distanceFromOrigin(point):
    d = math.sqrt((point[0] ** 2) + (point[1] ** 2) + (point[2] ** 2))
    return d

threeSpace.sort(key=distanceFromOrigin)
minCoord = threeSpace[0]
maxCoord = threeSpace[len(threeSpace) - 1]

print "X Coordinates:"
print "----------------------------------------------------------"
print sortedDict['xSorted'], "\n"
print "Y Coordinates:"
print "----------------------------------------------------------"
print sortedDict['ySorted'], "\n"
print "Z Coordinates:"
print "----------------------------------------------------------"
print sortedDict['zSorted'], "\n"
print "Coordinates from the Origin:"
print "----------------------------------------------------------"
print "Coordinate closest to the origin:", minCoord
print "Coordinate farthest from the origin:", maxCoord, "\n"