#Thonda Taylor II
#Evil Hangman Program
import string

#Greets the user prompts then to enter a word length
def greet():
  print 'Welcome to Hangman, The Game to End All Games!'
  print ''
  print 'The rules are as follows enter the a word length that is neither negative nor too long for your own good!'

#Reads in the text file of words loops over the list and prints it out for testing
def readFile(filename):
  inputFile = open(filename, 'r')
  for line in inputFile:
    print line

#Prompts the user for a word length sets that variable then constructs a list / dictionary
#that holds all the words that have the designated word length
def listConstruction(filename):
  print 'Time for your losing to Begin... Are you ready?'
  print ''
  print 'Give me a number that will represent the length of the word you are trying to guess.'
  #Sets the word length variable based of rawinput value given by user
  wordLength = input("Enter the word length that you would like to have :^)... ")
  #Shows the user the word
  print 'wordLength is: '+ str(wordLength)
  inputFile = open(filename, 'r').read().split()
  wordList = []
  wordList = inputFile
  wordDict = {}
  if wordLength in wordDict:
    return wordDict[wordLength]
  outputList = [word for word in wordList if len(word) == wordLength]
          #Key              #Value
  wordDict['allWordsKey'] = outputList
  #prints the overall dashed out version of the word to guess
  print "Here is your word ",'-'*wordLength
  
  return wordLength, wordDict

#I want to pull the correct elements from dict here 
#Create and initialize counter for the number of guesses that remain
#Prompts the user for a single letter guess
def characterGuess(aWordLength, mainDict):
  gameDict = mainDict
  #Prompts user to give the # of guesses they would like to have
  numGuesses = input("How many guesses do you want to have?")
  print ''
  #Asks the user whether they would like to see how many words are left in the
  #dictionary to choose from y for yes and n for no
  seeWordCount = raw_input("Do you want to see the number of words left in the dictionary? Enter y or n")
  while (not (seeWordCount.lower() == "y" or seeWordCount.lower() == "n")):
           seeWordCount = raw_input("Please enter y or n")
  guessList = []
  dashes = aWordLength*'-'
  dash = '-'
    
  #Run until until number of Guesses is zero or
  #the user has won the game
  while numGuesses != 0:
      #Gets the single letter guess from the user
      letterGuessed = raw_input("Enter a single letter guess that is exactly 1 letter long, and is a letter of the alphabet: ")
      print ''
      #Process putting the letterGuessed into a list
      #Check input length - Input Error Checking
      if len(letterGuessed) != 1:
        print 'Please enter a single letter... Nothing more... Nothing less! :^)'
      #if it is in the list tell the user they already guessed that letter
      elif letterGuessed in guessList:
          print 'You have already guessed that letter. Please pick another one!'
          print ''
      #if not in the list --> then add it to the list
      #substract from the overall guess total by one each time this if
      #statement occurs    
      else:
          numGuesses = numGuesses - 1
          print 'You now have '+str(numGuesses)+' guesses left to play with... Be wiser my friend!'
        
          #If the user enters a yes, get the length of the value of the first key
          if (seeWordCount.lower() == "y"):
             print "There are ", len(gameDict[gameDict.keys()[0]]),"words left"
             
          guessList.append(letterGuessed)
          #works on the words in the game dictionary
          gameDict = partitionWordsFromDictionary(letterGuessed, gameDict)
        
          #Change hangman words according to the game dictionary and the users' guess
          dashes = changeDashWord(gameDict, dashes)
          #prints for debugging purposes
          print "Here is the hangman word: [",dashes,"]"
          #Replace blanks with correctly guessed letters         
      if (not(dash in dashes)):
       print 'Awwww shucks looks like you beat me! Never Again!!!!'
       numGuesses = 0
      #Setting numGuesses to zero here ensures they have run out of guesses and lost the game 
      if (numGuesses == 0):
        print 'You lost if you would like another shot at beating my re-run the program to try again :^)'

  
       
  return letterGuessed        
              
def changeDashWord(aGameDict, aDashes):
  
  #Get the first key in the dictionary
  aGameDictsKey = aGameDict.keys()[0]
  #Work on the hangman word
  if(aGameDictsKey == 'wrongLetterGuess'):
    return aDashes
    print 'Im truly sorry your not that good at guessing, however that letter is not in the word!!! HaHaHa.. Try Again!'
  else:
    #Makes a new dash for the specified key
    subIndex = 0
    for i in aGameDictsKey:
      if(not(i == '-')):
        aDashes = aDashes[:subIndex] + i + aDashes[subIndex+1:]
      subIndex = subIndex + 1
  return aDashes

#I end up not having to utilize this method because I check
#if the key is a 'wrongLetterGuess' in the
#longDashFinder() method
def partitionWordsFromDictionary(aLetter, theDict):
  
  #Will do all of the interweaving last
  #Working towards functionality now
  
  #Works on returning a list of the keys in the dictionary
  #Selectes the first one then takes the value of its
  #associated key
  iterWordList = theDict[theDict.keys()[0]]
  iterWordDict = {}
  #I need to find the word in the list first!!!
  for eachWord in iterWordList:
    #Getting the dashes variable from above for each word
    dash = makeDictDashed(eachWord, aLetter)
    if(aLetter in eachWord):
      if(dash in iterWordDict):
        iterWordDict[dash].append(eachWord)
      else:
        iterWordDict[dash] = [eachWord]
    elif(not(aLetter in eachWord)):
      if('wrongLetterGuess' in iterWordDict):
        iterWordDict['wrongLetterGuess'].append(eachWord)
      else:
        iterWordDict['wrongLetterGuess'] = [eachWord]
 
  iterWordDict = longestDashFinder(iterWordDict)
 
  return iterWordDict    


def longestDashFinder(dashDict):
  
  #Dictionary that picks the correct dash to "cheat" with
  pickDashDict = {}
  #List that holds the values for a single dash
  valueList = []
  #theMaxSize variable to determine the correct size to choose
  theMaxSize = 0
  #key value that holds the dashes type
  newDashKey = ''
  #Need to iterate over all the keys in the dictionary
  dashDictKeys = dashDict.keys()
  for i in dashDictKeys:
    if(len(dashDict[i]) > theMaxSize):
      theMaxSize = len(dashDict[i])
      valueList = dashDict[i]
      newDashKey = i
    #If the patters / keys match choose the one with the
    #wrongLetterGuess field instead  
    if(len(dashDict[i]) == theMaxSize and (i == 'wrongLetterGuess')):
      valueList = dashDict[i]
      newDashKey = i
  #Takes all the keys from above and moves a single key
  #to this new dictionary
  pickDashDict = {newDashKey : valueList}
  return pickDashDict   
       
#First method I created to make a dashed out instance of
#the users input letter
#Never utilized in the program
def makeDictDashed(singleWord, xLetter):
  g = ''
  for i in singleWord: #once you get y here then do this
      if i == str(xLetter):
        g += i
        #print i
      else:
        g += '-'
        #print '-'
  return g

#Runs the program
def main():
  greet()
  print ''
  length, mainDict=listConstruction('dictionary.txt')
  characterGuess(length, mainDict)
  #itrDict = partitionWordsFromDictionary(aDict)

main()  
