import base64
ciphertext=input("Enter message to decode: ")
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
key = input("Enter encryption key: ")
stepthree = vigenere_dec(steptwoc, key)
stepfour = stepfour(stepthree)
print("Your decoded message: "+stepfour)