def Tupler(my_dict):
    tuppleList = []
    for name in my_dict:
        yourTuples = (name, my_dict[name])
        tuppleList.append(yourTuples)

    return tuppleList


print Tupler({
  "Speros": "(555) 555-5555",
  "Michael": "(999) 999-9999",
  "Jay": "(777) 777-7777"
})