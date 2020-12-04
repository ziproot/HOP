#1.0:
#Released HOP Encode
#1.0.1: 
#Updated version number
#Added optimize for Discord option
#Added changelog
import base64
plaintext = input("Enter message to encode: ")
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
key=input("Enter encryption key: ")
steptwo = vigenere_enc(b36_encode(stepone(plaintext)),key)
steptwob = steptwo.encode('utf-8')
stepthree = base64.a85encode(steptwob)
stepthreeb = stepthree.decode('utf-8')
answer = False
while answer == False:
  discord = input("Optimize for discord? y or n: ")
  if(discord=="y"):
    answer = True
    stepfour = "```"+str(stepthreeb)+"h```"
  elif(discord=="n"):
    answer = True
print("Your encoded message: "+stepfour)
    stepfour = str(stepthreeb)+"h"