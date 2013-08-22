'''
Created on Jun 15, 2013

@author: tejalgajare
'''

# Read the contents from the specified URL into an object called 'raw'
print "Reading the contents from the given URL..."
from urllib import urlopen
url = "http://www.gutenberg.org/files/2554/2554.txt"
raw = urlopen(url).read()

# Omit the white spaces present in the text by using split and store it in list variable called 'lines'
print "Omitting the white spaces..."
lines=[]
lines=raw.split()

# Omit the special characters from the obtained text by evaluating an if condition as follows:
print "Omitting the special Characters..."
list1=[]
for str1 in lines:
    token=''.join(e for e in str1 if e.isalnum()) #used 'isalnum' to check only for alpha-numeric content
    list1.append(token)                           #create a new 'list1' of extracted tokens

# Convert all the words to lower case

list1=[x.lower() for x in list1]

# Count the number of occurrences of a word as follows:

from collections import Counter, OrderedDict
D=dict(Counter(list1))                            # 'D' is a dictionary with all the words as keys and 
                                                  #  the number of occurrences as the values

# Sort dictionary 'D' and save it as 'sortedD'

sortedD=[]

sortedD = OrderedDict(sorted(D.items()))
del sortedD['']
print "Sorted Dictionary in the form of => Words : Number of Occurrences: "
print sortedD

# Plot a histogram by importing numpy and matplotlib:
print "Plotting the histogram..."
import numpy as np
import matplotlib.pyplot as plt

# Label the graph:

plt.xlabel('Words')
plt.ylabel('Number of Occurrences')
plt.title('Words-Frequency Histogram')

# Configure the axes

X = np.arange(len(sortedD))
plt.bar(X, sortedD.values(), width=1.0)
plt.xticks(X, sortedD.keys())

# Save and display the plotted histogram in the below mentioned location:

plt.savefig('MP1_Histogram.pdf')
plt.show()
print "Histogram saved successfully!"

# Create a charKeys List with all keys from sortedD:

charKeys=list(sortedD.keys())

charList=[]
i=0
ctr=total=0
n=len(charKeys)   
char1=''

# Compare the fist characters of every key with its neighboring key and add the values if a match is found

for i in range(n):  
        
        if charKeys[i] == charKeys[-1]:         # Condition for checking end of list
            break
        else:
        
            str1=str(charKeys[i])
            str2=str(charKeys[(i + 1) % n])
            
              
        if(str1[0] != char1):     # Condition for appending the values of character and ctr before the beginning of a new character
            char1=str1[0] 
            charList.append(ctr)
            charList.append(str1[0])
            ctr=1
            
        if str1[0]==str2[0]:
            ctr=ctr+sortedD.get(str1)   # Sum of the number of occurrences for each character is stored in ctr
            
        
charList.append(ctr)                    # Appending the ctr value for the last character
print "List of individual characters along with their respective occurrences:"
print charList[1:len(charList)+1]      

# Calculating the total number of words in the read text

totalWords=0
for key in sortedD:
    totalWords=totalWords+sortedD[key]
print "Total number of words are: " , totalWords
    
# Calculating the PErcentage Ratio of every character's occurrences to the total number of words

percent=0.0

charList.remove(0)

from itertools import izip          # Converting the charList to a dictionary object
i = iter(charList)
dictCharList = dict(izip(i, i))


for key in dictCharList:            # Calculating the ratio(%)
    percent=(float(dictCharList[key])/float(totalWords))*100
    print "Ratio: "
    print "Character: ", key, "=> " , percent



   
   
   

        




