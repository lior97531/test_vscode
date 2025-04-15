print("Hello World")

arr=[[0.1,0,1],[-1,0.1,0],[0,-1,1]]


new_col = [1, 2, 3]

# Add the new column
for i in range(len(arr)):
    arr[i].append(new_col[i])

print(arr)

for i in range(1,3):
    for j in range(0,4):
       if(arr[i-1][j]!=0): 
        arr[i][j]=abs(arr[i][j])-(abs(arr[i][j])/abs(arr[i-1][j]))*abs(arr[i-1][j])

for row in arr:
    print(row)

    x1 = arr[3][4]/arr[3][0]
    