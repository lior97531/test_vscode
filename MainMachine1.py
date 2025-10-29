import numpy as np
print("Hello World")
x=np.linspace (0,2*np.pi,100)
y=np.sin(x)
area= np.trapz(y,x)
