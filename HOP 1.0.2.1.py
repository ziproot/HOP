#Changelog:
  #HOP Encode
    #1.0:
      #Released HOP Encode
    #1.0.1: 
      #Updated version number
      #Added optimize for Discord option
      #Added changelog
  #HOP Decode
    #1.0:
      #Released HOP decode
    #1.0.1:
      #Updated version number to match that of HOP  Encode
      #Added changelog
  #HOP
    #1.0.2:
      #Combined HOP Encode and HOP Decode
      #Integrated GitHub and repl.it
      #Added several files, including .replit, CODE_OF_CONDUCT.md, CONTRIBUTING.md, README.md, and SECURITY.md
      #Moved input, print, and import statements outside functions
      #Added ability to choose on runtime encode or decode
    #1.0.2.1:
      #Made changes to show that the "optimize for Discord" option also supports Element/Matrix, IRC, Joplin, etc.

import base64
def decode(ciphertext, key):
  steponel = list(ciphertext)
  stepone = ""
  for i in range(len(steponel)-1):
    stepone=stepone+steponel[i]
  steptwo = stepone.encode('utf-8')
  steptwob = base64.a85decode(steptwo)
  steptwoc = steptwob.decode('utf-8')
  def vigenere_dec(cipher,key):
    alphabet = "abcdefghijklmnopqrstuvwxyz0123456789"
    input_string = ""
    dec_key = ""
    dec_string = ""
    dec_key = key
    dec_key = dec_key.lower()
    input_string = cipher
    input_string = input_string.lower()
    string_length = len(input_string)
    expanded_key = dec_key
    expanded_key_length = len(expanded_key)
    while expanded_key_length < string_length:
      expanded_key = expanded_key + dec_key
      expanded_key_length = len(expanded_key)
    key_position = 0
    for letter in input_string:
      if letter in alphabet:
        position = alphabet.find(letter)
        key_character = expanded_key[key_position]
        key_character_position = alphabet.find(key_character)
        key_position = key_position + 1
        new_position = position - key_character_position
        if new_position > 35:
          new_position = new_position + 36
        new_character = alphabet[new_position]
        dec_string = dec_string + new_character
      else:
        dec_string = dec_string + letter
    return(dec_string)
  def stepfour(stepthree):
    stepthree=str(int(stepthree,36))
    test = list(stepthree)
    if len(test)%3==1:
      stepthree="00"+stepthree
    if len(test)%3==2:
      stepthree="0"+stepthree
    stepthreel = list(stepthree)
    stepfourl = [""]*int((float(len(stepthreel))/3))
    k = 0
    while k < len(stepthreel)-2:
      stepfourl[int(k/3)] = stepthreel[k] + stepthreel[k+1] + stepthreel[k+2]
      k = k + 3
    for j in range(len(stepfourl)):
      temp = stepfourl[j]
      temp = int(temp)
      temp = chr(temp)
      stepfourl[j] = temp
    stepfour=""
    for l in range(len(stepfourl)):
      stepfour = stepfour + stepfourl[l]
    return(stepfour)
  stepthree = vigenere_dec(steptwoc, key)
  stepfour = stepfour(stepthree)
  output = "Your decoded message: "+stepfour
  return output;
def encode(plaintext, key):
  def b36_encode(i):
      if i < 0: return "-" + b36_encode(-i)
      if i < 36: return "0123456789abcdefghijklmnopqrstuvwxyz"[i]
      return b36_encode(i // 36) + b36_encode(i % 36) 
  def stepone(plaintext):
    magicasciipowers = list(plaintext)
    numbersgohere = [""]*len(magicasciipowers)
    for i in range(len(magicasciipowers)):
      temp = magicasciipowers[i]
      temp = ord(temp)
      if (temp<100):
        numbersgohere[i]="0"+str(temp)
      else:
        numbersgohere[i]=str(temp)
    numbers = ""
    for i in range(len(numbersgohere)):
      numbers=numbers+numbersgohere[i]
    return(int(numbers))
  def vigenere_enc(stepone,key):
    alphabet = "abcdefghijklmnopqrstuvwxyz0123456789"
    input_string = ""
    enc_key = ""
    enc_string = ""
    enc_key = key
    enc_key = enc_key.lower()
    input_string = stepone
    input_string = input_string.lower()
    string_length = len(input_string)
    expanded_key = enc_key
    expanded_key_length = len(expanded_key)
    while expanded_key_length < string_length:
      expanded_key = expanded_key + enc_key
      expanded_key_length = len(expanded_key)
    key_position = 0
    for letter in input_string:
      if letter in alphabet:
        position = alphabet.find(letter)
        key_character = expanded_key[key_position]
        key_character_position = alphabet.find(key_character)
        key_position = key_position + 1
        new_position = position + key_character_position
        if new_position > 35:
          new_position = new_position - 36
        new_character = alphabet[new_position]
        enc_string = enc_string + new_character
      else:
        enc_string = enc_string + letter
    return(enc_string)
  steptwo = vigenere_enc(b36_encode(stepone(plaintext)),key)
  steptwob = steptwo.encode('utf-8')
  stepthree = base64.a85encode(steptwob)
  stepthreeb = stepthree.decode('utf-8')
  stepfour = str(stepthreeb)+"h"
  answer = False
  while answer == False:
    mdsupport = input("Optimize for markdown supported services, like Discord, Element/Matrix, Joplin, or IRC? y or n: ")
    if(mdsupport=="y"):
      answer = True
      stepfour = "```"+str(stepthreeb)+"h```"
    elif(mdsupport=="n"):
      answer = True
  output="Your encoded message: "+stepfour
  return output
var = input("Encode or Decode? 1 for encode, 2 for decode: ")
if (var=="1"):
  ciphertext = input("Enter message to encode: ")
  key = input("Enter encryption key: ")
  print(encode(ciphertext, key))
elif (var=="2"):
  plaintext = input("Enter message to decode: ")
  key = input("Enter encryption key: ")
  print(decode(plaintext, key))
