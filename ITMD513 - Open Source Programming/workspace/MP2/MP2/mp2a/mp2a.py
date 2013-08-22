'''
Created on Jun 17, 2013

@author: tejalgajare
'''

#import required lib...
import datetime,time

# Define get(),put() and list_all() methods...

#get() method accepts list1 as the parameter which corresponds to the priority queue...
def get(list1):
    
    t = list1.pop(0)    #remove the first element from the queue with highest priority... 
    print "Removed a task from the queue: %s with priority %s" % (t[t.keys()[0]],t.keys()[0])
    return t

#put() methods contains 2 parameters with list1 corresponding to the queue and task=>task to be inserted into the queue
def put(list1, task):
    d={}
    d1=[]
    pv=task.keys()  #pv is the priority value of the to be inserted task
    d=task[key]     #d is the list of dictionaries with task details : time-stamp and descriptions respectively
    
    for k,v in d.items():   #in order to add the time-stamp equivalent to the current system date/time for each task iterate through d
        if type(d) is dict:
            now=datetime.datetime.now() #Assign the current date/time to now variable
            d3=dict([(k.replace(k,str(now)),v)])    #replace the original key with the now variable for saving the current time-stamp
            d1.append(d3)               #Save the dictionary with the changed keys in d1

    new_task=dict.fromkeys(pv,d1)   #Form a dictionary element consisting of pv as key and d1 as the dictionary element
    
    d=new_task[new_task.keys()[0]]      #save the values for later reference
    priorityLevel=new_task.keys()[0]
    
    list1.append(new_task)      #Append the priority queue=> list1 with the new task
    list1.sort(key=lambda pk: pk.keys()[0], reverse=False)      #Sort the queue based on the key(Priority value)
    print "Added a task to the queue: %s with priority %s" % (d,priorityLevel)  

#This method lists all the elements present in the queue...
def list_all(list1):
    
    print "Current State of the Priority Queue:"
    print "----------------------------------------------------------"
    print "Number of items in queue: %s" % len(queue)
    for i in queue:
        print i 
    
# Create priority queue as a List, Declare a variable 't' for time-stamp and define a task_dict object 

#Initiating the time-stamp values to null string...
t01=t02=t11=t12=t21=t22=t31=t32=t41=t42=t51=t52=t61=t62=t71=t72=t81=t82=t91=t92=''
queue = []

#Following are the declared dictionaries to have time-stamp for every key item and description as value
D0=dict(t01="ITunes",t02="Safari")
D1=dict(t11="Chrome",t12="NotePad")
D2=dict(t21="Quick Media",t22="Jabber")
D3=dict(t31="Mozilla",t32="Eclipse")
D4=dict(t41="NetBeans",t42="Unix")
D5=dict(t51="MsPaint",t52="MsWord")
D6=dict(t61="MsExcel",t62="MsPowerPoint")
D7=dict(t71="Facetime",t72="CorelDraw")
D8=dict(t81="AngryBirds",t82="Solitaire")
D9=dict(t91="Terminal",t92="VPN")

#task_dict corresponds to the queue format...
task_dict= {'2': D2 ,'0':D0,'5':D5,'9':D9,'3':D3}

# Load queue with test data
print "Adding Tasks to Priority Queue:"
print "----------------------------------------------------------"
for key in task_dict:
 
    task_sub_dict=task_dict[key]
    task=dict({key:task_sub_dict})  #Create the task object in the required format of the priority queue...
    time.sleep(2)                   #Inserted a wait statement in order to introduce a lag between two task's timestamps
    put(queue, task)                #Call put()

print "\n"

#print "Current Status of the Priority Queue: "
list_all(queue)                     #Call list_all()

# Remove tasks from queue in priority order
print "Removing Tasks from Priority Queue in Highest Priority FIFO Order:"
print "----------------------------------------------------------"
for i in range(len(queue)):
    get(queue)                      #Call get() for every element in the queue
print "\n"

print "Current Status of the Priority Queue: "
list_all(queue)                     #Display the queue status

