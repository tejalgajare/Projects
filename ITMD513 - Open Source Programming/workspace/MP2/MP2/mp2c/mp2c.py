'''
Created on Jun 20, 2013

@author: tejalgajare
'''
from mp2b.mp2b import Task  #import the Task class from mp2b package
from Queue import PriorityQueue #import the PriorityQueue class

#Create Task objects...  
t1=Task('','Task1')
t2=Task('','Task2')
t3=Task('','Task3')

t1_description=getattr(t1,'description')
t2_description=getattr(t2,'description')
t3_description=getattr(t3,'description')

#Create a PriorityQueue() object...
pq = PriorityQueue()

# Load queue with the necessary data...
print "Adding Tasks to Priority Queue:"
print "----------------------------------------------------------"

#Add the objects to the queue object by invoking the put() function => priority value,task_description,task time-stamp

pq.put((3,t2_description,getattr(t2,'timestamp')))
pq.put((1,t1_description,getattr(t1,'timestamp')))
pq.put((0,t3_description,getattr(t3,'timestamp')))

#printing the queue according to priority level
print "Current Status of the Priority Queue after removing task objects based on their priority: "

while not pq.empty(): 

    print pq.get()
    
