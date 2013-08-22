'''
Created on Jul 14, 2013

@author: tejalgajare
'''
from Tkinter import *   #Import Tkinter lib for GUI elements
import datetime,time    
from MiniProject3.task import Task  #Import the Task class

# This module is the main driver which triggers the GUI elements and calls the methods from the (imported) Task class 

# Create priority queue as a List, Declare a variable 't' for time-stamp and define a task_dict object 

if __name__ == '__main__':      #This condition is written in order to execute this program only when it is directly run.If imported it will not execute the entire program
        
    def set_text(text):             #This method is used to set text for entry widgets
        priorityVal.delete(0,END)
        priorityVal.insert(0,text)
        taskdesc.delete(0,END)
        taskdesc.insert(0,text)
        priorityVal.focus()
        return
    
    def set_text_get(obj):          #This is used to set the text for the text widget
        str1=obj[obj.keys()[0]]
        str2=obj.keys()[0]
        text.insert(INSERT,str1)
        text.insert(END,'\t')
        text.insert(END,str2)
        text.insert(END,'\n')
        
    
    task_dict={}   #Declare a global task_dict dictionary in order to store the inputs from the user in the form {prioritv:[tasks]}
    queue = []      #Declare a global queue in order to represent the priority queue
    
    
    def invokePut():        #This method is invoked when the Create Task Dictionary button is pressed
               
        t='' 
        flag=0
        t1 = Task(t, taskdesc.get())   #Create task objects by entering the time-stamp and description:read from the taskdesc entry widget
        priorityLevel=priorityVal.get()     #priorityLevel stored the user's input from priorityVal entry widget
        for key in task_dict:           
            if key==priorityLevel:      #This condition tests for any task with already existing priority level
                current_val = task_dict[key]    #If true appends the task object to the existing task list
                new_val = t1
                current_val.append(new_val)
                task_dict[key] = current_val
                flag=1
        if flag!=1:                     #Else, it will update the task_dict object with the new priorityLevel:t1 pair
            temp_task_dict={priorityLevel:[t1]}
            task_dict.update(temp_task_dict)
        
        set_text("")    #Call to clear the entry fields 
        
        
    def add2queue():            #This method is invoked when user clicks the Put button
        text.insert(END,"Adding Tasks to Priority Queue:")              #Update the Display area with the necessary text
        text.insert(END,'\n')
        text.insert(END,"-------------------------------------------------")
        text.insert(END,'\n')
        for key in task_dict:   #Add every item from the task_dict to the PQ
            list_task=[]
            task_sub_list=task_dict[key]    
            for item in task_sub_list:      #Iterating through task objects having same priority value
                time_attr=getattr(item,'timestamp')   #getattr() returns the value of the mentioned attribute for the invoking task object
                desc_attr=getattr(item,'description')
                 
                list_task.append(dict({time_attr:desc_attr})) 
             
            task_sub_dict=list_task
            task=dict({key:task_sub_dict})
            Task.put(queue, task)     #Add the task to the queue=> Call to PUT method from the Task class
            
            text.insert(END,"Added a task to the queue:")     #Update the Display area with the necessary text
            text.insert(END,'\n')
            text.insert(END,task[task.keys()[0]])
            text.insert(END," with priority ")
            text.insert(END,task.keys()[0])
            text.insert(END,'\n')
            
        
                  
    def invokeGet(): #This method is called when the user clicks the Get Button
        
        text.insert(END,"Removing Tasks from Priority Queue in Highest Priority Order:")  #Update the Display area with the necessary text
        text.insert(END,'\n')
        text.insert(END,"-------------------------------------------------")
        text.insert(END,'\n')
        # Remove tasks from queue in priority order
        for i in range(len(queue)): #Iterate through the entire PQ
            obj=Task.get(queue)     #Get the item from the queue=> Call to GET method from the Task Class
            del task_dict[obj.keys()[0]]    #Delete the corresponding task from the task_dict object too
            set_text_get(obj)   #Call to the set_text_get method in order to set the text widget
        
    def invokeListAll():    #This method is invoked when the user clicks on the List All Button
        
        l=Task.list_all(queue)
        text.insert(END,"Current State of the Priority Queue:")   #Update the Display area with the necessary text
        text.insert(END,'\n')
        text.insert(END,"-------------------------------------------------")
        text.insert(END,'\n')
        if len(l)==0:       #If the queue is empty print so on the text widget
            text.insert(END,"Priority Queue is Empty!")
        else:
            for i in l:         #else print the entire PQ
                text.insert(END,i)
                text.insert(END,'\n')
          
    #The following code is responsible for the GUI elements...      
          
    root = Tk()     #Declare a root var for Tk()
    root.wm_title("Priority Queue for Tasks")   #Update the title of the Tk window
    root.configure(background = 'light grey')   #Configure the bg color
    frame=Frame(root,bg='light grey')           #Declare a frame as a container for all other widgets
    
    label=Label(frame,text="Enter the priority value:",bg='light grey') #Declare a label for priority value
    label.pack()        #Place the label on the frame
    
    priorityVal = Entry(frame, bd =5,bg='light blue')   #Declare the entry widget for the priority value
    priorityVal.focus()             #Set focus on this entry widget when the application laods
    priorityVal.pack()              #Place it on the frame
    
    label1=Label(frame,text="Enter the task description:",bg='light grey')  #Declare a label for task description value
    label1.pack()                     #Place it on the frame
    
    taskdesc = Entry(frame, bd =5,bg='light blue')          #Declare the entry widget for the task description value
    taskdesc.pack()                  #Place it on the frame
    
    createTaskDict=Button(frame, text="Create Task Dictionary" ,command=invokePut) #Declare a button for creating a task dictionary
    
    createTaskDict.pack()    #Place it on the frame
    
    lFrame=LabelFrame(root,text="Display Area",bg='light grey') #Declare a labeled frame as a container for the text widget
    lFrame.pack(side=LEFT)  #Place it on the root 
    
    text=Text(lFrame,bg='light blue')   #Declare a text widget and place it on the lframe
    text.pack(side=LEFT)        #Position is left
    
    
    putButton = Button(frame, text="Put" ,command=add2queue)    #Declare a button for Put
    putButton.pack(side=LEFT)
    
    getButton = Button(frame, text="Get",command=invokeGet)     #Declare a button for Get
    getButton.pack(side=LEFT)
    
    listAllButton = Button(frame, text="List All",command=invokeListAll) #Declare a button for List All
    listAllButton.pack()
    
    frame.pack()        
    root.mainloop()         #Enter the main event loop to take action against each event triggered by the user