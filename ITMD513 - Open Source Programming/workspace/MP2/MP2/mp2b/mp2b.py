'''
Created on Jun 20, 2013

@author: tejalgajare
'''

import datetime,time

#Create a class Task having three attributes: task_id,time_stamp and description...
class Task:
    
    task_id=0
    time_stamp=''
    description=''
    
    def __init__(self, timestamp ,description):     #Define a __init__ method for object creation (constructor)
        
        Task.task_id += 1                           #task_id is the unique task ID given to each newly created task object
        self.timestamp = str(datetime.datetime.now()) 
        self.description=description

    # Define get,put and list_all functions
    def get(self,list1):
    
        t = list1.pop(0)
        print "Removed a task from the queue: %s with priority %s" % (t[t.keys()[0]],t.keys()[0])
        return t

    def put(self,list1, task):
    
        d=task[task.keys()[0]]
        priorityLevel=task.keys()[0]
        list1.append(task)
        list1.sort(key=lambda pk: pk.keys()[0], reverse=False)
        print "Added a task to the queue: %s with priority %s" % (d,priorityLevel)

    def list_all(self,list1):
    
        print "Current State of the Priority Queue:"
        print "----------------------------------------------------------"
        print "Number of items in queue: %s" % len(queue)
        for i in queue:
            print i 
            
    def displayTask(self):
        print "ID : ", Task.task_id,  ", Timestamp: ", self.timestamp,", Description: ",self.description
    
# Create priority queue as a List, Declare a variable 't' for time-stamp and define a task_dict object 
if __name__ == '__main__':      #This condition is written in order to execute this program only when it is directly run.If imported it will not execute the entire program
        
    t=''
    queue = []
    t1 = Task(t, "ITunes")      #Create task objects by entering the time-stamp and description
    t2 = Task(t,"Safari")
    t3 = Task(t,"Chrome")
    t4 = Task(t,"Unix")
    
    task_dict= {'2':[t1,t2] ,'0':[t3,t4]}   #This represents the priority queue format..{priority value:[task object]...}
    
    # Add the elements to queue...
    print "Adding Tasks to Priority Queue:"
    print "----------------------------------------------------------"
    for key in task_dict:
        list_task=[]
        task_sub_list=task_dict[key]
        for item in task_sub_list:
            
            time_attr=getattr(item,'timestamp')   #getattr() returns the value of the mentioned attribute for the invoking task object
            desc_attr=getattr(item,'description')
            
            list_task.append(dict({time_attr:desc_attr})) 
        
       
        task_sub_dict=list_task
        task=dict({key:task_sub_dict})
    
        time.sleep(2)
        t1.put(queue, task)     #Add the task to the queue
    
    print "\n"
    
    
    #List all tasks from queue in priority order
   
    t1.list_all(queue)
    
    # Remove tasks from queue in priority order
    print "Removing Tasks from Priority Queue in Highest Priority FIFO Order:"
    print "----------------------------------------------------------"
    for i in range(len(queue)):
        t1.get(queue)
    print "\n"
    
    
    #Display the current status of the queue...
    print "Current Status of the Priority Queue: "
    t1.list_all(queue)
    
    
        
