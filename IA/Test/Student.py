class Student:
   def __init__(self, dane):
      self.kod = dane[0];
      self.id = dane[1];
      self.plec = dane[2];
      self.region = dane[3];
      self.wyksztalcenie = dane[4];
      self.wiek = int( dane[5]);
      self.prob = int( dane[6]);
      self.punktow = int( dane[7]);
      self.zaliczenie = dane[8].split( "\n")[0];
    
   def __str__(self):
      return str(vars(self))

   def __repr__(self):
      return str(self.id) + "..."
   
def czytaj():
   for row in open("studenciOU.txt", "r"):
      if( row.strip() and not row.startswith('code_module')):
         yield Student( row.split(","))
         
def ileElementow( gen):
   return sum(1 for g in gen)
    
#print( ileElementow( czytaj()))
# w wyniku powinno wyjść 32593