'''
Created on Jul 14, 2013

@author: tejalgajare
'''

import datetime,time

#Create a class Task having three attributes: task_id,time_stamp and description...
class Task:
    
    task_id=0
    time_stamp=''
    description=''
    
    def __init__(self,timestamp ,description):     #Define a __init__ method for object creation (constructor)
        
        Task.task_id += 1                           #task_id is the unique task ID given to each newly created task object
        self.timestamp = str(datetime.datetime.now()) 
        self.description=description

    # Define get,put and list_all functions
    @staticmethod               #declare static method
    def get(list1):
    
        t=list1[0]              #get the first element from the list1 
        del list1[0]            #delete the retrieved element
        return t
    
    @staticmethod
    def put(list1, task):
    
        d=task[task.keys()[0]]          #Had these variables declared for printing on the console
        priorityLevel=task.keys()[0]
        list1.append(task)              #append the task to the existing list (queue)
        list1.sort(key=lambda pk: pk.keys()[0], reverse=False)      #after appending , sort the queue
        

    @staticmethod
    def list_all(list1):
    
        return list1                    #return the list for display
            
    @staticmethod      
    def displayTask(self):
        print "ID : ", Task.task_id,  ", Timestamp: ", self.timestamp,", Description: ",self.description
    